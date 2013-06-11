package lu.snt.serval.lms.framework.user;


public class Student extends Borrower {
    public Student(BorrowerAccount borrowerAccount) {
        super(borrowerAccount);
    }


    public Student() {
    }

    public String getRoleName() {
        return "STUDENT";
    }
}
