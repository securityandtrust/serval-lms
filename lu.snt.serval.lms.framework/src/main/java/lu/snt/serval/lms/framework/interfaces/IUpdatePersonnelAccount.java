package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface IUpdatePersonnelAccount {
	public void updatePersonnelAccount(lu.snt.serval.lms.framework.user.User personnel,
                                       lu.snt.serval.lms.framework.user.PersonnelAccount personnelAccount) throws BSException;
}
