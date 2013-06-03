package lu.snt.serval.lms.proxy.role;

import lu.snt.serval.lms.proxy.interfaces.IborrowBook;
import lu.snt.serval.lms.proxy.interfaces.IreserveBook;
import lu.snt.serval.lms.proxy.interfaces.IreturnBook;
import org.kevoree.annotation.*;

@Requires({
        @RequiredPort(name = "borrowBookOut", type = PortType.SERVICE, className = IborrowBook.class, optional = true),
        @RequiredPort(name="reserveBookOut", type = PortType.SERVICE, className = IreserveBook.class, optional = true),
        @RequiredPort(name="returnBookOut", type = PortType.SERVICE, className = IreturnBook.class, optional = true)
})

@Provides({
        @ProvidedPort(name="borrowBookIn", type = PortType.SERVICE, className = IborrowBook.class),
        @ProvidedPort(name="reserveBook", type = PortType.SERVICE, className = IreserveBook.class),
        @ProvidedPort(name="returnBook", type = PortType.SERVICE, className = IreturnBook.class)
})

@ComponentType
@Library(name = "Serval - LMS")
class LecturerRoleProxy extends BorrowerRoleProxy{

    @Start
    public void start() {
        System.out.println("LecturerRoleProxy:: start");
    }

    @Stop
    public void stop() {
        System.out.println("LecturerRoleProxy:: stop");
    }

    @Update
    public void update() {
        System.out.println("LecturerRoleProxy:: update");
    }

    /* End of generated code. You can now implement the business logic of the component
      * (Quick Fix: Add Unimplemented Method)
      */
}
