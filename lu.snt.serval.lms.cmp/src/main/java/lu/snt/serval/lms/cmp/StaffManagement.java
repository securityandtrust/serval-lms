package lu.snt.serval.lms.cmp;/*
* Author : Gregory Nain (developer.name@uni.lu)
* Date : 20/11/12
* (c) 2012 University of Luxembourg – Interdisciplinary Centre for Security Reliability and Trust (SnT)
* All rights reserved
*/


import org.kevoree.annotation.*;
import org.kevoree.framework.AbstractComponentType;

@Provides({
        @ProvidedPort(name="add", type = PortType.MESSAGE),
        @ProvidedPort(name="list", type = PortType.MESSAGE),
        @ProvidedPort(name="update", type = PortType.MESSAGE),
        @ProvidedPort(name="remove", type = PortType.MESSAGE)
})
@ComponentType
@Library(name = "Serval - LMS")
public class StaffManagement extends AbstractComponentType {


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
    }

    @Port(name = "update")
    public void updateStaffMember(Object o) {
    }

    @Port(name = "list")
    public void listStaffMembers(Object o) {
    }

    @Port(name = "remove")
    public void removeStaffMember(Object o) {
    }

}
