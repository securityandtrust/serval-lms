package lu.snt.serval.lms.dao;


import lu.snt.serval.lms.dao.dto.BookDTO;
import lu.snt.serval.lms.dao.dto.UserDTO;
import lu.snt.serval.lms.dao.spec.UserDAOInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class UserDAO implements UserDAOInterface {
	private static JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    // role modes
    public static final String PERSONNEL_LOGIN_MODE = "PERSONNEL", BORROWER_LOGIN_MODE = "BORROWER";

    private static UserDAO ourInstance = new UserDAO();

    public static UserDAO getInstance() {
        return ourInstance;
    }

    public UserDTO insertUser(UserDTO user) {
    	String query = "INSERT INTO users (login,password,name,mail,phone) VALUES (?,?,?,?,?)";

    	this.jdbcTemplate.update(query, 
    			new Object[] { user.getLogin(), user.getPassword(), user.getName(), user.getMail(), user.getPhone() });
    	
        // get the last id
        query = "SELECT MAX(id_user) FROM users";
        int id = this.jdbcTemplate.queryForInt(query);

        //update user id
        if (id > 0)
            user.setId_user(id);
            
        return user;
    }

    public void updateUser(UserDTO user) {
        String query = "UPDATE users SET login = ?, password = ?, name = ?, mail = ?, phone = ? " +
                "WHERE id_user = ?";
        
        this.jdbcTemplate.update(query, 
            	new Object[] {
        			user.getLogin(), user.getPassword(), user.getName(), user.getMail(),
        			user.getPhone(), new Integer(user.getId_user())
        		});
        
        //TODO: why return new UserDTO()?
    }

    public void deleteUser(UserDTO user) {
    	String query = "DELETE FROM reservations WHERE id_user = ?";
    	this.jdbcTemplate.update(query, new Object[]{ new Integer(user.getId_user()) });
    	
    	query = "DELETE FROM borrowed WHERE id_user = ?";
    	this.jdbcTemplate.update(query, new Object[]{ new Integer(user.getId_user()) });
            	
    	query = "DELETE FROM users WHERE id_user = ?";
    	this.jdbcTemplate.update(query, new Object[]{ new Integer(user.getId_user()) });
    }

    public void insertUserRole(UserDTO user, String role) {
    	String query = "INSERT INTO roles (id_user,role) VALUES (?,?)";
    	
    	this.jdbcTemplate.update(query, 
    			new Object[] { new Integer(user.getId_user()), role });
    }

    public void deleteUserRole(UserDTO user, String role) {
    	String query = "DELETE FROM roles WHERE id_user = ? AND role = ?";
    	
    	this.jdbcTemplate.update(query, new Object[]{ new Integer(user.getId_user()), role });
    }

    public boolean checkLoginAndPassword(UserDTO user) {
    	boolean testResult;
    	
    	String query = "SELECT * FROM users WHERE login = ? AND password = ?";
    	List<UserDTO> r = this.jdbcTemplate.queryForList(query, new Object[] { user.getLogin(), user.getPassword() });
        
    	testResult = (r != null && r.size() > 0) ? true : false;

        return testResult;
    }

    public UserDTO loadUserFromLoginAndPassword(UserDTO user) throws DAOException {
    	UserDTO userDTOResult;
    	
    	String query = "SELECT * FROM users WHERE login = ? AND password = ?";
    	//List<UserDTO> r = this.jdbcTemplate.queryForList(query, new Object[] { user.getLogin(), user.getPassword() });
    	List<UserDTO> r = this.jdbcTemplate.query(query, new Object[] { user.getLogin(), user.getPassword() }, new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            	UserDTO u = new UserDTO();
                u.setLogin(rs.getString("login"));
                u.setPassword(rs.getString("password"));
                u.setId_user(rs.getInt("id_user"));
                u.setMail(rs.getString("mail"));
                u.setName(rs.getString("name"));
                u.setPhone(rs.getString("phone"));
                return u;
            }
        });

        // many users found there is a problem
        if (r != null && r.size() != 1)
            throw new DAOException("List of users size not correct! equals to " + r.size() + " must be 1.");

        userDTOResult = r.iterator().next();

        return userDTOResult;
    }
    
    public UserDTO loadUserFromId(int id) throws DAOException {
    	UserDTO userDTOResult;
    	
    	String query = "SELECT * FROM users WHERE id_user = ?";
    	
    	List<UserDTO> l = this.jdbcTemplate.query(query, new Object[] { new Integer(id) }, 
        		new RowMapper() {
            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            	UserDTO u = new UserDTO();
            	u.setLogin(rs.getString("login"));
                u.setMail(rs.getString("mail"));
                u.setName(rs.getString("name"));
                u.setPassword(rs.getString("password"));
                u.setPhone(rs.getString("phone"));
                u.setId_user(rs.getInt("id_user"));
                return u;
            }
        });

        // many users found there is a problem
        if (l != null && l.size() != 1)
            throw new DAOException("UserDTO Id must be unique! currently equals to " + l.size());

        userDTOResult = l.iterator().next();

        return userDTOResult;
    }

    public Collection<UserDTO> loadUserReservingBook(BookDTO book) {
    	String query = "SELECT users.* FROM users,reservations WHERE users.id_user = reservations.id_user  AND "
                + " reservations.id_book = ?";

    	return this.jdbcTemplate.queryForList(query, new Object[] { new Integer(book.getId_book()) });
    }

    public UserDTO loadUserBorrowingBook(BookDTO book) throws DAOException {
        String query = "SELECT users.* FROM users, borrowed WHERE users.id_user = borrowed.id_user AND "
                + " borrowed.id_book = ?";
        Collection<UserDTO> result = this.jdbcTemplate.queryForList(query, new Object[] { new Integer(book.getId_book()) });

        // if the size is not equal to 1 rise an exception
        if (result.size() != 1)
            throw new DAOException("Borrow size not correct! equals to " + result.size() + " BUT must be 1.");

        UserDTO user = result.iterator().next();

        return user;
    }

    public String checkUserRoleMatch(UserDTO user, String roleMode) throws DAOException {
        String query, wherePart;
        
        // built the query
        wherePart = "";
        if (roleMode.equals(PERSONNEL_LOGIN_MODE))
            wherePart = " (role = 'LIBRARIAN' OR role='ADMIN' OR role='SECRETARY' OR role='DIRECTOR')";
        else if (roleMode.equals(BORROWER_LOGIN_MODE))
            wherePart = " (role = 'BORROWER' OR role='STUDENT' OR role='LECTURER')";

        // prepares the query
        query = "SELECT role FROM roles WHERE roles.id_user = ? AND " +
                wherePart;      
        
        List<String> result = this.jdbcTemplate.query(query, new Object[] { new Integer(user.getId_user()) }, new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            	String role = rs.getString("role");
                return role;
            }
        });

        // if the size is not equal to 1 rise an exception
        if (result.size() != 1)
            throw new DAOException("Role size not correct! equals to " + result.size() + " BUT must be 1.");

        String role = (String) result.iterator().next();

        return role;
    }

}
