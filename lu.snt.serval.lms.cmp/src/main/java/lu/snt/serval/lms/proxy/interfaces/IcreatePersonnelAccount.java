package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IcreatePersonnelAccount {
	public void createPersonnelAccount(lu.snt.serval.lms.bo.user.User personnel,
                                       lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException;
}
