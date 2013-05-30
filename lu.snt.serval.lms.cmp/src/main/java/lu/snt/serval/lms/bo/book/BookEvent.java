package lu.snt.serval.lms.bo.book;


import lu.snt.serval.lms.bo.user.User;

public abstract class BookEvent {

	public abstract void execute(Book b, User user) throws InvalidActionException;

}
