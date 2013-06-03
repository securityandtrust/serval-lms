package lu.snt.serval.lms.cmp.role;

import org.kevoree.annotation.*;

//@Requires({
//        @RequiredPort(name = "borrowBookOut", type = PortType.SERVICE, className = IborrowBook.class, optional = true),
//        @RequiredPort(name="reserveBookOut", type = PortType.SERVICE, className = IreserveBook.class, optional = true),
//        @RequiredPort(name="returnBookOut", type = PortType.SERVICE, className = IreturnBook.class, optional = true)
//})
//
//@Provides({
//        @ProvidedPort(name="borrowBookIn", type = PortType.SERVICE, className = IborrowBook.class),
//        @ProvidedPort(name="reserveBook", type = PortType.SERVICE, className = IreserveBook.class),
//        @ProvidedPort(name="returnBook", type = PortType.SERVICE, className = IreturnBook.class)
//})

@ComponentType
@Library(name = "Serval - LMS")
class StudentRoleProxy extends BorrowerRoleProxy{

    @Start
    public void start() {
        System.out.println("StudentRoleProxy:: start");
    }

    @Stop
    public void stop() {
        System.out.println("StudentRoleProxy:: stop");
    }

    @Update
    public void update() {
        System.out.println("StudentRoleProxy:: update");
    }

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */
}
