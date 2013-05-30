package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IdeleteBorrowerAccount {
	public void deleteBorrowerAccount(
            lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException;
}
