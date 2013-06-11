package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;
import java.util.Collection;

public interface IFindBookByState {
	public Collection<lu.snt.serval.lms.framework.book.Book> findBookByState(String state)
			throws BSException;
}
