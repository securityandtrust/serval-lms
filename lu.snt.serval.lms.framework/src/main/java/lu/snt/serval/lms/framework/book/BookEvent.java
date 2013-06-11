package lu.snt.serval.lms.framework.book;


import lu.snt.serval.lms.framework.exceptions.InvalidActionException;
import lu.snt.serval.lms.framework.user.User;

public abstract class BookEvent {

	public abstract void execute(Book b, User user) throws InvalidActionException;

}
