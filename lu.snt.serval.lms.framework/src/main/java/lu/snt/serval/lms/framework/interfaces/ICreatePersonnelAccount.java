package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface ICreatePersonnelAccount {
	public void createPersonnelAccount(lu.snt.serval.lms.framework.user.User personnel,
                                       lu.snt.serval.lms.framework.user.PersonnelAccount personnelAccount) throws BSException;
}
