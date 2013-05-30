package lu.snt.serval.lms.bo.book;

import lu.snt.serval.lms.bo.user.User;


public class GiveBack extends BookEvent {


	public void execute(Book b, User user)  throws InvalidActionException {
		b.getCurrentState().giveBack(b);
	}

}
