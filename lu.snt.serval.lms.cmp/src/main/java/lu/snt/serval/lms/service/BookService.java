package lu.snt.serval.lms.service;

import lu.snt.serval.lms.bo.book.Book;
import lu.snt.serval.lms.bo.book.InvalidActionException;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.dao.BookDAO;
import lu.snt.serval.lms.dao.UserDAO;
import lu.snt.serval.lms.dao.dto.BookDTO;
import lu.snt.serval.lms.dao.dto.UserDTO;
import lu.snt.serval.lms.proxy.interfaces.IbookDamaged;
import lu.snt.serval.lms.proxy.interfaces.IbookRepaired;
import lu.snt.serval.lms.proxy.interfaces.IborrowBook;
import lu.snt.serval.lms.proxy.interfaces.IdeliverBook;
import lu.snt.serval.lms.proxy.interfaces.IfindBookByKeyword;
import lu.snt.serval.lms.proxy.interfaces.IfindBookByState;
import lu.snt.serval.lms.proxy.interfaces.IfixBook;
import lu.snt.serval.lms.proxy.interfaces.IreserveBook;
import lu.snt.serval.lms.proxy.interfaces.IreturnBook;
import lu.snt.serval.lms.service.exception.BSException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class
        BookService implements IborrowBook,

        IreserveBook,

        IreturnBook,

        IfixBook,

        IbookDamaged,

        IbookRepaired,

        IdeliverBook,

        IfindBookByState,

        IfindBookByKeyword{

	private static BookService ourInstance = new BookService();

    private BookDAO bookDAO;
    private UserDAO userDAO;
    
    public static BookService getInstance() {
        return ourInstance;
    }

    public BookService() {

        super();
        
        // initilizes the DAOs
        if (bookDAO == null)
            bookDAO = BookDAO.getInstance();

        if (userDAO == null)
            userDAO = UserDAO.getInstance();

    }


    public synchronized void borrowBook(User user, Book book) throws BSException {

        UserDTO userDTO;
        BookDTO bookDTO;

        try {
            // check if the book was reserved that the one who borrows is is the one who reserves
            // the book

            if(!book.getReservations().isEmpty())   {

                if(!user.equals(book.getReservations().iterator().next()))
                       throw new BSException("The user who wants to borrow the book is not the one who reserved it.");

            }


            // borrow the book for the user
            book.execute(Book.BORROW, user);

            // remove the book from reserved
            user.getReservations().remove(book);

            // register the borrowed book in the collection of user's borrowed
            user.getBorrowed().add(book);

            // update book
            updateBook(book);


            // remove the reservation and add the borrow
            userDTO = (UserDTO) user.getDTO();
            bookDTO = (BookDTO) book.getDTO();
            bookDAO.deleteReservation(userDTO, bookDTO);
            bookDAO.insertBorrow(userDTO, bookDTO);

        } catch (InvalidActionException e) {
            throw new BSException(e.getMessage());
        }

    }

    public synchronized void reserveBook(User user, Book book) throws BSException{

        UserDTO userDTO;
        BookDTO bookDTO;

        try {

            // only reserve if the book was not reserved by the user
            if (user.getReservations().contains(book)) {
                throw new BSException("Book already reserved by the user.");

            }

            // borrow the book for the user
            book.execute(Book.RESERVE, user);

            // register the borrowed book in the collection of user's reservetions
            user.getReservations().add(book);

            // add the reservation
            userDTO = (UserDTO) user.getDTO();
            bookDTO = (BookDTO) book.getDTO();
            bookDAO.insertReservation(userDTO, bookDTO);

            updateBook(book);

        } catch (InvalidActionException e) {
            throw new BSException(e.getMessage());
        }


    }

    public synchronized void returnBook(User user, Book book) throws BSException {

        UserDTO userDTO;
        BookDTO bookDTO;

        try {

            // test if the user has borrowed the book
            if (!user.getBorrowed().contains(book)) {
                throw new BSException("The user did not borrow the book.");

            }

            // return back the book
            book.execute(Book.RETURN, user);

            // remove the borrowed book in the collection of user's borrowed
            user.getBorrowed().remove(book);

            // update DB
            userDTO = (UserDTO) user.getDTO();
            bookDTO = (BookDTO) book.getDTO();
            bookDAO.deleteBorrow(userDTO, bookDTO);

            updateBook(book);


        } catch (InvalidActionException e) {
            throw new BSException(e.getMessage());
        }

    }

    public synchronized void fixBook(User user, Book book) throws BSException {

        try {
            // the user fixes the book
            book.execute(Book.FIX, user);
            updateBook(book);


        } catch (InvalidActionException e) {
            throw new BSException(e.getMessage());
        }


    }

    public synchronized void bookDamaged(User user, Book book) throws BSException {       

        try {
            // borrow the book for the user
            book.execute(Book.SETDAMAGED, user);
            updateBook(book);


        } catch (InvalidActionException e) {
            throw new BSException(e.getMessage());
        }


    }


    public void bookRepaired(User user, Book book) throws BSException {
        
        try {
            // user notify that the book is now repaired
            book.execute(Book.SETREPAIRED, user);
            updateBook(book);


        } catch (InvalidActionException e) {
            throw new BSException(e.getMessage());
        }
    }

    public synchronized void deliverBook(User user, Book book) throws BSException {
        try {
            // the user deliver the book
            book.execute(Book.DELIVER, user);
            updateBook(book);


        } catch (InvalidActionException e) {
            throw new BSException(e.getMessage());
        }
    }

    public Collection<Book> findBookByState(String state) throws BSException {

        if (!state.equals(Book.AVAILABLE) && !state.equals(Book.BORROWED) && !state.equals(Book.BEINGFIXED)
                && !state.equals(Book.ORDERED) && !state.equals(Book.RESERVED))
            throw new IllegalArgumentException("Wrong state : " + state);

        Collection<BookDTO> dtos;
        Collection<Book> books;
        Book book;


        // call dao to find books
		dtos = bookDAO.findBooksByState(state);

		// put the result in the collection
		books = new ArrayList<Book>();

		for (Iterator<BookDTO> iterator = dtos.iterator(); iterator.hasNext();) {
		    book = new Book(iterator.next());
		    loadBookReservations(book);
		    books.add(book);

		}

        return books;

    }

    public Collection<Book> findBookByKeyword(String keyword) throws BSException {
        if (keyword == null)
            throw new IllegalArgumentException("Wrong argument. Null keyword");


        Collection<BookDTO> dtos;
        Collection<Book> books;
        Book book;


        // call dao to find books
		dtos = bookDAO.seachBooksByKeyword(keyword);

		// put the result in the collection
		books = new ArrayList<Book>();

		for (Iterator<BookDTO> iterator = dtos.iterator(); iterator.hasNext();) {
		    book = new Book(iterator.next());
		    loadBookReservations(book);
		    books.add(book);

		}

        return books;
    }

    private synchronized void updateBook(Book book) throws BSException {

        // update the book
		bookDAO.update(book.getDTO());

    }

    private void loadBookReservations(Book book) throws BSException {

        BookDTO bookDTO;

        // call dao
        bookDTO = (BookDTO) book.getDTO();
        Collection<UserDTO> dtos = userDAO.loadUserReservingBook(bookDTO);

        // load reservations
        book.setReservationsFromDTOs(dtos);        
    }
}
