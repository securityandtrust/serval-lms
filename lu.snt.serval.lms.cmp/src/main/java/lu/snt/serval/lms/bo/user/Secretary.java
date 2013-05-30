package lu.snt.serval.lms.bo.user;

public class Secretary extends Personnel  {
    public Secretary(PersonnelAccount personnelAccount) {
        super(personnelAccount);
    }

    public Secretary() {

    }

    public String getRoleName() {
        return "SECRETARY";
    }

}
