/*
 * @author Mason Garrett
 */
package assg4_garrettm19;

import java.util.Scanner;

public class RecursionTest {
       
    
    public static String deleteFirst(String str, char ch) {
        if (str.length() == 0) { // Base Case for empty/null string
            return str;
        }
        if (str.charAt(0) == ch) { // Returns the string from the second letter (only if the first letter matches ch).
            return str.substring(1);
        }
        else { // If the first character isn't a match it skips it then uses recursion again to apply the method.
            str = str.charAt(0) + deleteFirst(str.substring(1), ch);
            return str;
        }
    }
        
    public static String deleteAll(String str, char ch) {
        if (str.length() == 0) { // Base Case for empty/null string
            return str;
        }
        if (str.charAt(0) == ch) { // Returns the string to the method from the next position and removes the first one.
            return deleteAll(str.substring(1), ch);
        }
        else { // If the first character isn't a match it skips it then uses recursion again to apply the method.
            str = str.charAt(0) + deleteAll(str.substring(1), ch);
            return str;
        }
    }
    
    public static void main(String[] args) {
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter Any Number To Start The Program.");
        int input = userInput.nextInt();
        String inputString;
        char inputChar;
        
        do {
            System.out.println("");
            System.out.println("1. Test deleteFirst method");
            System.out.println("2. Test deleteAll method");
            System.out.println("3. Exit");
            System.out.println("");
            input = userInput.nextInt();
            
            switch (input) {
                case 1:
                    System.out.println("");
                    System.out.println("Enter the input string: ");
                    inputString = userInput.next();
                    System.out.println("");
                    System.out.println("Enter the input character: ");
                    inputChar = userInput.next().charAt(0);
                    System.out.println("");
                    System.out.println("The first occurence of " + inputChar + " has been deleted from the string " + inputString + ":");
                    System.out.println(deleteFirst(inputString, inputChar));
                    break;
                case 2:
                    System.out.println("");
                    System.out.println("Enter the input string: ");
                    inputString = userInput.next();
                    System.out.println("");
                    System.out.println("Enter the input character: ");
                    inputChar = userInput.next().charAt(0);
                    System.out.println("");
                    System.out.println("All occurences of " + inputChar + " have been deleted from the string " + inputString + ":");
                    System.out.println(deleteAll(inputString, inputChar));
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Invalid entry, please try again.");
                    break;
            }
        } while(input != 3);
        System.out.println("");
        System.out.println("Exiting...");
        System.exit(0);    
    }
} 

