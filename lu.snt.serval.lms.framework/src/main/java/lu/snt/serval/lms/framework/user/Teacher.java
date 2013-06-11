package lu.snt.serval.lms.framework.user;


public class Teacher extends Borrower {
    public Teacher(BorrowerAccount borrowerAccount) {
        super(borrowerAccount);
    }


    public Teacher() {
    }

    public String getRoleName() {
        return "LECTURER";
    }
}
