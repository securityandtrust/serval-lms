package lu.snt.serval.lms.proxy.role;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Properties;

public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {

		DIRECTOR myDIRECTORService = new DIRECTOR();

		Properties metadata_DIRECTOR = new Properties();
		metadata_DIRECTOR.setProperty("host", "DIRECTOR");

		ServiceReference[] refIdeleteBorrowerAccount_DIRECTOR = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount serverIdeleteBorrowerAccount_DIRECTOR = (lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount) bundleContext
				.getService(refIdeleteBorrowerAccount_DIRECTOR[0]);
		myDIRECTORService
				.setdeleteBorrowerAccountService(serverIdeleteBorrowerAccount_DIRECTOR);

		ServiceReference[] refIupdateBorrowerAccount_DIRECTOR = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount serverIupdateBorrowerAccount_DIRECTOR = (lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount) bundleContext
				.getService(refIupdateBorrowerAccount_DIRECTOR[0]);
		myDIRECTORService
				.setupdateBorrowerAccountService(serverIupdateBorrowerAccount_DIRECTOR);

		ServiceReference[] refIcreateBorrowerAccount_DIRECTOR = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount serverIcreateBorrowerAccount_DIRECTOR = (lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount) bundleContext
				.getService(refIcreateBorrowerAccount_DIRECTOR[0]);
		myDIRECTORService
				.setcreateBorrowerAccountService(serverIcreateBorrowerAccount_DIRECTOR);

		ServiceReference[] refIconsultBorrowerAccount_DIRECTOR = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount serverIconsultBorrowerAccount_DIRECTOR = (lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount) bundleContext
				.getService(refIconsultBorrowerAccount_DIRECTOR[0]);
		myDIRECTORService
				.setconsultBorrowerAccountService(serverIconsultBorrowerAccount_DIRECTOR);

		ServiceReference[] refIconsultPersonnelAccount_DIRECTOR = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount.class
								.getName(), "(host=PersonnelAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount serverIconsultPersonnelAccount_DIRECTOR = (lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount) bundleContext
				.getService(refIconsultPersonnelAccount_DIRECTOR[0]);
		myDIRECTORService
				.setconsultPersonnelAccountService(serverIconsultPersonnelAccount_DIRECTOR);

		bundleContext.registerService(myDIRECTORService.getInterfaces(),
				myDIRECTORService, metadata_DIRECTOR);

		SECRETARY mySECRETARYService = new SECRETARY();

		Properties metadata_SECRETARY = new Properties();
		metadata_SECRETARY.setProperty("host", "SECRETARY");

		ServiceReference[] refIdeleteBorrowerAccount_SECRETARY = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount serverIdeleteBorrowerAccount_SECRETARY = (lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount) bundleContext
				.getService(refIdeleteBorrowerAccount_SECRETARY[0]);
		mySECRETARYService
				.setdeleteBorrowerAccountService(serverIdeleteBorrowerAccount_SECRETARY);

		ServiceReference[] refIupdateBorrowerAccount_SECRETARY = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount serverIupdateBorrowerAccount_SECRETARY = (lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount) bundleContext
				.getService(refIupdateBorrowerAccount_SECRETARY[0]);
		mySECRETARYService
				.setupdateBorrowerAccountService(serverIupdateBorrowerAccount_SECRETARY);

		ServiceReference[] refIcreateBorrowerAccount_SECRETARY = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount serverIcreateBorrowerAccount_SECRETARY = (lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount) bundleContext
				.getService(refIcreateBorrowerAccount_SECRETARY[0]);
		mySECRETARYService
				.setcreateBorrowerAccountService(serverIcreateBorrowerAccount_SECRETARY);

		ServiceReference[] refIdeliverBook_SECRETARY = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IdeliverBook.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IdeliverBook serverIdeliverBook_SECRETARY = (lu.snt.serval.lms.proxy.interfaces.IdeliverBook) bundleContext
				.getService(refIdeliverBook_SECRETARY[0]);
		mySECRETARYService.setdeliverBookService(serverIdeliverBook_SECRETARY);

		ServiceReference[] refIconsultBorrowerAccount_SECRETARY = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount serverIconsultBorrowerAccount_SECRETARY = (lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount) bundleContext
				.getService(refIconsultBorrowerAccount_SECRETARY[0]);
		mySECRETARYService
				.setconsultBorrowerAccountService(serverIconsultBorrowerAccount_SECRETARY);

		bundleContext.registerService(mySECRETARYService.getInterfaces(),
				mySECRETARYService, metadata_SECRETARY);

		ADMIN myADMINService = new ADMIN();

		Properties metadata_ADMIN = new Properties();
		metadata_ADMIN.setProperty("host", "ADMIN");

		ServiceReference[] refIdeletePersonnelAccount_ADMIN = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IdeletePersonnelAccount.class
								.getName(), "(host=PersonnelAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IdeletePersonnelAccount serverIdeletePersonnelAccount_ADMIN = (lu.snt.serval.lms.proxy.interfaces.IdeletePersonnelAccount) bundleContext
				.getService(refIdeletePersonnelAccount_ADMIN[0]);
		myADMINService
				.setdeletePersonnelAccountService(serverIdeletePersonnelAccount_ADMIN);

		ServiceReference[] refIupdatePersonnelAccount_ADMIN = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IupdatePersonnelAccount.class
								.getName(), "(host=PersonnelAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IupdatePersonnelAccount serverIupdatePersonnelAccount_ADMIN = (lu.snt.serval.lms.proxy.interfaces.IupdatePersonnelAccount) bundleContext
				.getService(refIupdatePersonnelAccount_ADMIN[0]);
		myADMINService
				.setupdatePersonnelAccountService(serverIupdatePersonnelAccount_ADMIN);

		ServiceReference[] refIcreatePersonnelAccount_ADMIN = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IcreatePersonnelAccount.class
								.getName(), "(host=PersonnelAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IcreatePersonnelAccount serverIcreatePersonnelAccount_ADMIN = (lu.snt.serval.lms.proxy.interfaces.IcreatePersonnelAccount) bundleContext
				.getService(refIcreatePersonnelAccount_ADMIN[0]);
		myADMINService
				.setcreatePersonnelAccountService(serverIcreatePersonnelAccount_ADMIN);

		ServiceReference[] refIconsultPersonnelAccount_ADMIN = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount.class
								.getName(), "(host=PersonnelAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount serverIconsultPersonnelAccount_ADMIN = (lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount) bundleContext
				.getService(refIconsultPersonnelAccount_ADMIN[0]);
		myADMINService
				.setconsultPersonnelAccountService(serverIconsultPersonnelAccount_ADMIN);

		bundleContext.registerService(myADMINService.getInterfaces(),
				myADMINService, metadata_ADMIN);

		LIBRARIAN myLIBRARIANService = new LIBRARIAN();

		Properties metadata_LIBRARIAN = new Properties();
		metadata_LIBRARIAN.setProperty("host", "LIBRARIAN");

		ServiceReference[] refIfindBookByState_LIBRARIAN = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IfindBookByState.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IfindBookByState serverIfindBookByState_LIBRARIAN = (lu.snt.serval.lms.proxy.interfaces.IfindBookByState) bundleContext
				.getService(refIfindBookByState_LIBRARIAN[0]);
		myLIBRARIANService
				.setfindBookByStateService(serverIfindBookByState_LIBRARIAN);

		ServiceReference[] refIconsultBorrowerAccount_LIBRARIAN = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount.class
								.getName(), "(host=BorrowerAccountResource)");
		lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount serverIconsultBorrowerAccount_LIBRARIAN = (lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount) bundleContext
				.getService(refIconsultBorrowerAccount_LIBRARIAN[0]);
		myLIBRARIANService
				.setconsultBorrowerAccountService(serverIconsultBorrowerAccount_LIBRARIAN);

		ServiceReference[] refIbookRepaired_LIBRARIAN = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IbookRepaired.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IbookRepaired serverIbookRepaired_LIBRARIAN = (lu.snt.serval.lms.proxy.interfaces.IbookRepaired) bundleContext
				.getService(refIbookRepaired_LIBRARIAN[0]);
		myLIBRARIANService
				.setbookRepairedService(serverIbookRepaired_LIBRARIAN);

		ServiceReference[] refIbookDamaged_LIBRARIAN = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IbookDamaged.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IbookDamaged serverIbookDamaged_LIBRARIAN = (lu.snt.serval.lms.proxy.interfaces.IbookDamaged) bundleContext
				.getService(refIbookDamaged_LIBRARIAN[0]);
		myLIBRARIANService.setbookDamagedService(serverIbookDamaged_LIBRARIAN);

		bundleContext.registerService(myLIBRARIANService.getInterfaces(),
				myLIBRARIANService, metadata_LIBRARIAN);

		LECTURER myLECTURERService = new LECTURER();

		Properties metadata_LECTURER = new Properties();
		metadata_LECTURER.setProperty("host", "LECTURER");

		ServiceReference[] refIborrowBook_LECTURER = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IborrowBook.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IborrowBook serverIborrowBook_LECTURER = (lu.snt.serval.lms.proxy.interfaces.IborrowBook) bundleContext
				.getService(refIborrowBook_LECTURER[0]);
		myLECTURERService.setborrowBookService(serverIborrowBook_LECTURER);

		ServiceReference[] refIreserveBook_LECTURER = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IreserveBook.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IreserveBook serverIreserveBook_LECTURER = (lu.snt.serval.lms.proxy.interfaces.IreserveBook) bundleContext
				.getService(refIreserveBook_LECTURER[0]);
		myLECTURERService.setreserveBookService(serverIreserveBook_LECTURER);

		ServiceReference[] refIreturnBook_LECTURER = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IreturnBook.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IreturnBook serverIreturnBook_LECTURER = (lu.snt.serval.lms.proxy.interfaces.IreturnBook) bundleContext
				.getService(refIreturnBook_LECTURER[0]);
		myLECTURERService.setreturnBookService(serverIreturnBook_LECTURER);

		bundleContext.registerService(myLECTURERService.getInterfaces(),
				myLECTURERService, metadata_LECTURER);

		STUDENT mySTUDENTService = new STUDENT();

		Properties metadata_STUDENT = new Properties();
		metadata_STUDENT.setProperty("host", "STUDENT");

		ServiceReference[] refIfindBookByKeyword_STUDENT = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IfindBookByKeyword.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IfindBookByKeyword serverIfindBookByKeyword_STUDENT = (lu.snt.serval.lms.proxy.interfaces.IfindBookByKeyword) bundleContext
				.getService(refIfindBookByKeyword_STUDENT[0]);
		mySTUDENTService
				.setfindBookByKeywordService(serverIfindBookByKeyword_STUDENT);

		ServiceReference[] refIreturnBook_STUDENT = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IreturnBook.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IreturnBook serverIreturnBook_STUDENT = (lu.snt.serval.lms.proxy.interfaces.IreturnBook) bundleContext
				.getService(refIreturnBook_STUDENT[0]);
		mySTUDENTService.setreturnBookService(serverIreturnBook_STUDENT);

		ServiceReference[] refIreserveBook_STUDENT = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IreserveBook.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IreserveBook serverIreserveBook_STUDENT = (lu.snt.serval.lms.proxy.interfaces.IreserveBook) bundleContext
				.getService(refIreserveBook_STUDENT[0]);
		mySTUDENTService.setreserveBookService(serverIreserveBook_STUDENT);

		ServiceReference[] refIborrowBook_STUDENT = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IborrowBook.class.getName(),
						"(host=BookResource)");
		lu.snt.serval.lms.proxy.interfaces.IborrowBook serverIborrowBook_STUDENT = (lu.snt.serval.lms.proxy.interfaces.IborrowBook) bundleContext
				.getService(refIborrowBook_STUDENT[0]);
		mySTUDENTService.setborrowBookService(serverIborrowBook_STUDENT);

		bundleContext.registerService(mySTUDENTService.getInterfaces(),
				mySTUDENTService, metadata_STUDENT);

	}

	@Override
	public void stop(BundleContext arg0) throws Exception {

	}
}
