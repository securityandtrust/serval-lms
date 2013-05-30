package lu.snt.serval.lms.proxy.resource;

import lu.snt.serval.lms.bo.user.PersonnelAccount;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IcreatePersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IdeletePersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IupdatePersonnelAccount;
import lu.snt.serval.lms.service.exception.BSException;

public class PersonnelAccountResource implements IcreatePersonnelAccount, IdeletePersonnelAccount, 
	IupdatePersonnelAccount, IconsultPersonnelAccount {
//	private static PersonnelAccountResource ourInstance = new PersonnelAccountResource();
//	
//	public static PersonnelAccountResource getInstance() {
//        return ourInstance;
//    }
//	
//	public PersonnelAccountResource() {
//
//        // initilizes the PersonnelAccountService
//        if (personnelAccountService == null)
//        	personnelAccountService = PersonnelAccountService.getInstance();
//
//    }
//	
//	/* The following (generated) code deal with binding and unbinding the ports of the component */
//	private PersonnelAccountServiceInterface personnelAccountService;
//	
//	public void setPersonnelAccountService(PersonnelAccountServiceInterface server){
//		personnelAccountService = server;
//	}
	
	private IcreatePersonnelAccount createPersonnelAccountService;

	public void setcreatePersonnelAccountService(IcreatePersonnelAccount server) {
		createPersonnelAccountService = server;
	}
	
	public void createPersonnelAccount(User personnel, PersonnelAccount personnelAccount) throws BSException {
		// TODO Auto-generated method stub
		createPersonnelAccountService.createPersonnelAccount(personnel, personnelAccount);
	}

	private IdeletePersonnelAccount deletePersonnelAccountService;

	public void setdeletePersonnelAccountService(IdeletePersonnelAccount server) {
		deletePersonnelAccountService = server;
	}
	
	//public void deletePersonnelAccount(User personnel, PersonnelAccount personnelAccount) throws BSException {
	public void deletePersonnelAccount(PersonnelAccount personnelAccount) throws BSException {
		// TODO Auto-generated method stub
		deletePersonnelAccountService.deletePersonnelAccount(personnelAccount);
	}

	private IupdatePersonnelAccount updatePersonnelAccountService;

	public void setupdatePersonnelAccountService(IupdatePersonnelAccount server) {
		updatePersonnelAccountService = server;
	}
	
	public void updatePersonnelAccount(User personnel, PersonnelAccount personnelAccount) throws BSException {
		// TODO Auto-generated method stub
		updatePersonnelAccountService.updatePersonnelAccount(personnel, personnelAccount);
	}
	
	private IconsultPersonnelAccount consultPersonnelAccountService;
	
	public void setconsultPersonnelAccountService(IconsultPersonnelAccount server){
		consultPersonnelAccountService = server;
	}

	@Override
	public PersonnelAccount consultPersonnelAccount(User personnel)
			throws BSException {
		// TODO Auto-generated method stub
		return consultPersonnelAccountService.consultPersonnelAccount(personnel);
	}

	/* End of generated code. You can now implement the business logic of the component
	 * (Quick Fix: Add Unimplemented Method)
	 */
}
