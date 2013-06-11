package lu.snt.serval.lms.backend.spec;


import lu.snt.serval.lms.backend.dto.BookDTO;
import lu.snt.serval.lms.backend.dto.UserDTO;

import java.util.Collection;

public interface BookDAOInterface {

    /**
     * @param state the state name can be <AVAILABLE,BORROWED,REPAIRED,DAMAGED
     * @return list of books having the requested state
     */
    Collection<BookDTO> findBooksByState(String state);


    /**
     * @param author used to find
     * @return list of author's books
     */
    Collection<BookDTO> seachBooksByKeyword(String author);

    /**
     * Update the book values stored in the database
     *
     * @param dto
     * @throws java.sql.SQLException
     */

    void update(BookDTO dto);


    /**
     * insert the book values to the database, creates a new entry and set the book_id value
     *
     * @param dto
     * @throws java.sql.SQLException
     */
    void insert(BookDTO dto);

    /**
     * Loads reservations books about the user.
     *
     * @param userDTO
     * @return a collection of books
     * @throws java.sql.SQLException if a sql problem happens
     */
    Collection<BookDTO> loadUserReservedBooks(UserDTO userDTO);


    /**
     * Loads borrowed books about the user.
     *
     * @param userDTO the user
     * @return the list of borrowed books
     * @throws java.sql.SQLException
     */
    Collection<BookDTO> loadUserBorrowedBooks(UserDTO userDTO);

    /**
     * saves in DB the borrow of bookdto by userdto
     *
     * @param userDTO the user
     * @param bookDTO the book
     * @throws java.sql.SQLException if sql problem
     */
    void insertBorrow(UserDTO userDTO, BookDTO bookDTO);

    /**
     * saves in DB the reservation of bookdto by userdto
     *
     * @param userDTO the user
     * @param bookDTO the book
     * @throws java.sql.SQLException if sql problem
     */
    void insertReservation(UserDTO userDTO, BookDTO bookDTO);

    /**
     * deletes from DB the borrow of bookdto by userdto
     *
     * @param userDTO the user
     * @param bookDTO the book
     * @throws java.sql.SQLException if sql problem
     */
    void deleteBorrow(UserDTO userDTO, BookDTO bookDTO);


   /**
     * deletes from DB the borrow of bookdto
     *
     * @param bookDTO the book
     * @throws java.sql.SQLException if sql problem
     */
    void deleteAllBorrow(BookDTO bookDTO);



    /**
     * deletes from DB the reservation of bookdto by userdto
     *
     * @param userDTO the user
     * @param bookDTO the book
     * @throws java.sql.SQLException if sql problem
     */
    void deleteReservation(UserDTO userDTO, BookDTO bookDTO);

     /**
     * deletes from DB book reservations
     *
     * @param bookDTO the book
     * @throws java.sql.SQLException if sql problem
     */
    void deleteAllReservations(BookDTO bookDTO);


}
