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

import java.lang.reflect.Method;

@Provides({
        @ProvidedPort(name="add", type = PortType.MESSAGE),
        @ProvidedPort(name="list", type = PortType.MESSAGE),
        @ProvidedPort(name="update", type = PortType.MESSAGE),
        @ProvidedPort(name="remove", type = PortType.MESSAGE)
})
@ComponentType
@Library(name = "Serval - LMS")
public class BooksManagement extends AbstractComponentType {

    private static Logger logger = LoggerFactory.getLogger(BooksManagement.class);


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
    public void addBook(Object o) {
        logger.debug(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

    @Port(name = "update")
    public void updateBook(Object o) {
        logger.debug(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

    @Port(name = "list")
    public void listBooks(Object o) {
        logger.debug(Thread.currentThread().getStackTrace()[0].getMethodName());
    }

    @Port(name = "remove")
    public void removeBook(Object o) {
        logger.debug(Thread.currentThread().getStackTrace()[0].getMethodName());
    }
    
}
