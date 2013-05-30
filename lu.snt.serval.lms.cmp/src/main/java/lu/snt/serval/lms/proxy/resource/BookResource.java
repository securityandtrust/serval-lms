package lu.snt.serval.lms.proxy.resource;

import lu.snt.serval.lms.bo.book.Book;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;

import java.util.Collection;

public class BookResource implements IborrowBook,

IreserveBook,

IreturnBook,

IfixBook,

IbookDamaged,

IbookRepaired,

IdeliverBook,

IfindBookByState,

IfindBookByKeyword{
	
	private IborrowBook borrowBookService;

	public void setborrowBookService(IborrowBook server) {
		borrowBookService = server;
	}

	private IreserveBook reserveBookService;

	public void setreserveBookService(IreserveBook server) {
		reserveBookService = server;
	}

	private IreturnBook returnBookService;

	public void setreturnBookService(IreturnBook server) {
		returnBookService = server;
	}

	private IfixBook fixBookService;

	public void setfixBookService(IfixBook server) {
		fixBookService = server;
	}

	private IbookDamaged bookDamagedService;

	public void setbookDamagedService(IbookDamaged server) {
		bookDamagedService = server;
	}

	private IbookRepaired bookRepairedService;

	public void setbookRepairedService(IbookRepaired server) {
		bookRepairedService = server;
	}

	private IdeliverBook deliverBookService;

	public void setdeliverBookService(IdeliverBook server) {
		deliverBookService = server;
	}

	private IfindBookByState findBookByStateService;

	public void setfindBookByStateService(IfindBookByState server) {
		findBookByStateService = server;
	}

	private IfindBookByKeyword findBookByKeywordService;

	public void setfindBookByKeywordService(IfindBookByKeyword server) {
		findBookByKeywordService = server;
	}

	@Override
	public void borrowBook(User user, Book book) throws BSException {
		this.borrowBookService.borrowBook(user, book);		
	}

	@Override
	public void reserveBook(User user, Book book) throws BSException {
		this.reserveBookService.reserveBook(user, book);
	}

	@Override
	public void returnBook(User user, Book book) throws BSException {
		this.returnBookService.returnBook(user, book);
	}

	@Override
	public void fixBook(User user, Book book) throws BSException {
		this.fixBookService.fixBook(user, book);
	}

	@Override
	public void bookDamaged(User user, Book book) throws BSException {
		this.bookDamagedService.bookDamaged(user, book);
	}

	@Override
	public void bookRepaired(User user, Book book) throws BSException {
		this.bookRepairedService.bookRepaired(user, book);
	}

	@Override
	public void deliverBook(User user, Book book) throws BSException {
		this.deliverBookService.deliverBook(user, book);
	}

	@Override
	public Collection<Book> findBookByState(String state) throws BSException {
		return this.findBookByStateService.findBookByState(state);
	}

	@Override
	public Collection<Book> findBookByKeyword(String keyword)
			throws BSException {
		return this.findBookByKeywordService.findBookByKeyword(keyword);
	}
	
	
	
}
