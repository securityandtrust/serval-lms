package lu.snt.serval.lms.framework.user;

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


    public boolean equals(Object obj) {

        if(!(obj instanceof PersonnelAccount)) return false;

        return // personnelAccountID == ((PersonnelAccount) obj).getPersonnelAccountID() &&
                //isCanConsultBorrowerAccount == ((PersonnelAccount) obj).isCanConsultBorrowerAccount();
                isActive == ((PersonnelAccount) obj).isActive;

    }
}
