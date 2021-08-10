package api.web.rest.errors;

public class UsernameAlreadyUsedException extends Exception {
    private static final long serialVersionUID = 1L;

    public UsernameAlreadyUsedException() {
        super("Username is already in use!");
    }
}
