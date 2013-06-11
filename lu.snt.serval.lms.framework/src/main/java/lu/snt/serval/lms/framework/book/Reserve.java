package lu.snt.serval.lms.framework.book;

import lu.snt.serval.lms.framework.exceptions.InvalidActionException;
import lu.snt.serval.lms.framework.user.User;


public class Reserve extends BookEvent {


    public void execute(Book b, User user) throws InvalidActionException {
        if (user == null) throw new InvalidActionException("Missing com.library.bo.user parameter");

        b.getCurrentState().reserve(b, user);


    }

}
