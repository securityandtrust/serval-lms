package lu.snt.serval.lms.proxy.role;

import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;

import java.util.Collection;

class LIBRARIAN extends Fake implements IfindBookByState,

IconsultBorrowerAccount,

IbookRepaired,

IbookDamaged, IFake {
	private String[] interfaces = new String[]{

	IfindBookByState.class.getName(),

	IconsultBorrowerAccount.class.getName(),

	IbookRepaired.class.getName(),

	IbookDamaged.class.getName(),

	IFake.class.getName()};

	public String[] getInterfaces() {
		return interfaces;
	}

	private IfindBookByState findBookByStateService;

	public void setfindBookByStateService(IfindBookByState server) {
		findBookByStateService = server;
	}

	public Collection<lu.snt.serval.lms.bo.book.Book> findBookByState(String state)
			throws BSException {
		return findBookByStateService.findBookByState(state);
	}

	private IconsultBorrowerAccount consultBorrowerAccountService;

	public void setconsultBorrowerAccountService(IconsultBorrowerAccount server) {
		consultBorrowerAccountService = server;
	}

	public lu.snt.serval.lms.bo.user.BorrowerAccount consultBorrowerAccount(
            lu.snt.serval.lms.bo.user.User borrower) throws BSException {
		return consultBorrowerAccountService.consultBorrowerAccount(borrower);
	}

	private IbookRepaired bookRepairedService;

	public void setbookRepairedService(IbookRepaired server) {
		bookRepairedService = server;
	}

	public void bookRepaired(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		bookRepairedService.bookRepaired(user, book);
	}

	private IbookDamaged bookDamagedService;

	public void setbookDamagedService(IbookDamaged server) {
		bookDamagedService = server;
	}

	public void bookDamaged(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		bookDamagedService.bookDamaged(user, book);
	}

}
