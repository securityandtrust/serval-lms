package lu.snt.serval.lms.dao;

import lu.snt.serval.lms.dao.dto.PersonnelAccountDTO;
import lu.snt.serval.lms.dao.dto.UserDTO;
import lu.snt.serval.lms.dao.spec.PersonnelAccountDAOInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


public class PersonnelAccountDAO implements PersonnelAccountDAOInterface {
	
	private static JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    private static PersonnelAccountDAO ourInstance = new PersonnelAccountDAO();

    public static PersonnelAccountDAO getInstance() {
        return ourInstance;
    }
    
     public PersonnelAccountDTO loadUserPersonnelAccount(UserDTO userDTO) throws SQLException, DAOException {
        String query = "SELECT * from personnel_account where id_user = ?";
        
        List<PersonnelAccountDTO> l = this.jdbcTemplate.query(query, new Object[] {new Integer(userDTO.getId_user())}, 
        		new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            	PersonnelAccountDTO pa = new PersonnelAccountDTO();
                pa.setActive(rs.getInt("active"));
                pa.setCan_consult(rs.getInt("can_consult"));
                pa.setCreation_date(rs.getDate("creation_date"));
                pa.setId_personnel_account(rs.getInt("id_personnel_account"));
                pa.setId_user(rs.getInt("id_user"));
                return pa;
            }
        });
        
        // if the size is not equal to 1 rize an exception
        if(l.size() != 1)
        	throw new DAOException("Personnel account collection size not correct! it equals to " + l.size() + " but must be 1.");


        PersonnelAccountDTO result = l.iterator().next();

        return result;
    }
     
     public List<PersonnelAccountDTO> loadAllPersonnelAccounts() {
         String query = "SELECT * from personnel_account";
         
         List<PersonnelAccountDTO> l = this.jdbcTemplate.query(query, new RowMapper() {
             public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            	 PersonnelAccountDTO pa = new PersonnelAccountDTO();
            	 pa.setActive(rs.getInt("active"));
                 pa.setCan_consult(rs.getInt("can_consult"));
                 pa.setCreation_date(rs.getDate("creation_date"));
                 pa.setId_personnel_account(rs.getInt("id_personnel_account"));
                 pa.setId_user(rs.getInt("id_user"));
                 
                 return pa;
             }
         });
         
         return l;
     }


     public PersonnelAccountDTO insert(UserDTO userDTO, PersonnelAccountDTO personnelAccountDTO) throws SQLException {
    	 String query = "INSERT INTO personnel_account (creation_date, active, can_consult, id_user) VALUES (?,?,?,?)";

    	 this.jdbcTemplate.update(query, 
         		new Object[] { new Date(personnelAccountDTO.getCreation_date().getTime()), new Integer(personnelAccountDTO.getActive()),
    			 	new Integer(personnelAccountDTO.getCan_consult()), new Integer(userDTO.getId_user()) });

         // get the last id
         query = "SELECT MAX(id_personnel_account) FROM personnel_account";
         int id = this.jdbcTemplate.queryForInt(query);

         //update book id
         if (id > 0)
             personnelAccountDTO.setId_personnel_account(id);

         return personnelAccountDTO;
    }

    public void update(PersonnelAccountDTO personnelAccountDTO) throws SQLException {       
        String query = "UPDATE personnel_account SET " +
                "active = ?, can_consult = ?, creation_date = ?, id_user = ? WHERE id_personnel_account = ?";
        
        this.jdbcTemplate.update(query, 
            	new Object[] {
        			new Integer(personnelAccountDTO.getActive()), new Integer(personnelAccountDTO.getCan_consult()), 
        			new Date(personnelAccountDTO.getCreation_date().getTime()), new Integer(personnelAccountDTO.getId_user()),
        			new Integer(personnelAccountDTO.getId_personnel_account())
        		});
    }

    public void delete(PersonnelAccountDTO personnelAccountDTO) throws SQLException {
         String query = "DELETE FROM personnel_account WHERE id_personnel_account = ?";
         
         this.jdbcTemplate.update(query, new Object[]{ new Integer(personnelAccountDTO.getId_personnel_account()) });
    }
}
