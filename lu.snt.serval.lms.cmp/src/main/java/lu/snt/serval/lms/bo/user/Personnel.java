package lu.snt.serval.lms.bo.user;

public class Personnel implements Role {


    PersonnelAccount personnelAccount;

    public Personnel() {
    }

    public Personnel(PersonnelAccount personnelAccount) {
        this.personnelAccount = personnelAccount;
    }
    

    public PersonnelAccount getPersonnelAccount() {
        return personnelAccount;
    }

    public void setPersonnelAccount(PersonnelAccount personnelAccount) {
        this.personnelAccount = personnelAccount;
    }

    public String getRoleName() {
        return "PERSONNEL";
    }
    
}
