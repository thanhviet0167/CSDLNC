package api.web.rest.errors;

public class InvalidPasswordException extends Exception  {

    private static final long serialVersionUID = 1L;

    public InvalidPasswordException() {
        super("Incorrect password");
    }
}
