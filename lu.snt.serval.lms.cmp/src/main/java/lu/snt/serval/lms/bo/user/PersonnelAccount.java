package lu.snt.serval.lms.bo.user;


import lu.snt.serval.lms.dao.dto.PersonnelAccountDTO;

import java.util.Date;


public class PersonnelAccount extends Account {

    private boolean isCanConsultBorrowerAccount;

    private int personnelAccountID;
    
    private int userID;

    public PersonnelAccount(Date creationDate, boolean canConsultBorrowerAccount) {
        super(creationDate);
        isCanConsultBorrowerAccount = canConsultBorrowerAccount;
    }

    public PersonnelAccount(boolean active, Date creationDate, boolean canConsultBorrowerAccount) {
        super(active, creationDate);
        isCanConsultBorrowerAccount = canConsultBorrowerAccount;
    }

    public PersonnelAccount(boolean active, boolean canConsultBorrowerAccount) {
        super(active);
        isCanConsultBorrowerAccount = canConsultBorrowerAccount;
    }

    public PersonnelAccount(boolean canConsultBorrowerAccount) {
        isCanConsultBorrowerAccount = canConsultBorrowerAccount;
    }

    public PersonnelAccount() {
        isCanConsultBorrowerAccount = true;

    }

    public boolean isCanConsultBorrowerAccount() {
        return isCanConsultBorrowerAccount;
    }

    public void setCanConsultBorrowerAccount(boolean canConsultBorrowerAccount) {
        isCanConsultBorrowerAccount = canConsultBorrowerAccount;
    }


    public int getPersonnelAccountID() {
        return personnelAccountID;
    }

    public void setPersonnelAccountID(int personnelAccountID) {
        this.personnelAccountID = personnelAccountID;
    }

    public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	public void setFromDTO(PersonnelAccountDTO dto) {
         PersonnelAccountDTO personnelAccountDTO;

        personnelAccountDTO = (PersonnelAccountDTO) dto;

        setActive(personnelAccountDTO.getActive() == 1);
        setCanConsultBorrowerAccount(personnelAccountDTO.getCan_consult() == 1);
        setPersonnelAccountID(personnelAccountDTO.getId_personnel_account());

        setCreationDate(personnelAccountDTO.getCreation_date());
        
        setUserID(personnelAccountDTO.getId_user());

    }

    public PersonnelAccountDTO getDTO() {
        PersonnelAccountDTO personnelAccountDTO;

        personnelAccountDTO = new PersonnelAccountDTO();
        personnelAccountDTO.setActive(isActive() ? 1: 0);
        personnelAccountDTO.setCan_consult(isCanConsultBorrowerAccount ? 1: 0);
        personnelAccountDTO.setCreation_date(getCreationDate());
        personnelAccountDTO.setId_personnel_account(personnelAccountID);
        personnelAccountDTO.setId_user(userID);

        return personnelAccountDTO;

    }


      public boolean equals(Object obj) {

        if(!(obj instanceof PersonnelAccount)) return false;

        return // personnelAccountID == ((PersonnelAccount) obj).getPersonnelAccountID() &&
               //isCanConsultBorrowerAccount == ((PersonnelAccount) obj).isCanConsultBorrowerAccount();
                    isActive == ((PersonnelAccount) obj).isActive;

    }
}
