package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;
import java.util.Collection;

public interface IfindBookByState {
	public Collection<lu.snt.serval.lms.bo.book.Book> findBookByState(String state)
			throws BSException;
}
