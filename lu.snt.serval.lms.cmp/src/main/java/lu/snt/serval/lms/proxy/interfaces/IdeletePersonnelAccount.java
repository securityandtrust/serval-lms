package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IdeletePersonnelAccount {
	public void deletePersonnelAccount(
            lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException;
}
