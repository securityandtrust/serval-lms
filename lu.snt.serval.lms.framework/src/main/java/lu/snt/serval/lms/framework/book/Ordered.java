package lu.snt.serval.lms.framework.book;

import lu.snt.serval.lms.framework.user.User;


/**
 * To change this generated comment edit the template variable "typecomment":
 * Window>Preferences>Java>Templates.
 * To enable and disable the creation of type comments go to
 * Window>Preferences>Java>Code Generation.
 */
public class Ordered extends BookState {


	public void reserve(Book b, User user) {
		b.addRes(user);
	}

	/**
	 * @see BookState#deliver(Book)
	 */
	public void deliver(Book b) {
		if (b.getNbRes() > 0)
			b.setCurrentState(new Available());
		else
			b.setCurrentState(new Available());
		
	}

}
