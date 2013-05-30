package lu.snt.serval.lms.bo.book;

import lu.snt.serval.lms.bo.user.User;

public class Borrow extends BookEvent {


	public void execute(Book b, User user) throws InvalidActionException {
        if(user == null) new InvalidActionException("Missing com.library.bo.user parameter");


        b.getCurrentState().borrow(b, user);

	}

}
