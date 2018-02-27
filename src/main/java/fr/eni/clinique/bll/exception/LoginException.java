package fr.eni.clinique.bll.exception;

public class LoginException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 4536038063996540275L;

    /**
     * @param message
     * @param cause
     */
    public LoginException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * @param message
     */
    public LoginException(String message) {
        super(message);
    }

}
