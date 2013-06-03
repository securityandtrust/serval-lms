package lu.snt.serval.lms.proxy.resource;/*
* Author : Phu H. Nguyen (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

import lu.snt.serval.lms.bo.user.BorrowerAccount;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;


@Requires({
        @RequiredPort(name = "consultBorrowerAccountOut", type = PortType.SERVICE, className = IconsultBorrowerAccount.class, optional = true),
        @RequiredPort(name="createBorrowerAccountOut", type = PortType.SERVICE, className = IcreateBorrowerAccount.class, optional = true),
        @RequiredPort(name="deleteBorrowerAccountOut", type = PortType.SERVICE, className = IdeleteBorrowerAccount.class, optional = true),
        @RequiredPort(name="updateBorrowerAccountOut", type = PortType.SERVICE, className = IupdateBorrowerAccount.class, optional = true)
})

@Provides({
        @ProvidedPort(name = "consultBorrowerAccountIn", type = PortType.SERVICE, className = IconsultBorrowerAccount.class),
        @ProvidedPort(name="createBorrowerAccountIn", type = PortType.SERVICE, className = IcreateBorrowerAccount.class),
        @ProvidedPort(name="deleteBorrowerAccountIn", type = PortType.SERVICE, className = IdeleteBorrowerAccount.class),
        @ProvidedPort(name="updateBorrowerAccountIn", type = PortType.SERVICE, className = IupdateBorrowerAccount.class)
})
@ComponentType
@Library(name = "Serval - LMS")
public class BorrowerAccountProxyComponent extends AbstractComponentType implements
        IconsultBorrowerAccount,
        IcreateBorrowerAccount,
        IdeleteBorrowerAccount,
        IupdateBorrowerAccount {

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

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */

}
