package lu.snt.serval.lms.framework.user;

import lu.snt.serval.lms.framework.interfaces.Role;

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
