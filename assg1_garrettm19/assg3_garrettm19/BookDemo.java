/*
 * @author Mason Garrett
 */
package assg3_garrettm19;

import java.io.*;
import java.util.Scanner;

public class BookDemo {
    
    /*
     * Variables to initialize an array with 100 books in it and keep the total number of books.
     */
    static Book catalog[] = new Book[100];
    static int total = 0;
   
    public static void main(String[] args) {
        String filename = "catalog.txt"; // Input file from TextfileInputDemo.java
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
            line = inputStream.nextLine();
            String input[] = line.split("\\s+"); // "\\s+" Skips over any white space at all, prevents errors with catalog.txt file. 
            catalog[total++] = new Book(Integer.parseInt(input[0]),input[1],input[2],input[3],input[4].charAt(0)); // Stores values from file into Books and increments total.     
            System.out.println(line);
        }
      
        inputStream.close();
        
        int bookId;
        inputStream = new Scanner(System.in); // Creates an object of inputStream
            while(true) {
                System.out.println("Enter book ID: ");
                bookId = inputStream.nextInt();
                if(bookId == 0) { // Closes the library if 0 is entered.
                    System.out.println("Closing database...");
                    System.exit(0);
                }
        
                try {
                    int foundLocation = Book.bookSearch(catalog, total, bookId); // Creates an integer for the location of the user requested ID and searches the libary for it.
                    System.out.println(catalog[foundLocation]); // Prints all the information of the book from the ID the user requested.
                }
        
                catch (BookNotFoundException e) { // Catches the error message bookSearch.
                    System.out.println(e.getErrorMessage()); // Prints accurate error message.
                }
            }  
    }
}
