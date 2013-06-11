package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface ICreateBorrowerAccount {
	public void createBorrowerAccount(lu.snt.serval.lms.framework.user.User borrower,
                                      lu.snt.serval.lms.framework.user.BorrowerAccount borrowerAccount) throws BSException;
}
