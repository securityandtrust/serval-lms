package lu.snt.serval.lms.proxy.resource;

import lu.snt.serval.lms.bo.user.BorrowerAccount;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount;
import lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount;
import lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount;
import lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount;
import lu.snt.serval.lms.service.exception.BSException;

public class BorrowerAccountResource implements IconsultBorrowerAccount, IcreateBorrowerAccount, IdeleteBorrowerAccount, IupdateBorrowerAccount {
	
//	private static BorrowerAccountResource ourInstance = new BorrowerAccountResource();
//	
//	public static BorrowerAccountResource getInstance() {
//        return ourInstance;
//    }
//	
//	public BorrowerAccountResource() {
//
//        // initilizes the BorrowerAccountService
//        if (borrowerAccountService == null)
//        	borrowerAccountService = BorrowerAccountService.getInstance();
//
//    }
	
	/* The following (generated) code deal with binding and unbinding the ports of the component */
//	private BorrowerAccountServiceInterface borrowerAccountService;
//	
//	public void setBorrowerAccountService(BorrowerAccountServiceInterface server){
//		borrowerAccountService = server;
//	}

	private IcreateBorrowerAccount createBorrowerAccountService;

	public void setcreateBorrowerAccountService(IcreateBorrowerAccount server) {
		createBorrowerAccountService = server;
	}
	
	public void createBorrowerAccount(User borrower,
			BorrowerAccount borrowerAccount) throws BSException {
		// TODO Auto-generated method stub
		createBorrowerAccountService.createBorrowerAccount(borrower, borrowerAccount);
	}

	private IdeleteBorrowerAccount deleteBorrowerAccountService;

	public void setdeleteBorrowerAccountService(IdeleteBorrowerAccount server) {
		deleteBorrowerAccountService = server;
	}
	
	public void deleteBorrowerAccount(BorrowerAccount borrowerAccount) throws BSException {
		// TODO Auto-generated method stub
		deleteBorrowerAccountService.deleteBorrowerAccount(borrowerAccount);
	}

	private IupdateBorrowerAccount updateBorrowerAccountService;

	public void setupdateBorrowerAccountService(IupdateBorrowerAccount server) {
		updateBorrowerAccountService = server;
	}
	
	public void updateBorrowerAccount(User borrower,
			BorrowerAccount borrowerAccount) throws BSException {
		// TODO Auto-generated method stub
		updateBorrowerAccountService.updateBorrowerAccount(borrower, borrowerAccount);
	}
	
	private IconsultBorrowerAccount consultBorrowerAccountService;
	
	public void setconsultBorrowerAccountService(IconsultBorrowerAccount server){
		consultBorrowerAccountService = server;
	}
	
	public BorrowerAccount consultBorrowerAccount(User borrower) throws BSException {
		// TODO Auto-generated method stub
		return consultBorrowerAccountService.consultBorrowerAccount(borrower);
	}
	
	/* End of generated code. You can now implement the business logic of the component
	 * (Quick Fix: Add Unimplemented Method)
	 */
	
}
