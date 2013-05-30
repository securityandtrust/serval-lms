package lu.snt.serval.lms.dao;


public class DAOException extends Throwable {

    String message;

    public String getMessage() {
        return message;
    }

    public DAOException(String s) {
        message = s;
    }
}
