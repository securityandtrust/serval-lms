package lu.snt.serval.lms.framework.user;


public class Librarian extends Personnel  {
    public Librarian(PersonnelAccount personnelAccount) {
        super(personnelAccount);
    }

    public Librarian() {

    }

    public String getRoleName() {
        return "LIBRARIAN";
    }

}
