package lu.snt.serval.lms.cmp.resource;/*
* Author : Phu H. Nguyen (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

import lu.snt.serval.lms.framework.exceptions.BSException;
import lu.snt.serval.lms.framework.interfaces.IConsultBorrowerAccount;
import lu.snt.serval.lms.framework.interfaces.ICreateBorrowerAccount;
import lu.snt.serval.lms.framework.interfaces.IDeleteBorrowerAccount;
import lu.snt.serval.lms.framework.interfaces.IUpdateBorrowerAccount;
import lu.snt.serval.lms.framework.user.BorrowerAccount;
import lu.snt.serval.lms.framework.user.User;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;


@Requires({
        @RequiredPort(name = "consultBorrowerAccountOut", type = PortType.SERVICE, className = IConsultBorrowerAccount.class, optional = true),
        @RequiredPort(name="createBorrowerAccountOut", type = PortType.SERVICE, className = ICreateBorrowerAccount.class, optional = true),
        @RequiredPort(name="deleteBorrowerAccountOut", type = PortType.SERVICE, className = IDeleteBorrowerAccount.class, optional = true),
        @RequiredPort(name="updateBorrowerAccountOut", type = PortType.SERVICE, className = IUpdateBorrowerAccount.class, optional = true)
})

@Provides({
        @ProvidedPort(name = "consultBorrowerAccountIn", type = PortType.SERVICE, className = IConsultBorrowerAccount.class),
        @ProvidedPort(name="createBorrowerAccountIn", type = PortType.SERVICE, className = ICreateBorrowerAccount.class),
        @ProvidedPort(name="deleteBorrowerAccountIn", type = PortType.SERVICE, className = IDeleteBorrowerAccount.class),
        @ProvidedPort(name="updateBorrowerAccountIn", type = PortType.SERVICE, className = IUpdateBorrowerAccount.class)
})
@ComponentType
@Library(name = "Serval - LMS")
public class BorrowerAccountProxyComponent extends AbstractComponentType implements IConsultBorrowerAccount, ICreateBorrowerAccount, IDeleteBorrowerAccount, IUpdateBorrowerAccount {

    @Start
    public void start() {
        System.out.println("BorrowerAccountProxyComponent:: start");
    }

    @Stop
    public void stop() {
        System.out.println("BorrowerAccountProxyComponent:: stop");
    }

    @Update
    public void update() {
        System.out.println("BorrowerAccountProxyComponent:: update");
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

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */

}
