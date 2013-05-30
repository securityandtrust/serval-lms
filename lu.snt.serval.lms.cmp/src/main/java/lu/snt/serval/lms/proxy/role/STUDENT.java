package lu.snt.serval.lms.proxy.role;

import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;

import java.util.Collection;

class STUDENT extends Fake implements IfindBookByKeyword,

IreturnBook,

IreserveBook,

IborrowBook, IFake {
	private String[] interfaces = new String[]{

	IfindBookByKeyword.class.getName(),

	IreturnBook.class.getName(),

	IreserveBook.class.getName(),

	IborrowBook.class.getName(),

	IFake.class.getName()};

	public String[] getInterfaces() {
		return interfaces;
	}

	private IfindBookByKeyword findBookByKeywordService;

	public void setfindBookByKeywordService(IfindBookByKeyword server) {
		findBookByKeywordService = server;
	}

	public Collection<lu.snt.serval.lms.bo.book.Book> findBookByKeyword(String keyword)
			throws BSException {
		return findBookByKeywordService.findBookByKeyword(keyword);
	}

	private IreturnBook returnBookService;

	public void setreturnBookService(IreturnBook server) {
		returnBookService = server;
	}

	public void returnBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		returnBookService.returnBook(user, book);
	}

	private IreserveBook reserveBookService;

	public void setreserveBookService(IreserveBook server) {
		reserveBookService = server;
	}

	public void reserveBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		reserveBookService.reserveBook(user, book);
	}

	private IborrowBook borrowBookService;

	public void setborrowBookService(IborrowBook server) {
		borrowBookService = server;
	}

	public void borrowBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		borrowBookService.borrowBook(user, book);
	}

}
