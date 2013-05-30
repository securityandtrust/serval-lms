package lu.snt.serval.lms.proxy.role;

import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;

class LECTURER extends Fake implements IborrowBook,

IreserveBook,

IreturnBook, IFake {
	private String[] interfaces = new String[]{

	IborrowBook.class.getName(),

	IreserveBook.class.getName(),

	IreturnBook.class.getName(),

	IFake.class.getName()};

	public String[] getInterfaces() {
		return interfaces;
	}

	private IborrowBook borrowBookService;

	public void setborrowBookService(IborrowBook server) {
		borrowBookService = server;
	}

	public void borrowBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		borrowBookService.borrowBook(user, book);
	}

	private IreserveBook reserveBookService;

	public void setreserveBookService(IreserveBook server) {
		reserveBookService = server;
	}

	public void reserveBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		reserveBookService.reserveBook(user, book);
	}

	private IreturnBook returnBookService;

	public void setreturnBookService(IreturnBook server) {
		returnBookService = server;
	}

	public void returnBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		returnBookService.returnBook(user, book);
	}

}
