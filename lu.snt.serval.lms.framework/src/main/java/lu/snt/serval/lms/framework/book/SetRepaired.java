package lu.snt.serval.lms.framework.book;


import lu.snt.serval.lms.framework.exceptions.InvalidActionException;
import lu.snt.serval.lms.framework.user.User;


public class SetRepaired extends BookEvent {


	public void execute(Book b, User user) throws InvalidActionException {
		b.setDamaged(false);
	}

}
