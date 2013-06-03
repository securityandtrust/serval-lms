package lu.snt.serval.lms.proxy.resource;/*
* Author : Phu H. Nguyen (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/

import lu.snt.serval.lms.bo.user.PersonnelAccount;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IcreatePersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IdeletePersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IupdatePersonnelAccount;
import lu.snt.serval.lms.service.exception.BSException;
import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;


@Requires({
        @RequiredPort(name = "consultPersonnelAccountOut", type = PortType.SERVICE, className = IconsultPersonnelAccount.class, optional = true),
        @RequiredPort(name="createPersonnelAccountOut", type = PortType.SERVICE, className = IcreatePersonnelAccount.class, optional = true),
        @RequiredPort(name="deletePersonnelAccountOut", type = PortType.SERVICE, className = IdeletePersonnelAccount.class, optional = true),
        @RequiredPort(name="updatePersonnelAccountOut", type = PortType.SERVICE, className = IupdatePersonnelAccount.class, optional = true)
})

@Provides({
        @ProvidedPort(name = "consultPersonnelAccountIn", type = PortType.SERVICE, className = IconsultPersonnelAccount.class),
        @ProvidedPort(name="createPersonnelAccountIn", type = PortType.SERVICE, className = IcreatePersonnelAccount.class),
        @ProvidedPort(name="deletePersonnelAccountIn", type = PortType.SERVICE, className = IdeletePersonnelAccount.class),
        @ProvidedPort(name="updatePersonnelAccountIn", type = PortType.SERVICE, className = IupdatePersonnelAccount.class)
})
@ComponentType
@Library(name = "Serval - LMS")
public class PersonnelAccountProxyComponent extends AbstractComponentType implements
        IconsultPersonnelAccount,
        IcreatePersonnelAccount,
        IdeletePersonnelAccount,
        IupdatePersonnelAccount {

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
        IcreatePersonnelAccount createPersonnelAccountPort = getPortByName("createPersonnelAccountOut",IcreatePersonnelAccount.class);
        createPersonnelAccountPort.createPersonnelAccount(Personnel, PersonnelAccount);
    }

    @Override
    @Port(name = "deletePersonnelAccountIn", method = "deletePersonnelAccount")
    public void deletePersonnelAccount(PersonnelAccount PersonnelAccount) throws BSException {
        IdeletePersonnelAccount deletePersonnelAccountPort = getPortByName("deletePersonnelAccountOut",IdeletePersonnelAccount.class);
        deletePersonnelAccountPort.deletePersonnelAccount(PersonnelAccount);

    }

    @Override
    @Port(name = "updatePersonnelAccountIn", method = "updatePersonnelAccount")
    public void updatePersonnelAccount(User Personnel,
                                      PersonnelAccount PersonnelAccount) throws BSException {
        IupdatePersonnelAccount updatePersonnelAccountPort = getPortByName("updatePersonnelAccountOut",IupdatePersonnelAccount.class);
        updatePersonnelAccountPort.updatePersonnelAccount(Personnel, PersonnelAccount);
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
