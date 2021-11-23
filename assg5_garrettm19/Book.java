/**
 *
 * @author Mason Garrett
 */
package assg5_garrettm19;

public class Book implements Comparable<Book> {
    
    /*
     * Variables to identify the book's ISBN, title, author, publisher, and publishing year.
     */
    private String ISBN;
    private String bookTitle;
    private String bookAuthor;
    private String bookPublisher;
    private String publishingYear;
   
    /*
     * Parameterized constructor which sets each of the variables to their values from the book catalog file.
     * 
     * @param ISBN A variable for the international standard book number.
     * @param bookTitle A variable for the title of the book.
     * @param bookAuthor A variable for the author of the book.
     * @param bookPublisher A variable for the publisher of the book.
     * @param publishingYear A variable for the year the book was published.
     */
    public Book(String ISBN, String bookTitle, String bookAuthor, String bookPublisher, String publishingYear) {
        this.ISBN = ISBN;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.publishingYear = publishingYear;
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
     * Returns the bookTitle variable.
     * 
     * @return bookTitle A variable for the title of the book.
     */
    public String getBookTitle() {
        return bookTitle;
    }
    
    /*
     * Returns the bookAuthor variable.
     * 
     * @return bookAuthor A variable for the author of the book.
     */
    public String getBookAuthor() {
        return bookAuthor;
    }
    
    /*
     * Sets the bookAuthor variable.
     *
     * @param bookAuthor A variable for the author of the book.
     */
    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;    
    }
    
    /*
     * Returns the bookPublisher variable.
     * 
     * @return bookPublisher A variable for the publisher of the book.
     */
    public String getBookPublisher() {
        return bookPublisher;    
    }
    
    /*
     * Sets the bookPublisher variable.
     *
     * @param bookPublisher A variable for the publisher of the book.
     */
    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }
    
    /*
     * Returns the publishingYear variable.
     * 
     * @return publishingYear A variable for the publishing year of the book.
     */
    public String getPublishingYear() {
        return publishingYear;    
    }
    
    /*
     * Sets the publishingYear variable.
     *
     * @param publishingYear A variable for the publishing year of the book.
     */
    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    } 
    
    /*
     * Converts the current object to a string and returns all the correct book information.
     *
     * @return thisString Returns books information in string form.
     */
    @Override
    public String toString() {
        String thisString = this.ISBN + "\n" + this.bookTitle + "\n" + this.bookAuthor + "\n" + this.bookPublisher + "\n" + this.publishingYear + "\n";
    return thisString;
    }
    
    /*
     * Checks if the current object is equal with the paramter and returns the results.
     *
     * @param Object z Object inputed that could or could not be a book.
     * @return true or false Returns value based on comparison of the books titles.
     */
        public boolean equals(Object n) {
        if (n == null) {
            return false;
        }
        if (n instanceof Book) {
            Book that = (Book)n;
            if (that.bookTitle.equals(bookTitle) || !that.bookAuthor.equals(bookAuthor)) {
                return true;
            }
        }
        return false;        
        }
    
    /*
     * Compares the current object to a parameter and returns a value based on if it has a larger, smaller or equal balance.
     *
     * @param book n Inputed object used to compare to current object.
     * @return 0 Both titles are equal.
     * @return 1 The current objects first letter is closer to a then the parameter.
     * @return -1 The current objects first letter is farther from a then the parameter.
     * @return 0 Default return statement.
     */
    @Override
    public int compareTo(Book n) {
        return this.bookTitle.compareTo(n.bookTitle);
    }
}

   
