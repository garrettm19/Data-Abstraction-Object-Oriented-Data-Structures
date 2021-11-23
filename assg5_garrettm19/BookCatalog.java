/**
 *
 * @author Mason Garrett
 */
package assg5_garrettm19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BookCatalog implements BookCatalogInterface {
    
    private ArrayList<Book>catalog = new ArrayList<Book>();
    private String filename;
    
    /*
     * Loads the book catalog that the user enters.
     *
     * @param filename String for the filename that the user wants to be read.
     */
    @Override
    public void loadData(String filename) {
        Scanner inputStream = null;
        String line;
        
        try {
            inputStream = new Scanner(new File(filename));
        }
        
        catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + filename);
            System.exit(1);
        }
        
        while (inputStream.hasNextLine()) {

            Book holderBook = new Book(inputStream.nextLine(),inputStream.nextLine(),inputStream.nextLine(),inputStream.nextLine(),inputStream.nextLine());    
            catalog.add(holderBook);
        
            if (inputStream.hasNextLine() == false) {
                break;
            }
            else {
                inputStream.nextLine();
            }
        }
        
        catalog.sort(null);
        inputStream.close();    
    }
    
    /*
     * Displays the entire book catalog.
     *
     */
    @Override
    public void displayCatalog() {
        for (int i = 0; i < catalog.size(); i++) {
            Book requestedBook = catalog.get(i);
            System.out.println(requestedBook.toString());
        }
    }
    
    /*
     * Checks if the current object is equal with the paramter and returns the results.
     *
     * @param bookTitle String for the title of the book.
     * @return requestedBook Returns the book that the user requested or null if the entry was not found.
     */
    @Override
    public Book searchForBook(String bookTitle) {
        for (int i = 0; i < catalog.size(); i++) {
            Book requestedBook = catalog.get(i);
            if (bookTitle.equalsIgnoreCase(requestedBook.getBookTitle())) {
                System.out.println("Book found!");
                return requestedBook;
            }
        }
        System.out.println("Book not found, please exit to menu");
        return null;
    }
    
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
    @Override
    public boolean addBook(String ISBN, String bookTitle, String bookAuthor, String bookPublisher, String publishingYear) {
        for (int i = 0; i < catalog.size(); i++) {
            Book requestedBook = catalog.get(i);
            if (!bookTitle.equalsIgnoreCase(requestedBook.getBookTitle())) {
                Book newBook = new Book(ISBN,bookTitle,bookAuthor,bookPublisher,publishingYear);
                catalog.add(newBook);
                System.out.println("Book added successfully...");
                return true;
            }
        }
        return false;
    }
    
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
    @Override
    public boolean updateBook(String ISBN, String bookTitle, String bookAuthor, String bookPublisher, String publishingYear) {
        for (int i = 0; i < catalog.size(); i++) {
            Book requestedBook = catalog.get(i);
            if (bookTitle.equalsIgnoreCase(requestedBook.getBookTitle())) {
                requestedBook.setISBN(ISBN);
                requestedBook.setBookAuthor(bookAuthor);
                requestedBook.setBookPublisher(bookPublisher);
                requestedBook.setPublishingYear(publishingYear);
                System.out.println("Book updated successfully...");
                return true;
            }
        }
        return false;
    }
    
    /*
     * Removes the book that the user requests from the catalog.
     *
     * @param bookTitle String for the title of the book.
     * @return true or false Returns value based on if the book was removed successfully or not.
     */
    @Override
    public boolean removeBook(String bookTitle) {
        for (int i = 0; i < catalog.size(); i++) {
            Book requestedBook = catalog.get(i);
            if (bookTitle.equalsIgnoreCase(requestedBook.getBookTitle())) {
                catalog.remove(i);
                System.out.println("Book removed successfully...");
                return true;
            }
        }
        return false;
    }
    
    /*
     * Checks for all of the books the user would like to see based on the publisher.
     *
     * @param bookPublisher The publisher of the book the user is requesting.
     * @return arrayRequestedBooks Array of all the books the user selected based on the publisher.
     */
    @Override
    public ArrayList<Book> getBooksByPublisher(String bookPublisher) {
        ArrayList<Book> arrayRequestedBooks = new ArrayList<Book>();
        for (int i = 0; i < catalog.size(); i++) {
            if (catalog.get(i).getBookPublisher().equals(bookPublisher)) {
                arrayRequestedBooks.add(catalog.get(i));
            }
        }
        return arrayRequestedBooks;
    }
    
    /*
     * Sorts the current object's books alphabetically.
     *
     */
    @Override
    public void Sort() {
        Collections.sort(catalog, Comparator.comparing(Book::getBookTitle));
    }
    
    /*
     * Saves any new information to the file the user originally inputed.
     *
     */
    @Override
    public void Save() {
        try {
           PrintWriter saveFile = new PrintWriter(this.filename);
           for (Book requestedBook : catalog) {
               saveFile.print(catalog.toString());
               saveFile.println("\n");
               System.out.println("Save Successfull");
        }
        System.out.println("Exiting...");
        saveFile.close();
        } catch (IOException e) {
            System.out.println("Error saving file...");
            System.exit(1);
        }   
    }
}

