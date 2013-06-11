package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface IDeletePersonnelAccount {
	public void deletePersonnelAccount(
            lu.snt.serval.lms.framework.user.PersonnelAccount personnelAccount) throws BSException;
}
