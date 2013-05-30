package lu.snt.serval.lms.dao;


import lu.snt.serval.lms.dao.dto.BookDTO;
import lu.snt.serval.lms.dao.dto.UserDTO;
import lu.snt.serval.lms.dao.spec.BookDAOInterface;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

/**
 * DB service is a singleton class
 * It provide access to the DataBase Library.
 * Many services are provided :
 * - login check
 * - book related services
 * etc ...
 */
public class BookDAO implements BookDAOInterface {
	private static JdbcTemplate jdbcTemplate;
	
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    private static BookDAO ourInstance = new BookDAO();

    public static BookDAO getInstance() {
    	return ourInstance;
    }

    
 // JDBC-backed implementations of the methods on BookDAOInterface Service
    public Collection<BookDTO> findBooksByState(String state) {
        String query = "SELECT * FROM books WHERE state = ?";
        
        List<BookDTO> l = this.jdbcTemplate.query(query, new Object[] {new String(state)}, new RowMapper() {

            public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
            	BookDTO b = new BookDTO();
                b.setAuthor(rs.getString("author"));
                b.setDamaged(rs.getInt("damaged"));
                b.setId_book(rs.getInt("id_book"));
                b.setPages(rs.getInt("pages"));
                b.setPub_year(rs.getInt("pub_year"));
                b.setState(rs.getString("state"));
                b.setTitle(rs.getString("title"));
                return b;
            }
        });
        
        return l;
    }


    public Collection<BookDTO> seachBooksByKeyword(String keyword) {
    	String query = "SELECT * FROM books WHERE title LIKE ?";
    	//TODO: SELECT * FROM library.books where title like '%Soft%';
    	//TODO: "SELECT * FROM books WHERE title LIKE '%" + keyword + "%';";
        return this.jdbcTemplate.queryForList(query, new Object[] {new String("%" + keyword + "%")});
    }
    
    public BookDTO findBookById(int id) throws DAOException {    	
        //String query = "SELECT * FROM books WHERE id_book = ?";
            
        //Collection<BookDTO> r = this.jdbcTemplate.queryForList(query, new Object[] {new Integer(id)});
    	
    	// if many books found, there is a problem
        //if (r != null && r.size() != 1)
        //    throw new DAOException("BookDTO Id must be unique! currently equals to " + r.size());
        
        BookDTO b = new BookDTO();
        b.setId_book(id);
        
        return b;
    }

    public void update(BookDTO book) {
        String query= "UPDATE books SET title = ?, author = ?, pub_year = ?, pages = ?, state = ?, damaged = ?" +
                "WHERE id_book = ?";
        
        this.jdbcTemplate.update(query, 
        	new Object[] {
    			book.getTitle(), book.getAuthor(), new Integer(book.getPub_year()), new Integer(book.getPages()),
    			book.getState(), new Integer(book.getDamaged()), book.getId_book()
    		});
       //TODO: why return new BookDTO();
    }

    public void insert(BookDTO book) {
        String query = "INSERT INTO books (title, author, pub_year, pages, state) VALUES (?,?,?,?,?)";
        
        this.jdbcTemplate.update(query, 
        		new Object[] { book.getTitle(), book.getAuthor(), new Integer(book.getPub_year()), 
        		new Integer(book.getPages()), book.getState() });
        
        // get the last id
        query = "SELECT MAX(id_book) FROM books";        
        int id = this.jdbcTemplate.queryForInt(query);
        
        //update book id
        if (id > 0)
            book.setId_book(id);
       
        //return book;
    }

    public Collection<BookDTO> loadUserReservedBooks(UserDTO user) {
        String query = "SELECT books.* FROM books, reservations WHERE books.id_book = reservations.id_book AND "
                + " reservations.id_user = ?";

        return this.jdbcTemplate.queryForList(query, new Object[] { new Integer(user.getId_user()) });
    }

    public Collection<BookDTO> loadUserBorrowedBooks(UserDTO user) {
    	String query = "SELECT books.* FROM books, borrowed WHERE books.id_book = borrowed.id_book AND "
                + " borrowed.id_user = ?";
    	
    	return this.jdbcTemplate.queryForList(query, new Object[] { new Integer(user.getId_user()) });
    }

    public void insertBorrow(UserDTO user, BookDTO book) {
        String query = "INSERT INTO borrowed (id_user, id_book) VALUES (?,?)";

        this.jdbcTemplate.update(query, new Object[] { new Integer(user.getId_user()), new Integer(book.getId_book()) });
    }

    public void insertReservation(UserDTO user, BookDTO book) {
        String query = "INSERT INTO reservations (id_book, id_user) VALUES (" + book.getId_book() +
                "," + user.getId_user() + ");";

        this.jdbcTemplate.update(query, new Object[] { new Integer(book.getId_book()), new Integer(user.getId_user()) });
    }

    public void deleteBorrow(UserDTO user, BookDTO book) {
       // default value if false
       String query = "DELETE FROM borrowed WHERE id_book = ? AND id_user = ?";
       
       this.jdbcTemplate.update(query, new Object[]{ new Integer(book.getId_book()), new Integer(user.getId_user()) });
    }

    public void deleteAllBorrow(BookDTO book) {
        String query = "DELETE FROM borrowed WHERE id_book = ?";
        
        this.jdbcTemplate.update(query, new Object[]{ new Integer(book.getId_book()) });
    }

    public void deleteReservation(UserDTO user, BookDTO book) {
        String query = "DELETE FROM reservations WHERE id_book = ? AND id_user = ?";

        this.jdbcTemplate.update(query, new Object[]{ new Integer(book.getId_book()), new Integer(user.getId_user()) });
    }

    public void deleteAllReservations(BookDTO book) {
    	String query = "DELETE FROM reservations WHERE id_book = ?";

    	this.jdbcTemplate.update(query, new Object[]{ new Integer(book.getId_book()) });
    }
}
