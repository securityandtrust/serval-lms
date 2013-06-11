package lu.snt.serval.lms.framework.user;

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
