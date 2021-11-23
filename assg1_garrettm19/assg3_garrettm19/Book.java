/*
 * @author Mason Garrett
 */
package assg3_garrettm19;

public class Book {
    
    /*
     * Variables to identify the book ID, title, ISBN, author's last name, and category. 
     */
    private int bookId;
    private String bookTitle;
    private String ISBN;
    private String authorLastName;
    private char category;
   
    /*
     * Parameterized constructor which sets each of the variables to their values from the catalog file.
     * 
     * @param bookId A variable for the identification number of the book.
     * @param bookTitle A variable for the title of the book.
     * @param ISBN A variable for the international standard book number.
     * @param authorLastName A variable for the author of the books last name.
     * @param category A variable for the type of book it is.
     */
    public Book(int bookId, String bookTitle, String ISBN, String authorLastName, char category) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.ISBN = ISBN;
        this.authorLastName = authorLastName;
        this.category = category;
    }
    
    /*
     * Returns the bookId variable.
     * 
     * @return bookId A variable for the identification number of the book.
     */
    public int getBookId() {
        return bookId;
    }
    
    /*
     * Sets the bookId variable.
     *
     * @param bookId A variable for the identification number of the book.
     */
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    
    /*
     * Returns the bookTitle variable.
     * 
     * @return bookTitle A variable for the title of the book.
     */
    public String getBookTitle() {
        return bookTitle;
    }
    
    /*
     * Sets the bookTitle variable.
     *
     * @param bookTitle A variable for the title of the book.
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }
    
    /*
     * Returns the ISBN variable.
     * 
     * @return ISBN A variable for the international standard book number.
     */
    public String getISBN() {
        return ISBN;
    }
    
    /*
     * Sets the ISBN variable.
     *
     * @param ISBN A variable for the international standard book number.
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }    
    
    /*
     * Returns the authorLastName variable.
     * 
     * @return authorLastName A variable for the author of the books last name.
     */
    public String getAuthorLastName() {
        return authorLastName;
    }
    
    /*
     * Sets the authorLastName variable.
     *
     * @param authorLastName A variable for the author of the books last name.
     */
    public void setAuthorLastName(String authorLastName) {
        this.authorLastName = authorLastName;    
    }
    
    /*
     * Returns the category variable.
     * 
     * @return category A variable for the type of book it is.
     */
    public char getCategory() {
        return category;    
    }
    
    /*
     * Sets the category variable.
     *
     * @param category A variable for the type of book it is.
     */
    public void setCategory(char category) {
        this.category = category;
    } 
    
    /*
     * Converts the current object to a string and returns all the correct book information.
     *
     * @return thisString Returns books information in string form.
     */
    @Override
    public String toString() {
        String thisString = "Book ID: " + this.bookId + ", Title: " + this.bookTitle + ", ISBN: " + this.ISBN + ", Author's Last Name: " + this.authorLastName + ", Category: ";
        if(category == 'F') {
            thisString += "Fiction";
        }
        if(category == 'N') {
            thisString += "Non-Fiction";
        }
    return thisString;
    }
    
    /*
     * Searches the library for the requested book ID and returns the location of it, also throws error message to main if the book is not found.
     *
     * @param catalog[] An array of all of the books inputed by the user.
     * @param total A variable for the total number of books.
     * @param bookId A variable for the identification number of the book.
     * @return i A variable for the location of the book ID the user requested.
     */
    public static int bookSearch(Book catalog[], int total, int bookId) throws BookNotFoundException {
        for(int i=0; i < total; i++) {
            if(catalog[i].getBookId() == bookId) {
                return i;
            }
        }
        throw new BookNotFoundException("No such book with ID " + bookId + ".");
    }
}
