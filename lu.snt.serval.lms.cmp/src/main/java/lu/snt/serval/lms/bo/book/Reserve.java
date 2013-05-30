package lu.snt.serval.lms.bo.book;

import lu.snt.serval.lms.bo.user.User;


public class Reserve extends BookEvent {


    public void execute(Book b, User user) throws InvalidActionException {
        if (user == null) throw new InvalidActionException("Missing com.library.bo.user parameter");

        b.getCurrentState().reserve(b, user);


    }

}
