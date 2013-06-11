package lu.snt.serval.lms.cmp.role;

import lu.snt.serval.lms.framework.book.Book;
import lu.snt.serval.lms.framework.exceptions.BSException;
import lu.snt.serval.lms.framework.interfaces.IBookDamaged;
import lu.snt.serval.lms.framework.interfaces.IBookRepaired;
import lu.snt.serval.lms.framework.interfaces.IConsultBorrowerAccount;
import lu.snt.serval.lms.framework.interfaces.IFindBookByState;
import lu.snt.serval.lms.framework.user.BorrowerAccount;
import lu.snt.serval.lms.framework.user.User;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

import java.util.Collection;

@Requires({
        @RequiredPort(name="bookDamagedOut", type = PortType.SERVICE, className = IBookDamaged.class, optional = true),
        @RequiredPort(name="bookRepairedOut", type = PortType.SERVICE, className = IBookRepaired.class, optional = true),
        @RequiredPort(name="findBookByStateOut", type = PortType.SERVICE, className = IFindBookByState.class, optional = true),
        @RequiredPort(name="consultBorrowerAccountOut", type = PortType.SERVICE, className = IConsultBorrowerAccount.class, optional = true)
})

@Provides({
        @ProvidedPort(name="bookDamagedIn", type = PortType.SERVICE, className = IBookDamaged.class),
        @ProvidedPort(name="bookRepairedIn", type = PortType.SERVICE, className = IBookRepaired.class),
        @ProvidedPort(name="findBookByStateIn", type = PortType.SERVICE, className = IFindBookByState.class),
        @ProvidedPort(name="consultBorrowerAccountIn", type = PortType.SERVICE, className = IConsultBorrowerAccount.class)
})

@ComponentType
@Library(name = "Serval - LMS")
public class LibrarianRoleProxy extends AbstractComponentType implements IFindBookByState, IConsultBorrowerAccount, IBookRepaired, IBookDamaged {

    @Start
    public void start() {
        System.out.println("LibrarianRoleProxy:: start");
    }

    @Stop
    public void stop() {
        System.out.println("LibrarianRoleProxy:: stop");
    }

    @Update
    public void update() {
        System.out.println("LibrarianRoleProxy:: update");
    }


    @Override
    @Port(name = "consultBorrowerAccountIn", method = "consultBorrowerAccount")
    public BorrowerAccount consultBorrowerAccount(User borrower) throws BSException {
        IConsultBorrowerAccount consultBorrowerAccountPort = getPortByName("consultBorrowerAccountOut",IConsultBorrowerAccount.class);
        return consultBorrowerAccountPort.consultBorrowerAccount(borrower);
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
    @Port(name = "findBookByStateIn", method = "findBookByState")
    public Collection<Book> findBookByState(String state) throws BSException {
        IFindBookByState findBookByStatePort = getPortByName("findBookByStateOut",IFindBookByState.class);
        return findBookByStatePort.findBookByState(state);
    }

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */
}
