package lu.snt.serval.lms.cmp.role;

import lu.snt.serval.lms.bo.book.Book;
import lu.snt.serval.lms.bo.user.BorrowerAccount;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

import java.util.Collection;

@Requires({
        @RequiredPort(name="bookDamagedOut", type = PortType.SERVICE, className = IbookDamaged.class, optional = true),
        @RequiredPort(name="bookRepairedOut", type = PortType.SERVICE, className = IbookRepaired.class, optional = true),
        @RequiredPort(name="findBookByStateOut", type = PortType.SERVICE, className = IfindBookByState.class, optional = true),
        @RequiredPort(name="consultBorrowerAccountOut", type = PortType.SERVICE, className = IconsultBorrowerAccount.class, optional = true)
})

@Provides({
        @ProvidedPort(name="bookDamagedIn", type = PortType.SERVICE, className = IbookDamaged.class),
        @ProvidedPort(name="bookRepairedIn", type = PortType.SERVICE, className = IbookRepaired.class),
        @ProvidedPort(name="findBookByStateIn", type = PortType.SERVICE, className = IfindBookByState.class),
        @ProvidedPort(name="consultBorrowerAccountIn", type = PortType.SERVICE, className = IconsultBorrowerAccount.class)
})

@ComponentType
@Library(name = "Serval - LMS")
class LibrarianRoleProxy extends AbstractComponentType implements IfindBookByState,

        IconsultBorrowerAccount,

        IbookRepaired,

        IbookDamaged, IFake {

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
        IconsultBorrowerAccount consultBorrowerAccountPort = getPortByName("consultBorrowerAccountOut",IconsultBorrowerAccount.class);
        return consultBorrowerAccountPort.consultBorrowerAccount(borrower);
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
    @Port(name = "findBookByStateIn", method = "findBookByState")
    public Collection<Book> findBookByState(String state) throws BSException {
        IfindBookByState findBookByStatePort = getPortByName("findBookByStateOut",IfindBookByState.class);
        return findBookByStatePort.findBookByState(state);
    }

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */
}
