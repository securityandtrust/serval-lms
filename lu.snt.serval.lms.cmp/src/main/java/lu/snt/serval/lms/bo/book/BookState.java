package lu.snt.serval.lms.bo.book;

import lu.snt.serval.lms.bo.user.User;


public abstract class BookState {
	
	
	public void reserve(Book b, User user) throws InvalidActionException {
		throw new InvalidActionException("State : " + this.getClass().getName() + " unable to reserve");
	}
	public void deliver(Book b) throws InvalidActionException {
		throw new InvalidActionException("State : " + this.getClass().getName() + " unable to deliver");
	}
	public void borrow(Book b, User user) throws InvalidActionException {
		throw new InvalidActionException("State : " + this.getClass().getName() + " unable to borrow");
	}
	public void giveBack(Book b) throws InvalidActionException {
		throw new InvalidActionException("State : " + this.getClass().getName() + " unable to giveBack");
	}
	public void fix(Book b) throws InvalidActionException {
		throw new InvalidActionException("State : " + this.getClass().getName() + " unable to fix");
	}

}
