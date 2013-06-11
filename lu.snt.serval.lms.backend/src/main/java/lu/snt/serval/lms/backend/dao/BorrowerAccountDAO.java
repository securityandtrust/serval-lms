package lu.snt.serval.lms.backend.dao;


import lu.snt.serval.lms.backend.dto.BorrowerAccountDTO;
import lu.snt.serval.lms.backend.dto.UserDTO;
import lu.snt.serval.lms.backend.spec.BorrowerAccountDAOInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class BorrowerAccountDAO implements BorrowerAccountDAOInterface {
	private static JdbcTemplate jdbcTemplate;
	
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    private static BorrowerAccountDAO ourInstance = new BorrowerAccountDAO();

    public static BorrowerAccountDAO getInstance() {
        return ourInstance;
    }

    public BorrowerAccountDTO loadUserBorrowerAccount(UserDTO userDTO) throws DAOException, SQLException {
        String query = "SELECT * from borrower_account where id_user = ?";
        
        List<BorrowerAccountDTO> l = this.jdbcTemplate.query(query, new Object[] {new Integer(userDTO.getId_user())}, 
        		new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            	BorrowerAccountDTO ba = new BorrowerAccountDTO();
                ba.setActive(rs.getInt("active"));
                ba.setCan_borrow(rs.getInt("can_borrow"));
                ba.setCreation_date(rs.getDate("creation_date"));
                ba.setId_borrower_account(rs.getInt("id_borrower_account"));
                ba.setId_user(rs.getInt("id_user"));
                return ba;
            }
        });
        
        // if the size is not equal to 1 rise an exception
        if (l.size() != 1)
            throw new DAOException("Borrow size not correct! equals to " + l.size() + " must be 1.");

        BorrowerAccountDTO result = l.iterator().next();

        return result;
    }
    
    public List<BorrowerAccountDTO> loadAllBorrowerAccounts() {
        String query = "SELECT * from borrower_account";
        
        List<BorrowerAccountDTO> l = this.jdbcTemplate.query(query, new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            	BorrowerAccountDTO ba = new BorrowerAccountDTO();
                ba.setActive(rs.getInt("active"));
                ba.setCan_borrow(rs.getInt("can_borrow"));
                ba.setCreation_date(rs.getDate("creation_date"));
                ba.setId_borrower_account(rs.getInt("id_borrower_account"));
                ba.setId_user(rs.getInt("id_user"));

                return ba;
            }
        });
        
        return l;
    }
    
    public BorrowerAccountDTO insert(UserDTO userDTO, BorrowerAccountDTO borrowerAccountDTO) throws SQLException {
    	 Date dateCreation = null;
         
    	 if(borrowerAccountDTO.getCreation_date() != null)
        	 dateCreation =  new Date(borrowerAccountDTO.getCreation_date().getTime());
         
         String query = "INSERT INTO borrower_account (creation_date, active, can_borrow, id_user) VALUES (?,?,?,?)";
         
         this.jdbcTemplate.update(query, 
          		new Object[] { dateCreation, new Integer(borrowerAccountDTO.getActive()),
     			 	new Integer(borrowerAccountDTO.getCan_borrow()), new Integer(userDTO.getId_user()) });
         
         // get the last id
         query = "SELECT MAX(id_borrower_account) FROM borrower_account";
         int id = this.jdbcTemplate.queryForInt(query);

         //update book id
         if (id > 0)
             borrowerAccountDTO.setId_borrower_account(id);

         
         return borrowerAccountDTO;
     }

     public void update(BorrowerAccountDTO borrowerAccountDTO) throws SQLException {
         String query = "UPDATE borrower_account SET active = ?, can_borrow = ?, creation_date = ? where id_user = ";
         
         this.jdbcTemplate.update(query, 
             	new Object[] {
         			new Integer(borrowerAccountDTO.getActive()), new Integer(borrowerAccountDTO.getCan_borrow()), 
         			new Date(borrowerAccountDTO.getCreation_date().getTime()), new Integer(borrowerAccountDTO.getId_user())
         		});
     }

     public void delete(BorrowerAccountDTO borrowerAccountDTO) throws SQLException {
         String query = "DELETE FROM borrower_account WHERE id_borrower_account = ?";
         
         this.jdbcTemplate.update(query, new Object[]{ new Integer(borrowerAccountDTO.getId_borrower_account()) });
     }
}
