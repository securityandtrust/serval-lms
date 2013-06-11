package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface IDeleteBorrowerAccount {
	public void deleteBorrowerAccount(
            lu.snt.serval.lms.framework.user.BorrowerAccount borrowerAccount) throws BSException;
}
