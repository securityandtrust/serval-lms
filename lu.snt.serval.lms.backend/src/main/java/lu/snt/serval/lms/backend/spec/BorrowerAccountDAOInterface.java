package lu.snt.serval.lms.backend.spec;

import lu.snt.serval.lms.backend.dao.DAOException;
import lu.snt.serval.lms.backend.dto.BorrowerAccountDTO;
import lu.snt.serval.lms.backend.dto.UserDTO;

import java.sql.SQLException;
import java.util.List;


public interface BorrowerAccountDAOInterface {


    /**
     * Loads the user borrower account
     *
     * @param userDTO the user
     * @return the borrowerAccount
     * @throws java.sql.SQLException if any sql problem
     * @throws lu.snt.serval.lms.backend.dao.DAOException if ant DAO problem (not entry found)
     */
    BorrowerAccountDTO loadUserBorrowerAccount(UserDTO userDTO) throws SQLException, DAOException;

    /**
     * Add new account and return the id
     *
     * @param borrowerAccountDTO the account
     * @param userDTO            the user
     * @return the inserted account with the id
     * @throws java.sql.SQLException if any sql problem
     */
    BorrowerAccountDTO insert(UserDTO userDTO, BorrowerAccountDTO borrowerAccountDTO) throws SQLException;

    /**
     * Updates the borrower's account
     *
     * @param borrowerAccountDTO the borrower account
     * @throws java.sql.SQLException if any sql problem
     */
    void update(BorrowerAccountDTO borrowerAccountDTO) throws SQLException;

    void delete(BorrowerAccountDTO borrowerAccountDTO) throws SQLException;

    List<BorrowerAccountDTO> loadAllBorrowerAccounts();
}
