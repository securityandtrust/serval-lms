package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface IReturnBook {
	public void returnBook(lu.snt.serval.lms.framework.user.User user, lu.snt.serval.lms.framework.book.Book book)
			throws BSException;
}
