package lu.snt.serval.lms.framework.book;

import lu.snt.serval.lms.framework.exceptions.InvalidActionException;
import lu.snt.serval.lms.framework.user.User;

public class Borrow extends BookEvent {


	public void execute(Book b, User user) throws InvalidActionException {
        if(user == null) new InvalidActionException("Missing com.library.bo.user parameter");


        b.getCurrentState().borrow(b, user);

	}

}
