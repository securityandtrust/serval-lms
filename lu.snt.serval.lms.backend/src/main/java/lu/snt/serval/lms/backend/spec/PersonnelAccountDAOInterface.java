package lu.snt.serval.lms.backend.spec;


import lu.snt.serval.lms.backend.dao.DAOException;
import lu.snt.serval.lms.backend.dto.UserDTO;
import lu.snt.serval.lms.backend.dto.PersonnelAccountDTO;

import java.sql.SQLException;

public interface PersonnelAccountDAOInterface {


    /**
     * Loads the user personnel account
     *
     * @return
     * @throws java.sql.SQLException
     */
    PersonnelAccountDTO loadUserPersonnelAccount(UserDTO userDTO) throws SQLException, DAOException;


     /**
     * Add new account and return the id
     *
     * @param personnelAccountDTO the account
     * @param userDTO            the user
     * @return the inserted account with the id
     * @throws java.sql.SQLException if any sql problem
     */
    PersonnelAccountDTO insert(UserDTO userDTO, PersonnelAccountDTO personnelAccountDTO) throws SQLException;

    /**
     *
     * @param personnelAccountDTO the account
     * @throws java.sql.SQLException if any sql problems
     */
    void update(PersonnelAccountDTO personnelAccountDTO) throws SQLException;

    /**
     * 
     * @param personnelAccountDTO the account
     * @throws java.sql.SQLException if any sql problems
     */
    void delete(PersonnelAccountDTO personnelAccountDTO) throws SQLException;




}
