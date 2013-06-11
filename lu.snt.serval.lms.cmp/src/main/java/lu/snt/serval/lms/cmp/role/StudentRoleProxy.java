package lu.snt.serval.lms.cmp.role;

import org.kevoree.annotation.*;

//@Requires({
//        @RequiredPort(name = "borrowBookOut", type = PortType.SERVICE, className = IBorrowBook.class, optional = true),
//        @RequiredPort(name="reserveBookOut", type = PortType.SERVICE, className = IReserveBook.class, optional = true),
//        @RequiredPort(name="returnBookOut", type = PortType.SERVICE, className = IReturnBook.class, optional = true)
//})
//
//@Provides({
//        @ProvidedPort(name="borrowBookIn", type = PortType.SERVICE, className = IBorrowBook.class),
//        @ProvidedPort(name="reserveBook", type = PortType.SERVICE, className = IReserveBook.class),
//        @ProvidedPort(name="returnBook", type = PortType.SERVICE, className = IReturnBook.class)
//})

@ComponentType
@Library(name = "Serval - LMS")
public class StudentRoleProxy extends BorrowerRoleProxy{

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
