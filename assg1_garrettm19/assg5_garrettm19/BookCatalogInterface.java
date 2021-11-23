/**
 *
 * @author Mason Garrett
 */
package assg5_garrettm19;

import java.util.ArrayList;

public interface BookCatalogInterface {
    /*
     * Loads the book catalog that the user enters.
     *
     * @param filename String for the filename that the user wants to be read.
     */
    public void loadData(String filename);
    
    /*
     * Displays the entire book catalog.
     *
     */
    public void displayCatalog();
    
    /*
     * Checks if the current object is equal with the paramter and returns the results.
     *
     * @param bookTitle String for the title of the book.
     * @return requestedBook Returns the book that the user requested or null if the entry was not found.
     */
    public Book searchForBook(String bookTitle);
    
    /*
     * Adds a book to the catalog, requires input of all five of the parameters.
     *
     * @param ISBN String for the internation book number.
     * @param bookTitle String for the title of the book.
     * @param bookAuthor String for the author of the book.
     * @param bookPublisher String for the publisher of the book.
     * @param publishingYear String for the year that the book was published.
     * @return true or false Returns value based on if the book was updated successfully or not.
     */
    public boolean addBook(String ISBN, String bookTitle, String bookAuthor, String bookPublisher, String publishingYear);
    
    /*
     * Updates the author, ISBN, publisher, and/or publishing year of one of the books.
     *
     * @param ISBN String for the internation book number.
     * @param bookTitle String for the title of the book.
     * @param bookAuthor String for the author of the book.
     * @param bookPublisher String for the publisher of the book.
     * @param publishingYear String for the year that the book was published.
     * @return true or false Returns value based on if the book was updated successfully or not.
     */
    public boolean updateBook(String ISBN, String bookTitle, String bookAuthor, String bookPublisher, String publishingYear);
    
    /*
     * Removes the book that the user requests from the catalog.
     *
     * @param bookTitle String for the title of the book.
     * @return true or false Returns value based on if the book was removed successfully or not.
     */
    public boolean removeBook(String bookTitle);
    
    /*
     * Checks for all of the books the user would like to see based on the publisher.
     *
     * @param bookPublisher The publisher of the book the user is requesting.
     * @return arrayRequestedBooks Array of all the books the user selected based on the publisher.
     */
    public ArrayList<Book> getBooksByPublisher(String bookPublisher);
    
    /*
     * Sorts the current object's books alphabetically.
     *
     */
    public void Sort();
    
    /*
     * Saves any new information to the file the user originally inputed.
     *
     */
    public void Save();
}
