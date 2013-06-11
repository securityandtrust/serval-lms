package lu.snt.serval.lms.cmp.resource;/*
* Author : Phu H. Nguyen (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

import lu.snt.serval.lms.framework.exceptions.BSException;
import lu.snt.serval.lms.framework.interfaces.IConsultPersonnelAccount;
import lu.snt.serval.lms.framework.interfaces.ICreatePersonnelAccount;
import lu.snt.serval.lms.framework.interfaces.IDeletePersonnelAccount;
import lu.snt.serval.lms.framework.interfaces.IUpdatePersonnelAccount;
import lu.snt.serval.lms.framework.user.PersonnelAccount;
import lu.snt.serval.lms.framework.user.User;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;


@Requires({
        @RequiredPort(name = "consultPersonnelAccountOut", type = PortType.SERVICE, className = IConsultPersonnelAccount.class, optional = true),
        @RequiredPort(name="createPersonnelAccountOut", type = PortType.SERVICE, className = ICreatePersonnelAccount.class, optional = true),
        @RequiredPort(name="deletePersonnelAccountOut", type = PortType.SERVICE, className = IDeletePersonnelAccount.class, optional = true),
        @RequiredPort(name="updatePersonnelAccountOut", type = PortType.SERVICE, className = IUpdatePersonnelAccount.class, optional = true)
})

@Provides({
        @ProvidedPort(name = "consultPersonnelAccountIn", type = PortType.SERVICE, className = IConsultPersonnelAccount.class),
        @ProvidedPort(name="createPersonnelAccountIn", type = PortType.SERVICE, className = ICreatePersonnelAccount.class),
        @ProvidedPort(name="deletePersonnelAccountIn", type = PortType.SERVICE, className = IDeletePersonnelAccount.class),
        @ProvidedPort(name="updatePersonnelAccountIn", type = PortType.SERVICE, className = IUpdatePersonnelAccount.class)
})
@ComponentType
@Library(name = "Serval - LMS")
public class PersonnelAccountProxyComponent extends AbstractComponentType implements
        IConsultPersonnelAccount,
        ICreatePersonnelAccount,
        IDeletePersonnelAccount,
        IUpdatePersonnelAccount {

    @Start
    public void start() {
        System.out.println("PersonnelAccountProxyComponent:: start");
    }

    @Stop
    public void stop() {
        System.out.println("PersonnelAccountProxyComponent:: stop");
    }

    @Update
    public void update() {
        System.out.println("PersonnelAccountProxyComponent:: update");
    }


    @Override
    @Port(name = "createPersonnelAccountIn", method = "createPersonnelAccount")
    public void createPersonnelAccount(User Personnel,
                                      PersonnelAccount PersonnelAccount) throws BSException {
        ICreatePersonnelAccount createPersonnelAccountPort = getPortByName("createPersonnelAccountOut",ICreatePersonnelAccount.class);
        createPersonnelAccountPort.createPersonnelAccount(Personnel, PersonnelAccount);
    }

    @Override
    @Port(name = "deletePersonnelAccountIn", method = "deletePersonnelAccount")
    public void deletePersonnelAccount(PersonnelAccount PersonnelAccount) throws BSException {
        IDeletePersonnelAccount deletePersonnelAccountPort = getPortByName("deletePersonnelAccountOut",IDeletePersonnelAccount.class);
        deletePersonnelAccountPort.deletePersonnelAccount(PersonnelAccount);

    }

    @Override
    @Port(name = "updatePersonnelAccountIn", method = "updatePersonnelAccount")
    public void updatePersonnelAccount(User Personnel,
                                      PersonnelAccount PersonnelAccount) throws BSException {
        IUpdatePersonnelAccount updatePersonnelAccountPort = getPortByName("updatePersonnelAccountOut",IUpdatePersonnelAccount.class);
        updatePersonnelAccountPort.updatePersonnelAccount(Personnel, PersonnelAccount);
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
