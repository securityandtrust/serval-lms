package lu.snt.serval.lms.proxy.user;

import lu.snt.serval.lms.bo.book.Book;
import lu.snt.serval.lms.bo.user.BorrowerAccount;
import lu.snt.serval.lms.bo.user.PersonnelAccount;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

@Requires({
        @RequiredPort(name = "consultPersonnelAccountOut", type = PortType.SERVICE, className = IconsultPersonnelAccount.class, optional = true),
        @RequiredPort(name="deliverBookOut", type = PortType.SERVICE, className = IdeliverBook.class, optional = true),
        @RequiredPort(name="consultBorrowerAccountOut", type = PortType.SERVICE, className = IconsultBorrowerAccount.class, optional = true),
        @RequiredPort(name="createBorrowerAccountOut", type = PortType.SERVICE, className = IcreateBorrowerAccount.class, optional = true),
        @RequiredPort(name="deleteBorrowerAccountOut", type = PortType.SERVICE, className = IdeleteBorrowerAccount.class, optional = true),
        @RequiredPort(name="updateBorrowerAccountOut", type = PortType.SERVICE, className = IupdateBorrowerAccount.class, optional = true)
})

@Provides({
        @ProvidedPort(name = "consultPersonnelAccountIn", type = PortType.SERVICE, className = IconsultPersonnelAccount.class),
        @ProvidedPort(name="deliverBook", type = PortType.SERVICE, className = IdeliverBook.class),
        @ProvidedPort(name="consultBorrowerAccountIn", type = PortType.SERVICE, className = IconsultBorrowerAccount.class),
        @ProvidedPort(name="createBorrowerAccountIn", type = PortType.SERVICE, className = IcreateBorrowerAccount.class),
        @ProvidedPort(name="deleteBorrowerAccountIn", type = PortType.SERVICE, className = IdeleteBorrowerAccount.class),
        @ProvidedPort(name="updateBorrowerAccountIn", type = PortType.SERVICE, className = IupdateBorrowerAccount.class)
})

@ComponentType
@Library(name = "Serval - LMS")
class BobUserProxy extends AbstractComponentType implements IdeleteBorrowerAccount,

        IupdateBorrowerAccount,

        IcreateBorrowerAccount,

        IdeliverBook,

        IconsultBorrowerAccount,

        IconsultPersonnelAccount, IFake {

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
        IcreateBorrowerAccount createBorrowerAccountPort = getPortByName("createBorrowerAccountOut",IcreateBorrowerAccount.class);
        createBorrowerAccountPort.createBorrowerAccount(borrower, borrowerAccount);
    }

    @Override
    @Port(name = "deleteBorrowerAccountIn", method = "deleteBorrowerAccount")
    public void deleteBorrowerAccount(BorrowerAccount borrowerAccount) throws BSException {
        IdeleteBorrowerAccount deleteBorrowerAccountPort = getPortByName("deleteBorrowerAccountOut",IdeleteBorrowerAccount.class);
        deleteBorrowerAccountPort.deleteBorrowerAccount(borrowerAccount);

    }

    @Override
    @Port(name = "updateBorrowerAccountIn", method = "updateBorrowerAccount")
    public void updateBorrowerAccount(User borrower,
                                      BorrowerAccount borrowerAccount) throws BSException {
        IupdateBorrowerAccount updateBorrowerAccountPort = getPortByName("updateBorrowerAccountOut",IupdateBorrowerAccount.class);
        updateBorrowerAccountPort.updateBorrowerAccount(borrower, borrowerAccount);
    }

    @Override
    @Port(name = "consultBorrowerAccountIn", method = "consultBorrowerAccount")
    public BorrowerAccount consultBorrowerAccount(User borrower) throws BSException {
        IconsultBorrowerAccount consultBorrowerAccountPort = getPortByName("consultBorrowerAccountOut",IconsultBorrowerAccount.class);
        return consultBorrowerAccountPort.consultBorrowerAccount(borrower);
    }

    @Override
    @Port(name = "deliverBookIn", method = "deliverBook")
    public void deliverBook(User user, Book book) throws BSException {
        IdeliverBook deliverBookPort = getPortByName("deliverBookOut",IdeliverBook.class);
        deliverBookPort.deliverBook(user, book);
    }

    @Override
    @Port(name = "consultPersonnelAccountIn", method = "consultPersonnelAccount")
    public PersonnelAccount consultPersonnelAccount(User Personnel) throws BSException {
        IconsultPersonnelAccount consultPersonnelAccountPort = getPortByName("consultPersonnelAccountOut",IconsultPersonnelAccount.class);
        return consultPersonnelAccountPort.consultPersonnelAccount(Personnel);
    }

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */
}
