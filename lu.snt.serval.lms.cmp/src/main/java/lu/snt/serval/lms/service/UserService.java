package lu.snt.serval.lms.service;


import lu.snt.serval.lms.bo.user.*;
import lu.snt.serval.lms.dao.*;
import lu.snt.serval.lms.dao.dto.BookDTO;
import lu.snt.serval.lms.dao.dto.BorrowerAccountDTO;
import lu.snt.serval.lms.dao.dto.PersonnelAccountDTO;
import lu.snt.serval.lms.dao.dto.UserDTO;
import lu.snt.serval.lms.service.exception.BSException;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserService implements UserServiceInterface {

    private static UserService ourInstance = new UserService();

    // personnel
    public static String PERSONNEL_LOGIN_MODE = "PERSONNEL", BORROWER_LOGIN_MODE = "BORROWER";

    private UserDAO userDAO;
    private BorrowerAccountDAO borrowerAccountDAO;
    private PersonnelAccountDAO personnelAccountDAO;
    private BookDAO bookDAO;

    public static UserService getInstance() {
        return ourInstance;
    }

    public UserService() {       
        // initilizes DAOs
        if (userDAO == null)
            userDAO = UserDAO.getInstance();

        if (borrowerAccountDAO == null)
            borrowerAccountDAO = BorrowerAccountDAO.getInstance();

        if (personnelAccountDAO == null)
            personnelAccountDAO = PersonnelAccountDAO.getInstance();

          if (bookDAO == null)
            bookDAO = BookDAO.getInstance();

    }
    
    public User createUser(User user) throws BSException {
        
        UserDTO userDTO;

        // create DTO
		userDTO = (UserDTO) user.getDTO();

		userDAO.insertUser(userDTO);

		// set the new created id
		user.setUserId(userDTO.getId_user());
        
        return user;
    }

    public void createUserRole(User user, Role role) throws BSException {
        // check security policy

        UserDTO userDTO;


        // create DTOs
		userDTO = (UserDTO) user.getDTO();

		userDAO.insertUserRole(userDTO,role.getRoleName());


		// set the new created id
		user.setRole(role);

    }

    public void deleteUser(User user) throws BSException {
        // check security policy
        
         UserDTO userDTO;

        // create DTOs
		userDTO = (UserDTO) user.getDTO();

		userDAO.deleteUser(userDTO);


    }

    public void deleteUserRole(User user, Role role) throws BSException {
      // check security policy

         UserDTO userDTO;

        // create DTOs
		userDTO = (UserDTO) user.getDTO();

		userDAO.deleteUserRole(userDTO,role.getRoleName());
        


    }

    public User logUser(String login, String password, String loginMode) throws BSException {


        UserDTO userDTO;
        User user;

       try {

           // create DTOs
           userDTO = new UserDTO();
           userDTO.setLogin(login);
           userDTO.setPassword(password);

           boolean result = userDAO.checkLoginAndPassword(userDTO);

           if(!result) // wrong pass and login
        	   return null;

           // retrieve the user infos
          userDTO = userDAO.loadUserFromLoginAndPassword(userDTO);

          user = new User(userDTO);

          // now load the role
          String userRole = userDAO.checkUserRoleMatch(userDTO,loginMode);

           if(userRole != null) {
           // load the account

            // load borrower infos
            if(loginMode.equals(BORROWER_LOGIN_MODE)) {

                BorrowerAccountDTO borrowerAccount = borrowerAccountDAO.loadUserBorrowerAccount(userDTO);

                BorrowerAccount ba = new BorrowerAccount();
                ba.setFromDTO(borrowerAccount);
                user.defineRole(userRole);
                ((Borrower) user.getRole()).setBorrowerAccount(ba);

                // load borrowed and reserved books
                Collection<BookDTO> bors = bookDAO.loadUserBorrowedBooks(userDTO);
                user.setBorrowedFromDTOs(bors);
                Collection<BookDTO> res = bookDAO.loadUserReservedBooks(userDTO);
                user.setReservationsFromDTOs(res);
            }

            else if(loginMode.equals(PERSONNEL_LOGIN_MODE)) {

                // load the account
                PersonnelAccountDTO personnelAccountDTO = personnelAccountDAO.loadUserPersonnelAccount(userDTO);

                PersonnelAccount pa = new PersonnelAccount();
                pa.setFromDTO(personnelAccountDTO);

                //set the role
                user.defineRole(userRole);


                ((Personnel) user.getRole()).setPersonnelAccount(pa);

            }

           }

           else {

                throw new BSException("The user '" + login + "' cannot connect with mode '" + loginMode + "'");

           }

       } catch (SQLException e) {
           throw new BSException(e.getMessage());

       } catch (DAOException e) {
           throw new BSException(e.getMessage());
       
       }
        
      return user;
    }
    
    public List<BorrowerAccount> loadAllBorrowerAccounts(){
    	List<BorrowerAccount> result = new ArrayList<BorrowerAccount>();
    	
    	List<BorrowerAccountDTO> l = borrowerAccountDAO.loadAllBorrowerAccounts();   	
    	for(int i = 0; i < l.size(); i++){
    		BorrowerAccount ba = new BorrowerAccount();
            ba.setFromDTO(l.get(i));
            result.add(ba);
    	}
    	
    	return result;
    }

	@Override
	public List<PersonnelAccount> loadAllPersonnelAccounts() {
		List<PersonnelAccount> result = new ArrayList<PersonnelAccount>();
    	
    	List<PersonnelAccountDTO> l = personnelAccountDAO.loadAllPersonnelAccounts();
    	for(int i = 0; i < l.size(); i++){
    		PersonnelAccount pa = new PersonnelAccount();
            pa.setFromDTO(l.get(i));
            result.add(pa);
    	}
    	
    	return result;
	}
	
	public List<User> loadAllPersonnelUsers(){
		List<User> result = new ArrayList<User>();
		
		List<PersonnelAccountDTO> l = personnelAccountDAO.loadAllPersonnelAccounts();
		
		for(int i = 0; i < l.size(); i++){
			PersonnelAccountDTO pa = l.get(i);
			
			User u = new User();
            try {
            	UserDTO userDTO = userDAO.loadUserFromId(pa.getId_user());
            	String userRole = userDAO.checkUserRoleMatch(userDTO, PERSONNEL_LOGIN_MODE);
				u.setFromDTO(userDTO);
				u.defineRole(userRole);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            result.add(u);
    	}
		
		return result;
	}
	
	public List<User> loadAllBorrowerUsers(){
		List<User> result = new ArrayList<User>();
		
		List<BorrowerAccountDTO> l = borrowerAccountDAO.loadAllBorrowerAccounts();
		
		for(int i = 0; i < l.size(); i++){
			BorrowerAccountDTO ba = l.get(i);
			
			User u = new User();
            try {
            	UserDTO userDTO = userDAO.loadUserFromId(ba.getId_user());
            	String userRole = userDAO.checkUserRoleMatch(userDTO, BORROWER_LOGIN_MODE);
				u.setFromDTO(userDTO);
				u.defineRole(userRole);
			} catch (DAOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            result.add(u);
    	}
		
		return result;
	}
}
