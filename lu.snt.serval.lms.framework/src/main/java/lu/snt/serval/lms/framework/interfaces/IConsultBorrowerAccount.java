package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface IConsultBorrowerAccount {
	public lu.snt.serval.lms.framework.user.BorrowerAccount consultBorrowerAccount(
            lu.snt.serval.lms.framework.user.User borrower) throws BSException;
}
