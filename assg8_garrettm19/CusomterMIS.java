/**
 *
 * @author Mason Garrett
 */
package assg8_garrettm19;

import java.util.Scanner;

public class CusomterMIS {
    
    final static String filename = "assg8_CustomerRoster.txt";
    
    public static void main(String[] args) throws TreeException {
        
        CustomerRoster roster = new CustomerRoster();
        Scanner userInput = new Scanner(System.in);
        int input = 6;
        
        //Loads File
        roster.loadData(filename);
         
        do {
            System.out.println("");
            System.out.println("   1.  Display the customer roster");
            System.out.println("   2.  Add a customer to the roster");
            System.out.println("   3.  Delete a customer from the roster");
            System.out.println("   4.  Search for a customer");
            System.out.println("   5.  Update a customer's information");
            System.out.println("   6.  Save and Exit");
            System.out.println("");
            input = userInput.nextInt();
            userInput.nextLine();
            
            //Displays Roster
            if (input == 1) {
                roster.displayRoster();
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
            
            //Adds Customer
            else if (input == 2) {
                System.out.println("Enter the ID of the customer you would like to add:");
                String newID = userInput.next();
                userInput.nextLine();
                
                System.out.println("Enter the name of the customer you would like to add:");
                String newName = userInput.nextLine();
                
                System.out.println("Enter the number (with dashes) of the customer you would like to add:");
                String newNumber = userInput.next();
                userInput.nextLine();
                
                roster.addCustomer(newID, newName, newNumber);
                System.out.println("");
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
            
            //Deletes Customer
            else if (input == 3) {
                System.out.println("What is the ID of the customer you would like to delete?");
                String userID = userInput.next();
                userInput.nextLine();
                
                roster.deleteCustomer(userID);
                System.out.println("");
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
            
            //Searches for Customer
            else if (input == 4) {
                System.out.println("Enter the ID of the customer you are searching for: ");
                String searchID = userInput.next();
                
                System.out.println("");
                roster.searchCustomer(searchID);
                System.out.println("");
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
            
            //Updates Customer
            else if (input == 5) {
                System.out.println("What is the ID of the customer you would like to update? ");
                String changeID = userInput.next();
                userInput.nextLine();
                
                System.out.println("What would you like to change the customer's name to? ");
                String newName = userInput.nextLine();
                
                System.out.println("What is the customer's phone number? ");
                String newNumber = userInput.next();
                userInput.nextLine();

                roster.updateCustomer(changeID, newName, newNumber);
                System.out.println("");
                System.out.println("Press Enter To Continue:");
                userInput.nextLine();
            }
            
        }while(input != 6);
        
        //Saves Roster
        roster.saveRoster(filename);
        
        //Exits
        System.out.println("");
        System.out.println("Exiting...");
        System.exit(0);      
    }
}
