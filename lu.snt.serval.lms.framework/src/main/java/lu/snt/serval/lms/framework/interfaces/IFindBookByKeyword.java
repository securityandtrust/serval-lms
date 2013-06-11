package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface IFindBookByKeyword {
	public java.util.Collection<lu.snt.serval.lms.framework.book.Book> findBookByKeyword(String keyword)
			throws BSException;
}
