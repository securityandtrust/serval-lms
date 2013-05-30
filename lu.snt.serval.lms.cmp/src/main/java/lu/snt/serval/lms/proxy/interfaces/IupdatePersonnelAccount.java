package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IupdatePersonnelAccount {
	public void updatePersonnelAccount(lu.snt.serval.lms.bo.user.User personnel,
                                       lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException;
}
