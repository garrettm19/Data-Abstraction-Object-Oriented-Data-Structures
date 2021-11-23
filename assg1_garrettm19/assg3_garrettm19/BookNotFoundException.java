/*
 * @author Mason Garrett
 */
package assg3_garrettm19;

public class BookNotFoundException extends Exception{
    
    /**
     * Variable to write an error message for the user.
     */
    private String errorMessage;

    /**
     * Default constructor which defines error message with a simple message for the user.
     */
    public BookNotFoundException() {
        this.errorMessage = "Book not found";
    }

    /**
     * Parameterized constructor which uses a custom error message to let the user know there is an error.
     *
     * @param errorMessage A variable to write an error message for the user.
     */
    public BookNotFoundException(String errorMessage) {
        this.errorMessage = errorMessage;
    }
    
    /*
     * Returns the error message for the user.
     *
     * @return errorMessage A variable to write an error message for the user.
     */
    public String getErrorMessage() {
        return errorMessage;
    }   
}
