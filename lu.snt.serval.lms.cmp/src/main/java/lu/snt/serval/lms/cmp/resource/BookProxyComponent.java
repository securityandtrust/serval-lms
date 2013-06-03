package lu.snt.serval.lms.cmp.resource;/*
* Author : Phu H. Nguyen (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/
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
        @RequiredPort(name="fixBookOut", type = PortType.SERVICE, className = IfixBook.class, optional = true),
        @RequiredPort(name="bookDamagedOut", type = PortType.SERVICE, className = IbookDamaged.class, optional = true),
        @RequiredPort(name="bookRepairedOut", type = PortType.SERVICE, className = IbookRepaired.class, optional = true),
        @RequiredPort(name="deliverBookOut", type = PortType.SERVICE, className = IdeliverBook.class, optional = true),
        @RequiredPort(name="findBookByStateOut", type = PortType.SERVICE, className = IfindBookByState.class, optional = true),
        @RequiredPort(name="findBookByKeywordOut", type = PortType.SERVICE, className = IfindBookByKeyword.class, optional = true)
})

@Provides({
        @ProvidedPort(name="borrowBookIn", type = PortType.SERVICE, className = IborrowBook.class),
        @ProvidedPort(name="reserveBookIn", type = PortType.SERVICE, className = IreserveBook.class),
        @ProvidedPort(name="returnBookIn", type = PortType.SERVICE, className = IreturnBook.class),
        @ProvidedPort(name="fixBookIn", type = PortType.SERVICE, className = IfixBook.class),
        @ProvidedPort(name="bookDamagedIn", type = PortType.SERVICE, className = IbookDamaged.class),
        @ProvidedPort(name="bookRepairedIn", type = PortType.SERVICE, className = IbookRepaired.class),
        @ProvidedPort(name="deliverBookIn", type = PortType.SERVICE, className = IdeliverBook.class),
        @ProvidedPort(name="findBookByStateIn", type = PortType.SERVICE, className = IfindBookByState.class),
        @ProvidedPort(name="findBookByKeywordIn", type = PortType.SERVICE, className = IfindBookByKeyword.class)
})
@ComponentType
@Library(name = "Serval - LMS")
public class BookProxyComponent extends AbstractComponentType implements IborrowBook,

        IreserveBook,

        IreturnBook,

        IfixBook,

        IbookDamaged,

        IbookRepaired,

        IdeliverBook,

        IfindBookByState,

        IfindBookByKeyword{

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
    @Port(name = "fixBookIn", method = "fixBook")
    public void fixBook(lu.snt.serval.lms.bo.user.User user, Book book) throws BSException {
        IfixBook fixBookPort = getPortByName("fixBookOut",IfixBook.class);
        fixBookPort.fixBook(user, book);
    }

    @Override
    @Port(name = "bookDamagedIn", method = "bookDamaged")
    public void bookDamaged(lu.snt.serval.lms.bo.user.User user, Book book) throws BSException {
        IbookDamaged bookDamagedPort = getPortByName("bookDamagedOut",IbookDamaged.class);
        bookDamagedPort.bookDamaged(user, book);
    }

    @Override
    @Port(name = "bookRepairedIn", method = "bookRepaired")
    public void bookRepaired(lu.snt.serval.lms.bo.user.User user, Book book) throws BSException {
        IbookRepaired bookRepairedPort = getPortByName("bookRepairedOut",IbookRepaired.class);
        bookRepairedPort.bookRepaired(user, book);
    }

    @Override
    @Port(name = "deliverBookIn", method = "deliverBook")
    public void deliverBook(lu.snt.serval.lms.bo.user.User user, Book book) throws BSException {
        IdeliverBook deliverBookPort = getPortByName("deliverBookOut",IdeliverBook.class);
        deliverBookPort.deliverBook(user, book);
    }

    @Override
    @Port(name = "findBookByStateIn", method = "findBookByState")
    public Collection<Book> findBookByState(String state) throws BSException {
        IfindBookByState findBookByStatePort = getPortByName("findBookByStateOut",IfindBookByState.class);
        return findBookByStatePort.findBookByState(state);
    }

    @Override
    @Port(name = "findBookByKeywordIn", method = "findBookByKeyword")
    public java.util.Collection<Book> findBookByKeyword(String keyword)
            throws BSException {
        IfindBookByKeyword findBookByKeywordPort = getPortByName("findBookByKeywordOut",IfindBookByKeyword.class);
        return findBookByKeywordPort.findBookByKeyword(keyword);
    }


    /* End of generated code. You can now implement the business logic of the component
    * (Quick Fix: Add Unimplemented Method)
    */
}
