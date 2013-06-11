package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface IUpdateBorrowerAccount {
	public void updateBorrowerAccount(lu.snt.serval.lms.framework.user.User borrower,
                                      lu.snt.serval.lms.framework.user.BorrowerAccount borrowerAccount) throws BSException;
}
