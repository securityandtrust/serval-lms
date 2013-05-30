package lu.snt.serval.lms.proxy.role;

import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;

class DIRECTOR extends Fake implements IdeleteBorrowerAccount,

IupdateBorrowerAccount,

IcreateBorrowerAccount,

IconsultBorrowerAccount,

IconsultPersonnelAccount, IFake {
	private String[] interfaces = new String[]{

	IdeleteBorrowerAccount.class.getName(),

	IupdateBorrowerAccount.class.getName(),

	IcreateBorrowerAccount.class.getName(),

	IconsultBorrowerAccount.class.getName(),

	IconsultPersonnelAccount.class.getName(),

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

	private IconsultBorrowerAccount consultBorrowerAccountService;

	public void setconsultBorrowerAccountService(IconsultBorrowerAccount server) {
		consultBorrowerAccountService = server;
	}

	public lu.snt.serval.lms.bo.user.BorrowerAccount consultBorrowerAccount(
            lu.snt.serval.lms.bo.user.User borrower) throws BSException {
		return consultBorrowerAccountService.consultBorrowerAccount(borrower);
	}

	private IconsultPersonnelAccount consultPersonnelAccountService;

	public void setconsultPersonnelAccountService(
			IconsultPersonnelAccount server) {
		consultPersonnelAccountService = server;
	}

	public lu.snt.serval.lms.bo.user.PersonnelAccount consultPersonnelAccount(
            lu.snt.serval.lms.bo.user.User personnel) throws BSException {
		return consultPersonnelAccountService
				.consultPersonnelAccount(personnel);
	}

}
