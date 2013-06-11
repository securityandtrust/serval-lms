package lu.snt.serval.lms.framework.interfaces;

import lu.snt.serval.lms.framework.exceptions.BSException;

public interface IConsultPersonnelAccount {
	public lu.snt.serval.lms.framework.user.PersonnelAccount consultPersonnelAccount(
            lu.snt.serval.lms.framework.user.User personnel) throws BSException;
}
