package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;

public interface IconsultPersonnelAccount {
	public lu.snt.serval.lms.bo.user.PersonnelAccount consultPersonnelAccount(
            lu.snt.serval.lms.bo.user.User personnel) throws BSException;
}
