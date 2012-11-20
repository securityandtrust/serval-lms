package lu.snt.serval.lms.cmp;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/


import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Provides({
        @ProvidedPort(name="add", type = PortType.MESSAGE),
        @ProvidedPort(name="list", type = PortType.MESSAGE),
        @ProvidedPort(name="update", type = PortType.MESSAGE),
        @ProvidedPort(name="remove", type = PortType.MESSAGE)
})
@ComponentType
@Library(name = "Serval - LMS")
public class StaffManagement extends AbstractComponentType {

    private static Logger logger = LoggerFactory.getLogger(StaffManagement.class);

    @Start
    public void start() {
    }
    
    @Stop
    public void stop() {
    }
    
    @Update
    public void update() {
    }


    @Port(name = "add")
    public void addStaffMember(Object o) {
        logger.debug(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

    @Port(name = "update")
    public void updateStaffMember(Object o) {
        logger.debug(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

    @Port(name = "list")
    public void listStaffMembers(Object o) {
        logger.debug(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

    @Port(name = "remove")
    public void removeStaffMember(Object o) {
        logger.debug(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

}
