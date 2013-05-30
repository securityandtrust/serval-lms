package lu.snt.serval.lms.bo.book;

import lu.snt.serval.lms.bo.user.User;

public class Borrowed extends BookState {

	public void reserve(Book b, User user) {
		b.addRes(user);
	}

	/**
	 * @see BookState#giveBack(Book)
	 */
	public void giveBack(Book b) {
		if (b.getNbRes() > 0)
			b.setCurrentState(new Reserved());
		else
			b.setCurrentState(new Available());
	}


    public String toString() {
        return "Borrowed";
    }
}
