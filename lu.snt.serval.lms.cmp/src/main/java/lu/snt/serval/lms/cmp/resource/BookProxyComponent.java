package lu.snt.serval.lms.cmp.resource;/*
* Author : Phu H. Nguyen (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/
import lu.snt.serval.lms.framework.book.Book;
import lu.snt.serval.lms.framework.exceptions.BSException;
import lu.snt.serval.lms.framework.interfaces.*;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

import java.util.Collection;


@Requires({
        @RequiredPort(name = "borrowBookOut", type = PortType.SERVICE, className = IBorrowBook.class, optional = true),
        @RequiredPort(name="reserveBookOut", type = PortType.SERVICE, className = IReserveBook.class, optional = true),
        @RequiredPort(name="returnBookOut", type = PortType.SERVICE, className = IReturnBook.class, optional = true),
        @RequiredPort(name="fixBookOut", type = PortType.SERVICE, className = IFixBook.class, optional = true),
        @RequiredPort(name="bookDamagedOut", type = PortType.SERVICE, className = IBookDamaged.class, optional = true),
        @RequiredPort(name="bookRepairedOut", type = PortType.SERVICE, className = IBookRepaired.class, optional = true),
        @RequiredPort(name="deliverBookOut", type = PortType.SERVICE, className = IDeliverBook.class, optional = true),
        @RequiredPort(name="findBookByStateOut", type = PortType.SERVICE, className = IFindBookByState.class, optional = true),
        @RequiredPort(name="findBookByKeywordOut", type = PortType.SERVICE, className = IFindBookByKeyword.class, optional = true)
})

@Provides({
        @ProvidedPort(name="borrowBookIn", type = PortType.SERVICE, className = IBorrowBook.class),
        @ProvidedPort(name="reserveBookIn", type = PortType.SERVICE, className = IReserveBook.class),
        @ProvidedPort(name="returnBookIn", type = PortType.SERVICE, className = IReturnBook.class),
        @ProvidedPort(name="fixBookIn", type = PortType.SERVICE, className = IFixBook.class),
        @ProvidedPort(name="bookDamagedIn", type = PortType.SERVICE, className = IBookDamaged.class),
        @ProvidedPort(name="bookRepairedIn", type = PortType.SERVICE, className = IBookRepaired.class),
        @ProvidedPort(name="deliverBookIn", type = PortType.SERVICE, className = IDeliverBook.class),
        @ProvidedPort(name="findBookByStateIn", type = PortType.SERVICE, className = IFindBookByState.class),
        @ProvidedPort(name="findBookByKeywordIn", type = PortType.SERVICE, className = IFindBookByKeyword.class)
})
@ComponentType
@Library(name = "Serval - LMS")
public class BookProxyComponent extends AbstractComponentType implements IBorrowBook, IReserveBook, IReturnBook, IFixBook, IBookDamaged, IBookRepaired, IDeliverBook, IFindBookByState, IFindBookByKeyword {

    @Start
    public void start() {
        System.out.println("BookProxyComponent:: start");
    }
    
    @Stop
    public void stop() {
        System.out.println("BookProxyComponent:: stop");
    }
    
    @Update
    public void update() {
        System.out.println("BookProxyComponent:: update");
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
    @Port(name = "fixBookIn", method = "fixBook")
    public void fixBook(lu.snt.serval.lms.framework.user.User user, Book book) throws BSException {
        IFixBook fixBookPort = getPortByName("fixBookOut",IFixBook.class);
        fixBookPort.fixBook(user, book);
    }

    @Override
    @Port(name = "bookDamagedIn", method = "bookDamaged")
    public void bookDamaged(lu.snt.serval.lms.framework.user.User user, Book book) throws BSException {
        IBookDamaged bookDamagedPort = getPortByName("bookDamagedOut",IBookDamaged.class);
        bookDamagedPort.bookDamaged(user, book);
    }

    @Override
    @Port(name = "bookRepairedIn", method = "bookRepaired")
    public void bookRepaired(lu.snt.serval.lms.framework.user.User user, Book book) throws BSException {
        IBookRepaired bookRepairedPort = getPortByName("bookRepairedOut",IBookRepaired.class);
        bookRepairedPort.bookRepaired(user, book);
    }

    @Override
    @Port(name = "deliverBookIn", method = "deliverBook")
    public void deliverBook(lu.snt.serval.lms.framework.user.User user, Book book) throws BSException {
        IDeliverBook deliverBookPort = getPortByName("deliverBookOut",IDeliverBook.class);
        deliverBookPort.deliverBook(user, book);
    }

    @Override
    @Port(name = "findBookByStateIn", method = "findBookByState")
    public Collection<Book> findBookByState(String state) throws BSException {
        IFindBookByState findBookByStatePort = getPortByName("findBookByStateOut",IFindBookByState.class);
        return findBookByStatePort.findBookByState(state);
    }

    @Override
    @Port(name = "findBookByKeywordIn", method = "findBookByKeyword")
    public java.util.Collection<Book> findBookByKeyword(String keyword)
            throws BSException {
        IFindBookByKeyword findBookByKeywordPort = getPortByName("findBookByKeywordOut",IFindBookByKeyword.class);
        return findBookByKeywordPort.findBookByKeyword(keyword);
    }


    /* End of generated code. You can now implement the business logic of the component
    * (Quick Fix: Add Unimplemented Method)
    */
}
