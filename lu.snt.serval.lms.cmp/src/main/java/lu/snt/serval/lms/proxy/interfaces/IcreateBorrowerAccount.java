package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IcreateBorrowerAccount {
	public void createBorrowerAccount(lu.snt.serval.lms.bo.user.User borrower,
                                      lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException;
}
