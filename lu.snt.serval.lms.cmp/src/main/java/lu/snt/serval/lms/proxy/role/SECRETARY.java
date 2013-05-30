package lu.snt.serval.lms.proxy.role;

import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;

class SECRETARY extends Fake implements IdeleteBorrowerAccount,

IupdateBorrowerAccount,

IcreateBorrowerAccount,

IdeliverBook,

IconsultBorrowerAccount, IFake {
	private String[] interfaces = new String[]{

	IdeleteBorrowerAccount.class.getName(),

	IupdateBorrowerAccount.class.getName(),

	IcreateBorrowerAccount.class.getName(),

	IdeliverBook.class.getName(),

	IconsultBorrowerAccount.class.getName(),

	IFake.class.getName()};

	public String[] getInterfaces() {
		return interfaces;
	}

	private IdeleteBorrowerAccount deleteBorrowerAccountService;

	public void setdeleteBorrowerAccountService(IdeleteBorrowerAccount server) {
		deleteBorrowerAccountService = server;
	}

	public void deleteBorrowerAccount(
            lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException {
		deleteBorrowerAccountService.deleteBorrowerAccount(borrowerAccount);
	}

	private IupdateBorrowerAccount updateBorrowerAccountService;

	public void setupdateBorrowerAccountService(IupdateBorrowerAccount server) {
		updateBorrowerAccountService = server;
	}

	public void updateBorrowerAccount(lu.snt.serval.lms.bo.user.User borrower,
                                      lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException {
		updateBorrowerAccountService.updateBorrowerAccount(borrower,
				borrowerAccount);
	}

	private IcreateBorrowerAccount createBorrowerAccountService;

	public void setcreateBorrowerAccountService(IcreateBorrowerAccount server) {
		createBorrowerAccountService = server;
	}

	public void createBorrowerAccount(lu.snt.serval.lms.bo.user.User borrower,
                                      lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException {
		createBorrowerAccountService.createBorrowerAccount(borrower,
				borrowerAccount);
	}

	private IdeliverBook deliverBookService;

	public void setdeliverBookService(IdeliverBook server) {
		deliverBookService = server;
	}

	public void deliverBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		deliverBookService.deliverBook(user, book);
	}

	private IconsultBorrowerAccount consultBorrowerAccountService;

	public void setconsultBorrowerAccountService(IconsultBorrowerAccount server) {
		consultBorrowerAccountService = server;
	}

	public lu.snt.serval.lms.bo.user.BorrowerAccount consultBorrowerAccount(
            lu.snt.serval.lms.bo.user.User borrower) throws BSException {
		return consultBorrowerAccountService.consultBorrowerAccount(borrower);
	}

}
