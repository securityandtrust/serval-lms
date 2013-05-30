package lu.snt.serval.lms.proxy.role;

import lu.snt.serval.lms.proxy.interfaces.*;
import lu.snt.serval.lms.service.exception.BSException;

class ADMIN extends Fake implements IdeletePersonnelAccount,

IupdatePersonnelAccount,

IcreatePersonnelAccount,

IconsultPersonnelAccount, IFake {
	private String[] interfaces = new String[]{

	IdeletePersonnelAccount.class.getName(),

	IupdatePersonnelAccount.class.getName(),

	IcreatePersonnelAccount.class.getName(),

	IconsultPersonnelAccount.class.getName(),

	IFake.class.getName()};

	public String[] getInterfaces() {
		return interfaces;
	}

	private IdeletePersonnelAccount deletePersonnelAccountService;

	public void setdeletePersonnelAccountService(IdeletePersonnelAccount server) {
		deletePersonnelAccountService = server;
	}

	public void deletePersonnelAccount(
            lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException {
		deletePersonnelAccountService.deletePersonnelAccount(personnelAccount);
	}

	private IupdatePersonnelAccount updatePersonnelAccountService;

	public void setupdatePersonnelAccountService(IupdatePersonnelAccount server) {
		updatePersonnelAccountService = server;
	}

	public void updatePersonnelAccount(lu.snt.serval.lms.bo.user.User personnel,
                                       lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException {
		updatePersonnelAccountService.updatePersonnelAccount(personnel,
				personnelAccount);
	}

	private IcreatePersonnelAccount createPersonnelAccountService;

	public void setcreatePersonnelAccountService(IcreatePersonnelAccount server) {
		createPersonnelAccountService = server;
	}

	public void createPersonnelAccount(lu.snt.serval.lms.bo.user.User personnel,
                                       lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException {
		createPersonnelAccountService.createPersonnelAccount(personnel,
				personnelAccount);
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
