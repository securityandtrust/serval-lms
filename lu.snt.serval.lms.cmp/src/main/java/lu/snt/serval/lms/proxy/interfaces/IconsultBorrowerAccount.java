package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IconsultBorrowerAccount {
	public lu.snt.serval.lms.bo.user.BorrowerAccount consultBorrowerAccount(
            lu.snt.serval.lms.bo.user.User borrower) throws BSException;
}
