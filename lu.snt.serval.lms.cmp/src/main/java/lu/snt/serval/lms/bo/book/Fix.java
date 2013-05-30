package lu.snt.serval.lms.bo.book;

import lu.snt.serval.lms.bo.user.User;


public class Fix extends BookEvent {


	public void execute(Book b, User user)  throws InvalidActionException {
		b.getCurrentState().fix(b);
	}

}
