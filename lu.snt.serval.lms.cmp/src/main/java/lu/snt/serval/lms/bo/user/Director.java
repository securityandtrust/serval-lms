package lu.snt.serval.lms.bo.user;

public class Director extends Personnel  {
    
    public Director(PersonnelAccount personnelAccount) {
        super(personnelAccount);
    }

    public Director()   {}

    public String getRoleName() {
        return "DIRECTOR";
    }
}
