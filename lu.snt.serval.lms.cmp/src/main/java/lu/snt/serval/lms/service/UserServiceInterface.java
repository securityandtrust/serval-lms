package lu.snt.serval.lms.service;

import lu.snt.serval.lms.bo.user.BorrowerAccount;
import lu.snt.serval.lms.bo.user.PersonnelAccount;
import lu.snt.serval.lms.bo.user.Role;
import lu.snt.serval.lms.bo.user.User;
import lu.snt.serval.lms.service.exception.BSException;

import java.util.List;


/**
 * User: Tej
 * Date: 6 mars 2007
 * Time: 10:47:40
 */
public interface UserServiceInterface {

    /**
     * create a new user
     * @param user the user to create
     * @return the created user
     * @throws lu.snt.serval.lms.service.exception.BSException
     */
    User createUser(User user) throws BSException;

    /**
     * create a role for the user
     * @param user the user to create
     * @param role the role to create
     * @throws lu.snt.serval.lms.service.exception.BSException
     */
    void createUserRole(User user, Role role) throws BSException;

    /**
     * create a new user
     * @param user the user to create
     * @throws lu.snt.serval.lms.service.exception.BSException
     */
    void deleteUser(User user) throws BSException;

    /**
     * create a role for the user
     * @param user the user to create
     * @param role the role to delete
     * @throws lu.snt.serval.lms.service.exception.BSException
     */
    void deleteUserRole(User user, Role role) throws BSException;

    /**
     *
     * @param login  the user login
     * @param password  the user password
     * @param loginMode the login mode can be PERSONNEL or BORROWER
     * @return  the user
     * @throws BSException if problems occur
     */
    User logUser(String login, String password, String loginMode) throws BSException;

    List<BorrowerAccount> loadAllBorrowerAccounts();
    
    List<PersonnelAccount> loadAllPersonnelAccounts();
    
    List<User> loadAllBorrowerUsers();
    
    List<User> loadAllPersonnelUsers();
}
