package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IreserveBook {
	public void reserveBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException;
}
