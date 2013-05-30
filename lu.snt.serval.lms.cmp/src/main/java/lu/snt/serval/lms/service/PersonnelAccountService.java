package lu.snt.serval.lms.service;

import lu.snt.serval.lms.bo.user.PersonnelAccount;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.dao.DAOException;
import lu.snt.serval.lms.dao.PersonnelAccountDAO;
import lu.snt.serval.lms.dao.dto.PersonnelAccountDTO;
import lu.snt.serval.lms.dao.dto.UserDTO;
import lu.snt.serval.lms.proxy.interfaces.IconsultPersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IcreatePersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IdeletePersonnelAccount;
import lu.snt.serval.lms.proxy.interfaces.IupdatePersonnelAccount;
import lu.snt.serval.lms.service.exception.BSException;

import java.sql.SQLException;

public class PersonnelAccountService implements IcreatePersonnelAccount, IconsultPersonnelAccount,
	IupdatePersonnelAccount, IdeletePersonnelAccount{


    private static PersonnelAccountService ourInstance = new PersonnelAccountService();

    private PersonnelAccountDAO personnelAccountDAO;

    public static PersonnelAccountService getInstance() {
        return ourInstance;
    }

    public PersonnelAccountService() {

        super();
        // initilizes the DAO
        if (personnelAccountDAO == null)
            personnelAccountDAO = PersonnelAccountDAO.getInstance();

    }

    public void createPersonnelAccount(User personnel, PersonnelAccount personnelAccount) throws BSException {
        if (personnel == null || personnelAccount == null) return;


        // create DTOs
        PersonnelAccountDTO personnelAccountDTO;

        personnelAccountDTO = (PersonnelAccountDTO) personnelAccount.getDTO();
        personnelAccountDTO.setId_user(personnel.getUserId());

        try {
            personnelAccountDAO.insert((UserDTO) personnel.getDTO(), personnelAccountDTO);

            // set the new created id
            personnelAccount.setPersonnelAccountID(personnelAccountDTO.getId_personnel_account());
        } catch (SQLException e) {
            throw new BSException(e.getMessage());
        }
    }

    public void updatePersonnelAccount(User personnel, PersonnelAccount personnelAccount) throws BSException {
       if (personnel == null || personnelAccount == null) return;

        // create DTOs
        PersonnelAccountDTO personnelAccountDTO;

        personnelAccountDTO = (PersonnelAccountDTO) personnelAccount.getDTO();
        personnelAccountDTO.setId_user(personnel.getUserId());

        try {
            //updating
            personnelAccountDAO.update(personnelAccountDTO);

        } catch (SQLException e) {
            throw new BSException(e.getMessage());

        }

    }

    public void deletePersonnelAccount(PersonnelAccount personnelAccount) throws BSException {
        
        if (personnelAccount == null) return;


        // create DTOs
        PersonnelAccountDTO personnelAccountDTO;

        personnelAccountDTO = (PersonnelAccountDTO) personnelAccount.getDTO();
        //personnelAccountDTO.setId_user(personnel.getUserId());

        try {
            //updating
        	personnelAccountDAO.delete(personnelAccountDTO);
            //personnelAccountDAO.delete((UserDTO) personnel.getDTO(), personnelAccountDTO);

        } catch (SQLException e) {
            throw new BSException(e.getMessage());
        }
    }
    
    public PersonnelAccount consultPersonnelAccount(User personnel) throws BSException{

    	if (personnel == null) return null;
    	
    	PersonnelAccountDTO personnelAccountDTO;
        PersonnelAccount pa;


        try {
        	personnelAccountDTO = personnelAccountDAO.loadUserPersonnelAccount((UserDTO) personnel.getDTO());

            pa = new PersonnelAccount();
            pa.setFromDTO(personnelAccountDTO);

        } catch (DAOException e) {
            throw new BSException(e.getMessage());
        } catch (SQLException e) {
            throw new BSException(e.getMessage());

        }

        return pa;
    }
}
