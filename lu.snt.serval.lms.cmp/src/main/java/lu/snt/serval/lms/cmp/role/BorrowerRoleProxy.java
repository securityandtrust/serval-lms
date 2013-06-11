package lu.snt.serval.lms.cmp.role;

import lu.snt.serval.lms.framework.book.Book;
import lu.snt.serval.lms.framework.exceptions.BSException;
import lu.snt.serval.lms.framework.interfaces.IBorrowBook;
import lu.snt.serval.lms.framework.interfaces.IFindBookByKeyword;
import lu.snt.serval.lms.framework.interfaces.IReserveBook;
import lu.snt.serval.lms.framework.interfaces.IReturnBook;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

import java.util.Collection;

@Requires({
        @RequiredPort(name = "borrowBookOut", type = PortType.SERVICE, className = IBorrowBook.class, optional = true),
        @RequiredPort(name="reserveBookOut", type = PortType.SERVICE, className = IReserveBook.class, optional = true),
        @RequiredPort(name="returnBookOut", type = PortType.SERVICE, className = IReturnBook.class, optional = true),
        @RequiredPort(name="findBookByKeywordOut", type = PortType.SERVICE, className = IFindBookByKeyword.class, optional = true)
})

@Provides({
        @ProvidedPort(name="borrowBookIn", type = PortType.SERVICE, className = IBorrowBook.class),
        @ProvidedPort(name="reserveBookIn", type = PortType.SERVICE, className = IReserveBook.class),
        @ProvidedPort(name="returnBookIn", type = PortType.SERVICE, className = IReturnBook.class),
        @ProvidedPort(name="findBookByKeywordIn", type = PortType.SERVICE, className = IFindBookByKeyword.class)

})

@ComponentType
@Library(name = "Serval - LMS")
public class BorrowerRoleProxy extends AbstractComponentType implements IFindBookByKeyword, IBorrowBook, IReserveBook, IReturnBook {

    @Start
    public void start() {
        System.out.println("BorrowerRoleProxy:: start");
    }

    @Stop
    public void stop() {
        System.out.println("BorrowerRoleProxy:: stop");
    }

    @Update
    public void update() {
        System.out.println("BorrowerRoleProxy:: update");
    }


    @Override
    @Port(name = "borrowBookIn", method = "borrowBook")
    public void borrowBook(lu.snt.serval.lms.framework.user.User user, Book book) throws BSException {
        IBorrowBook borrowBookPort = getPortByName("borrowBookOut",IBorrowBook.class);
        borrowBookPort.borrowBook(user, book);
    }

    @Override
    @Port(name = "reserveBookIn", method = "reserveBook")
    public void reserveBook(lu.snt.serval.lms.framework.user.User user, Book book) throws BSException {
        IReserveBook reserveBookPort = getPortByName("reserveBookOut",IReserveBook.class);
        reserveBookPort.reserveBook(user, book);
    }

    @Override
    @Port(name = "returnBookIn", method = "returnBook")
    public void returnBook(lu.snt.serval.lms.framework.user.User user, Book book) throws BSException {
        IReturnBook returnBookPort = getPortByName("returnBookOut",IReturnBook.class);
        returnBookPort.returnBook(user, book);
    }

    @Override
    @Port(name = "findBookByKeywordIn", method = "findBookByKeyword")
    public Collection<Book> findBookByKeyword(String keyword)
            throws BSException {
        IFindBookByKeyword findBookByKeywordPort = getPortByName("findBookByKeywordOut",IFindBookByKeyword.class);
        return findBookByKeywordPort.findBookByKeyword(keyword);
    }

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */
}
