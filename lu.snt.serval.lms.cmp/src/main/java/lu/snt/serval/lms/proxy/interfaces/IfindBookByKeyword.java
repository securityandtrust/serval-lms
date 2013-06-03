package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IfindBookByKeyword {
	public java.util.Collection<lu.snt.serval.lms.bo.book.Book> findBookByKeyword(String keyword)
			throws BSException;
}
