package lu.snt.serval.lms.cmp.user;

import lu.snt.serval.lms.framework.book.Book;
import lu.snt.serval.lms.framework.exceptions.BSException;
import lu.snt.serval.lms.framework.interfaces.*;
import lu.snt.serval.lms.framework.user.BorrowerAccount;
import lu.snt.serval.lms.framework.user.PersonnelAccount;
import lu.snt.serval.lms.framework.user.User;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

@Requires({
        @RequiredPort(name = "consultPersonnelAccountOut", type = PortType.SERVICE, className = IConsultPersonnelAccount.class, optional = true),
        @RequiredPort(name="deliverBookOut", type = PortType.SERVICE, className = IDeliverBook.class, optional = true),
        @RequiredPort(name="consultBorrowerAccountOut", type = PortType.SERVICE, className = IConsultBorrowerAccount.class, optional = true),
        @RequiredPort(name="createBorrowerAccountOut", type = PortType.SERVICE, className = ICreateBorrowerAccount.class, optional = true),
        @RequiredPort(name="deleteBorrowerAccountOut", type = PortType.SERVICE, className = IDeleteBorrowerAccount.class, optional = true),
        @RequiredPort(name="updateBorrowerAccountOut", type = PortType.SERVICE, className = IUpdateBorrowerAccount.class, optional = true)
})

@Provides({
        @ProvidedPort(name = "consultPersonnelAccountIn", type = PortType.SERVICE, className = IConsultPersonnelAccount.class),
        @ProvidedPort(name="deliverBookIn", type = PortType.SERVICE, className = IDeliverBook.class),
        @ProvidedPort(name="consultBorrowerAccountIn", type = PortType.SERVICE, className = IConsultBorrowerAccount.class),
        @ProvidedPort(name="createBorrowerAccountIn", type = PortType.SERVICE, className = ICreateBorrowerAccount.class),
        @ProvidedPort(name="deleteBorrowerAccountIn", type = PortType.SERVICE, className = IDeleteBorrowerAccount.class),
        @ProvidedPort(name = "updateBorrowerAccountIn", type = PortType.SERVICE, className = IUpdateBorrowerAccount.class)
})
@DictionaryType({
        @DictionaryAttribute(name = "userName", optional = false)
})
@ComponentType
@Library(name = "Serval - LMS")
public class UserProxy extends AbstractComponentType implements IDeleteBorrowerAccount, IUpdateBorrowerAccount, ICreateBorrowerAccount, IDeliverBook, IConsultBorrowerAccount, IConsultPersonnelAccount{

    @Start
    public void start() {
        System.out.println("SecretaryRoleProxy:: start");
    }

    @Stop
    public void stop() {
        System.out.println("SecretaryRoleProxy:: stop");
    }

    @Update
    public void update() {
        System.out.println("SecretaryRoleProxy:: update");
    }


    @Override
    @Port(name = "createBorrowerAccountIn", method = "createBorrowerAccount")
    public void createBorrowerAccount(User borrower,
                                      BorrowerAccount borrowerAccount) throws BSException {
        ICreateBorrowerAccount createBorrowerAccountPort = getPortByName("createBorrowerAccountOut",ICreateBorrowerAccount.class);
        createBorrowerAccountPort.createBorrowerAccount(borrower, borrowerAccount);
    }

    @Override
    @Port(name = "deleteBorrowerAccountIn", method = "deleteBorrowerAccount")
    public void deleteBorrowerAccount(BorrowerAccount borrowerAccount) throws BSException {
        IDeleteBorrowerAccount deleteBorrowerAccountPort = getPortByName("deleteBorrowerAccountOut",IDeleteBorrowerAccount.class);
        deleteBorrowerAccountPort.deleteBorrowerAccount(borrowerAccount);

    }

    @Override
    @Port(name = "updateBorrowerAccountIn", method = "updateBorrowerAccount")
    public void updateBorrowerAccount(User borrower,
                                      BorrowerAccount borrowerAccount) throws BSException {
        IUpdateBorrowerAccount updateBorrowerAccountPort = getPortByName("updateBorrowerAccountOut",IUpdateBorrowerAccount.class);
        updateBorrowerAccountPort.updateBorrowerAccount(borrower, borrowerAccount);
    }

    @Override
    @Port(name = "consultBorrowerAccountIn", method = "consultBorrowerAccount")
    public BorrowerAccount consultBorrowerAccount(User borrower) throws BSException {
        IConsultBorrowerAccount consultBorrowerAccountPort = getPortByName("consultBorrowerAccountOut",IConsultBorrowerAccount.class);
        return consultBorrowerAccountPort.consultBorrowerAccount(borrower);
    }

    @Override
    @Port(name = "deliverBookIn", method = "deliverBook")
    public void deliverBook(User user, Book book) throws BSException {
        IDeliverBook deliverBookPort = getPortByName("deliverBookOut",IDeliverBook.class);
        deliverBookPort.deliverBook(user, book);
    }

    @Override
    @Port(name = "consultPersonnelAccountIn", method = "consultPersonnelAccount")
    public PersonnelAccount consultPersonnelAccount(User Personnel) throws BSException {
        IConsultPersonnelAccount consultPersonnelAccountPort = getPortByName("consultPersonnelAccountOut",IConsultPersonnelAccount.class);
        return consultPersonnelAccountPort.consultPersonnelAccount(Personnel);
    }

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */
}
