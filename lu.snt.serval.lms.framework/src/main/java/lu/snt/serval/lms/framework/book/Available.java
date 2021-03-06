package lu.snt.serval.lms.framework.book;

import lu.snt.serval.lms.framework.exceptions.InvalidActionException;
import lu.snt.serval.lms.framework.user.User;

/**
 *
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Available extends BookState {


	public void reserve(Book b, User user) {
		b.addRes(user);
		b.setCurrentState(new Reserved());
	}


	public void borrow(Book b, User user) {
		b.rmRes(user);
		b.setCurrentState(new Borrowed());
	}


	/**
	 * @see BookState#fix(Book)
	 */
	public void fix(Book b) throws InvalidActionException {
		if (b.isDamaged())
			b.setCurrentState(new BeingFixed());
		else
			throw new InvalidActionException("The com.library.bo.book is not damaged");
	}



}
