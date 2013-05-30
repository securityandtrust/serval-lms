package lu.snt.serval.lms.proxy.interfaces;

import lu.snt.serval.lms.service.exception.BSException;
import java.util.Collection;

public class Fake implements IconsultBorrowerAccount,

IcreateBorrowerAccount,

IdeleteBorrowerAccount,

IupdateBorrowerAccount,

IborrowBook,

IreserveBook,

IreturnBook,

IfixBook,

IbookDamaged,

IbookRepaired,

IdeliverBook,

IfindBookByState,

IfindBookByKeyword,

IcreatePersonnelAccount,

IupdatePersonnelAccount,

IdeletePersonnelAccount,

IconsultPersonnelAccount, IFake {

	public lu.snt.serval.lms.bo.user.BorrowerAccount consultBorrowerAccount(
            lu.snt.serval.lms.bo.user.User borrower) throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void createBorrowerAccount(lu.snt.serval.lms.bo.user.User borrower,
                                      lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void deleteBorrowerAccount(
            lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void updateBorrowerAccount(lu.snt.serval.lms.bo.user.User borrower,
                                      lu.snt.serval.lms.bo.user.BorrowerAccount borrowerAccount) throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void borrowBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void reserveBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void returnBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void fixBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void bookDamaged(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void bookRepaired(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void deliverBook(lu.snt.serval.lms.bo.user.User user, lu.snt.serval.lms.bo.book.Book book)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public Collection<lu.snt.serval.lms.bo.book.Book> findBookByState(String state)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public Collection<lu.snt.serval.lms.bo.book.Book> findBookByKeyword(String keyword)
			throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void createPersonnelAccount(lu.snt.serval.lms.bo.user.User personnel,
                                       lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void updatePersonnelAccount(lu.snt.serval.lms.bo.user.User personnel,
                                       lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public void deletePersonnelAccount(
            lu.snt.serval.lms.bo.user.PersonnelAccount personnelAccount) throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

	public lu.snt.serval.lms.bo.user.PersonnelAccount consultPersonnelAccount(
            lu.snt.serval.lms.bo.user.User personnel) throws BSException {
		throw new BSException("You are NOT authorised to do this action!!!");
	}

}
