package lu.snt.serval.lms.service.exception;


public class BSException extends Exception {

    String message;

    public BSException(String message)    {

     this.message = message;
    }


    
    public String getMessage() {
        return message;
    }
}
