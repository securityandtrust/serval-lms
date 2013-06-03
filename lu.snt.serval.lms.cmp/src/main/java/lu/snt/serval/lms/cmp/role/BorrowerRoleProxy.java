package lu.snt.serval.lms.cmp.role;

import lu.snt.serval.lms.bo.book.Book;
import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

import java.util.Collection;

@Requires({
        @RequiredPort(name = "borrowBookOut", type = PortType.SERVICE, className = IborrowBook.class, optional = true),
        @RequiredPort(name="reserveBookOut", type = PortType.SERVICE, className = IreserveBook.class, optional = true),
        @RequiredPort(name="returnBookOut", type = PortType.SERVICE, className = IreturnBook.class, optional = true),
        @RequiredPort(name="findBookByKeywordOut", type = PortType.SERVICE, className = IfindBookByKeyword.class, optional = true)
})

@Provides({
        @ProvidedPort(name="borrowBookIn", type = PortType.SERVICE, className = IborrowBook.class),
        @ProvidedPort(name="reserveBookIn", type = PortType.SERVICE, className = IreserveBook.class),
        @ProvidedPort(name="returnBookIn", type = PortType.SERVICE, className = IreturnBook.class),
        @ProvidedPort(name="findBookByKeywordIn", type = PortType.SERVICE, className = IfindBookByKeyword.class)

})

@ComponentType
@Library(name = "Serval - LMS")
class BorrowerRoleProxy extends AbstractComponentType implements IfindBookByKeyword,
        IborrowBook,

        IreserveBook,

        IreturnBook, IFake {

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
    public void borrowBook(lu.snt.serval.lms.bo.user.User user, Book book) throws BSException {
        IborrowBook borrowBookPort = getPortByName("borrowBookOut",IborrowBook.class);
        borrowBookPort.borrowBook(user, book);
    }

    @Override
    @Port(name = "reserveBookIn", method = "reserveBook")
    public void reserveBook(lu.snt.serval.lms.bo.user.User user, Book book) throws BSException {
        IreserveBook reserveBookPort = getPortByName("reserveBookOut",IreserveBook.class);
        reserveBookPort.reserveBook(user, book);
    }

    @Override
    @Port(name = "returnBookIn", method = "returnBook")
    public void returnBook(lu.snt.serval.lms.bo.user.User user, Book book) throws BSException {
        IreturnBook returnBookPort = getPortByName("returnBookOut",IreturnBook.class);
        returnBookPort.returnBook(user, book);
    }

    @Override
    @Port(name = "findBookByKeywordIn", method = "findBookByKeyword")
    public Collection<Book> findBookByKeyword(String keyword)
            throws BSException {
        IfindBookByKeyword findBookByKeywordPort = getPortByName("findBookByKeywordOut",IfindBookByKeyword.class);
        return findBookByKeywordPort.findBookByKeyword(keyword);
    }

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */
}
