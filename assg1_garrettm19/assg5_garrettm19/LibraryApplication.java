/**
 *
 * @author Mason Garrett
 */
package assg5_garrettm19;

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApplication {
    
    final static String filename = "assg5_BookCatalog.txt";
            
    public static void main(String[] args) {
        BookCatalog bookCatalog = new BookCatalog();
        
        Scanner userInput = new Scanner(System.in);
        int userInt = 9;
        boolean catalogUpdated = false;
        
        bookCatalog.loadData(filename);
        
        do {
            System.out.println("");
            System.out.println("   1.  Display all the books");
            System.out.println("   2.  Search for a book");
            System.out.println("   3.  Add a new book");
            System.out.println("   4.  Update an existing book");
            System.out.println("   5.  Remove a book");
            System.out.println("   6.  Search for books by publisher");
            System.out.println("   7.  Sort all books based on title");
            System.out.println("   8.  Save data");
            System.out.println("   9.  Exit");
            userInt = userInput.nextInt();
            userInput.nextLine();
        
            if (userInt == 1) {
                bookCatalog.displayCatalog();
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
    
            else if (userInt == 2) {
                System.out.println("What is the title of the book you are searching for?");
                String userString = userInput.nextLine();
                bookCatalog.searchForBook(userString);
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
    
            else if (userInt == 3) {
                System.out.println("Enter the book's title:");
                String bookTitle = userInput.nextLine();
                System.out.println("Enter the book's ISBN:");
                String bookISBN = userInput.nextLine();
                System.out.println("Enter the book's author:");
                String bookAuthor = userInput.nextLine();
                System.out.println("Enter the book's publisher:");
                String bookPublisher = userInput.nextLine();
                System.out.println("Enter the book's publishing year:");
                String publishingYear = userInput.nextLine();
               
                bookCatalog.addBook(bookISBN, bookTitle, bookAuthor, bookPublisher, publishingYear);
                catalogUpdated = true;
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
    
            else if (userInt == 4) {
                System.out.println("What is the name of the book you would like to update?");
                String userString = userInput.nextLine();
                int userInt2;
                Book temp = bookCatalog.searchForBook(userString);
                
                do {
                    System.out.println("What would you like to update?");
                    System.out.println("   1.  ISBN");
                    System.out.println("   2.  Author");
                    System.out.println("   3.  Publisher");
                    System.out.println("   4.  Year");
                    System.out.println("   0.  Exit to menu");
                    userInt2 = userInput.nextInt();
                    userInput.nextLine();
                    
                    if (userInt2 == 1) {
                        System.out.println("What would you like to set the ISBN to?");
                        String userString1 = userInput.nextLine(); 
                        bookCatalog.updateBook(userString1, temp.getBookTitle(), temp.getBookAuthor(), temp.getBookPublisher(), temp.getPublishingYear());
                    }
                
                    else if (userInt2 == 2) {
                        System.out.println("Who would you like to change the author to?");
                        String userString2 = userInput.nextLine();
                        bookCatalog.updateBook(temp.getISBN(), temp.getBookTitle(), userString2, temp.getBookPublisher(), temp.getPublishingYear());
                    
                    }
                
                    else if (userInt2 == 3) {
                        System.out.println("Who would you like to change the publisher to?");
                        String userString3 = userInput.nextLine();
                        bookCatalog.updateBook(temp.getISBN(), temp.getBookTitle(), temp.getBookAuthor(), userString3, temp.getPublishingYear());
                    
                    }
                
                    else if (userInt2 == 4) {
                        System.out.println("What would you like to set the publishing year to?");
                        String userString4 = userInput.nextLine();
                        bookCatalog.updateBook(temp.getISBN(), temp.getBookTitle(), temp.getBookAuthor(), temp.getBookPublisher(), userString4);
                    
                    }
                }while(userInt2 != 0);
                catalogUpdated = true;
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
    
            else if (userInt == 5) {
                System.out.println("Enter the title of the book you would like to remove: ");
                String userString = userInput.nextLine();
                bookCatalog.removeBook(userString);
                catalogUpdated = true;
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
    
            else if (userInt == 6) {
                System.out.println("Enter the publisher of the books you would like to see: ");
                String userString = userInput.nextLine();          
                ArrayList<Book> publisherArrayList = new ArrayList<Book>();
                publisherArrayList = bookCatalog.getBooksByPublisher(userString);
                for (int i = 0; i < publisherArrayList.size(); i++) {
                    System.out.println(publisherArrayList.get(i));
                }
                catalogUpdated = true;
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
    
            else if (userInt == 7) {
                bookCatalog.Sort();
                System.out.println("Successfully sorted!");
                bookCatalog.displayCatalog();
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
    
            else if (userInt == 8) {
                bookCatalog.Save();
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
        }while(userInt != 9);
        
        if (catalogUpdated = true) {
            bookCatalog.Save();
        }
        System.out.println("");
        System.out.println("Exiting...");
        System.exit(0);      
    }
}
