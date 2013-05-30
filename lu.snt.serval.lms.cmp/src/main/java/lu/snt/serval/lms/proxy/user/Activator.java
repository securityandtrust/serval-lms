package lu.snt.serval.lms.proxy.user;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import java.util.Properties;

public class Activator implements BundleActivator {
	@Override
	public void start(BundleContext bundleContext) throws Exception {

		bob mybobService = new bob();

		Properties metadata_bob = new Properties();
		metadata_bob.setProperty("host", "bob");

		ServiceReference[] refIdeleteBorrowerAccount_bob = bundleContext
				.getServiceReferences(
						lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount.class
								.getName(), "(host=SECRETARY)");
        lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount serverIdeleteBorrowerAccount_bob = (lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount) bundleContext
				.getService(refIdeleteBorrowerAccount_bob[0]);
		mybobService
				.setdeleteBorrowerAccountService(serverIdeleteBorrowerAccount_bob);

		ServiceReference[] refIupdateBorrowerAccount_bob = bundleContext
				.getServiceReferences(
                        lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount.class
								.getName(), "(host=SECRETARY)");
        lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount serverIupdateBorrowerAccount_bob = (lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount) bundleContext
				.getService(refIupdateBorrowerAccount_bob[0]);
		mybobService
				.setupdateBorrowerAccountService(serverIupdateBorrowerAccount_bob);

		ServiceReference[] refIcreateBorrowerAccount_bob = bundleContext
				.getServiceReferences(
                        lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount.class
								.getName(), "(host=SECRETARY)");
        lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount serverIcreateBorrowerAccount_bob = (lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount) bundleContext
				.getService(refIcreateBorrowerAccount_bob[0]);
		mybobService
				.setcreateBorrowerAccountService(serverIcreateBorrowerAccount_bob);

		ServiceReference[] refIdeliverBook_bob = bundleContext
				.getServiceReferences(
                        lu.snt.serval.lms.proxy.interfaces.IdeliverBook.class.getName(),
						"(host=SECRETARY)");
        lu.snt.serval.lms.proxy.interfaces.IdeliverBook serverIdeliverBook_bob = (lu.snt.serval.lms.proxy.interfaces.IdeliverBook) bundleContext
				.getService(refIdeliverBook_bob[0]);
		mybobService.setdeliverBookService(serverIdeliverBook_bob);

		ServiceReference[] refIconsultBorrowerAccount_bob = bundleContext
				.getServiceReferences(
                        lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount.class
								.getName(), "(host=LIBRARIAN)");
        lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount serverIconsultBorrowerAccount_bob = (lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount) bundleContext
				.getService(refIconsultBorrowerAccount_bob[0]);
		mybobService
				.setconsultBorrowerAccountService(serverIconsultBorrowerAccount_bob);

		ServiceReference[] refIconsultPersonnelAccount_bob = bundleContext
				.getServiceReferences(
                        lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount.class
								.getName(), "(host=DIRECTOR)");
        lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount serverIconsultPersonnelAccount_bob = (lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount) bundleContext
				.getService(refIconsultPersonnelAccount_bob[0]);
		mybobService
				.setconsultPersonnelAccountService(serverIconsultPersonnelAccount_bob);

		bundleContext.registerService(mybobService.getInterfaces(),
				mybobService, metadata_bob);

	}

	@Override
	public void stop(BundleContext arg0) throws Exception {

	}
}
