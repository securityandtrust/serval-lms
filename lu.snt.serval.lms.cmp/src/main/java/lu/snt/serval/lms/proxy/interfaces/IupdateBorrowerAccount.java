package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IupdateBorrowerAccount {
	public void updateBorrowerAccount(lu.snt.serval.lms.bo.user.User borrower,
                                      lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException;
}
