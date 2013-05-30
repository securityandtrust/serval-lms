package lu.snt.serval.lms.service;

import lu.snt.serval.lms.bo.user.BorrowerAccount;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.dao.BorrowerAccountDAO;
import lu.snt.serval.lms.dao.DAOException;
import lu.snt.serval.lms.dao.dto.BorrowerAccountDTO;
import lu.snt.serval.lms.dao.dto.UserDTO;
import lu.snt.serval.lms.proxy.interfaces.IconsultBorrowerAccount;
import lu.snt.serval.lms.proxy.interfaces.IcreateBorrowerAccount;
import lu.snt.serval.lms.proxy.interfaces.IdeleteBorrowerAccount;
import lu.snt.serval.lms.proxy.interfaces.IupdateBorrowerAccount;
import lu.snt.serval.lms.service.exception.BSException;

import java.sql.SQLException;

/**
 * User: Tej
 * Date: 6 mars 2007
 * Time: 10:21:03
 */
public class BorrowerAccountService implements IconsultBorrowerAccount, 
	IcreateBorrowerAccount, IdeleteBorrowerAccount, IupdateBorrowerAccount{

   private static BorrowerAccountService ourInstance = new BorrowerAccountService();

    private BorrowerAccountDAO borrowerAccountDAO;

    public static BorrowerAccountService getInstance() {
        return ourInstance;
    }

    public BorrowerAccountService() {

        // initilizes the DAO
        if (borrowerAccountDAO == null)
            borrowerAccountDAO = BorrowerAccountDAO.getInstance();

    }

    
    public void createBorrowerAccount(User borrower, BorrowerAccount borrowerAccount) throws BSException {
    	if(borrower == null || borrowerAccount == null) return;
    	
        // create DTOs
        BorrowerAccountDTO borrowerAccountDTO;

        borrowerAccountDTO = (BorrowerAccountDTO) borrowerAccount.getDTO();
        borrowerAccountDTO.setId_user(borrower.getUserId());


        try {
            borrowerAccountDAO.insert((UserDTO) borrower.getDTO(), borrowerAccountDTO);

            // set the new created id
            borrowerAccount.setBorrowerAccountID(borrowerAccountDTO.getId_borrower_account());
        } catch (SQLException e) {
            throw new BSException(e.getMessage());
            
        }


    }

    public void updateBorrowerAccount(User borrower, BorrowerAccount borrowerAccount) throws BSException {
    	if(borrower == null || borrowerAccount == null) return;
    	
        // create DTOs
        BorrowerAccountDTO borrowerAccountDTO;

        borrowerAccountDTO = (BorrowerAccountDTO) borrowerAccount.getDTO();
        borrowerAccountDTO.setId_user(borrower.getUserId());


        try {
            //updating
            borrowerAccountDAO.update(borrowerAccountDTO);

        } catch (SQLException e) {
            throw new BSException(e.getMessage());

        }

    }

    public void deleteBorrowerAccount(BorrowerAccount borrowerAccount) throws BSException {
    	if(borrowerAccount == null) return;
    	
        // create DTOs
        BorrowerAccountDTO borrowerAccountDTO;

        borrowerAccountDTO = (BorrowerAccountDTO) borrowerAccount.getDTO();
//        borrowerAccountDTO.setId_user(borrower.getUserId());


        try {

            // deleting
//            borrowerAccountDAO.delete((UserDTO) borrower.getDTO(),borrowerAccountDTO);
        	borrowerAccountDAO.delete(borrowerAccountDTO);


        } catch (SQLException e) {
            throw new BSException(e.getMessage());

        }
    }

    public BorrowerAccount consultBorrowerAccount(User borrower) throws BSException{
    	if(borrower == null) return null;
    	
        BorrowerAccountDTO borrowerAccountDTO;
        BorrowerAccount ba;


        try {
            borrowerAccountDTO = borrowerAccountDAO.loadUserBorrowerAccount((UserDTO) borrower.getDTO());

            ba = new BorrowerAccount();
            ba.setFromDTO(borrowerAccountDTO);

        } catch (DAOException e) {
            throw new BSException(e.getMessage());
        } catch (SQLException e) {
            throw new BSException(e.getMessage());

        }

        return ba;
    }
}
