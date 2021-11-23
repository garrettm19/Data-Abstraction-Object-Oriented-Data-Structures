/**
 *
 * @author Mason Garrett
 */
package assg8_garrettm19;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CustomerRoster<T extends KeyedItem<KT>, KT extends Comparable<? super KT>> extends BinaryTreeBasis<T> {
    
    BinarySearchTree<Customer, String> currentRoster = new BinarySearchTree<>();
    
    /*
     * Default constructor for customer roster.
     */    
    public CustomerRoster() {
    }
    
    /*
     * Parameterized constructor for customer roster.
     *
     * @param rootItem Variable with type of T
     */
    public CustomerRoster(T rootItem) {
        super(rootItem);
    }

    /*
     * Loads the customer roster from the file.
     *
     * @param filename String for the filename that the user wants to be read.
     */
    public void loadData(String filename) {
        Scanner inputStream = null;
        
        try {
            inputStream = new Scanner(new File(filename));
        }
        
        catch (FileNotFoundException e) {
            System.out.println("Error opening the file " + filename);
            System.exit(1);
        }
        
        while (inputStream.hasNextLine()) {
            Customer holder = new Customer(inputStream.next(),(inputStream.next() + " " + inputStream.next()) ,inputStream.nextLine().trim());    
            currentRoster.insert(holder);
        }
        inputStream.close();    
    }    
    
    /*
     * Displays the entire roster.
     */
    public void displayRoster() {
        TreeIterator<Customer> displayTree = new TreeIterator<>(currentRoster);
        displayTree.setInorder();
        
        System.out.println("");
        
        while(displayTree.hasNext() == true) {
            Customer current = (Customer) displayTree.next();
            System.out.println(current.toString());
        }
        
        System.out.println("");
    }
    
    /*
     * Allows the user to add a customer to the roster.
     * 
     * @param newID String for the new ID of the customer.
     * @param newName String for the new name of the customer.
     * @param newNumber String for the new number of the customer.
     */
    public void addCustomer(String newID, String newName, String newNumber) {
        if (currentRoster.retrieve(newID) != null) {
            System.out.println("Customer with ID: " + newID + " already exists.");
            return;
        }
        Customer newCustomer = new Customer(newID, newName, newNumber);
        
        currentRoster.insert(newCustomer);
        
        System.out.println("Customer successfully added to the roster.");
    }

    /*
     * Deletes the customer that the user requests.
     *
     * @param userID String for the ID that the user wants to delete.
     */
    public void deleteCustomer(String userID) throws TreeException {
        if (currentRoster.retrieve(userID) == null) {
            System.out.println("Customer with ID: " + userID + " was not found.");
            return;
        }
        Customer deletedCustomer = currentRoster.retrieve(userID);
        
        currentRoster.delete(deletedCustomer);
        System.out.println("Successfully deleted customer with ID: " + userID + ".");
    }
    
    /*
     * Searches for a customer and returns it's information.
     *
     * @param userID String that holds the ID that the user has searched.
     */
    public void searchCustomer(String userID) {
        if (currentRoster.retrieve(userID) == null) {
            System.out.println("Customer with ID: " + userID + " was not found.");
            return;
        }
        Customer searchedCustomer = currentRoster.retrieve(userID);
        System.out.println(searchedCustomer.toString());
    }

    /* 
     * Updates the customer the user requested. 
     *
     * @param userID String that holds the ID that the user wants to update.
     * @param newName String for the new name of the customer.
     * @param newNumber String for the new phone number of the customer.
     */
    public void updateCustomer(String userID, String newName, String newNumber) {
        if (currentRoster.retrieve(userID) == null) {
            System.out.println("Customer with ID: " + userID + " was not found.");
            return;
        }
        Customer updatedCustomer = currentRoster.retrieve(userID);
                
        updatedCustomer.setName(newName);
        updatedCustomer.setPhoneNumber(newNumber);
        
        System.out.println("The customer has been updated successfully.");
    }
 
    /*
     * Saves any changes that were made to the file and returns statements saying if it was successfull or not.
     *
     * @param filename String for the filename that the user wants to be read.
     */
    public void saveRoster(String filename) {
        TreeIterator<Customer> displayTree = new TreeIterator<>(currentRoster);
        displayTree.setInorder();
        PrintWriter saveFile = null;
        
        try {
            saveFile = new PrintWriter(filename);
        } 
        
        catch (IOException e) {
            System.out.println("Error saving file...");
            System.exit(1);
        } 
        
        while (displayTree.hasNext() == true){
            Customer current = (Customer) displayTree.next();
            
            String saveID = current.getKey();
            String saveName = current.getName();
            String saveNumber = current.getPhoneNumber();
            
            saveFile.println(saveID + "\t" + saveName + "\t" + saveNumber);   
        }
        
        saveFile.close();
        System.out.println("");
        System.out.println("File saved successfully");
    }
    
    /*
     * Required method by netbeans to allow class to work
     *
     * @param newItem Place holder for setting root item.
     */
    @Override
    public void setRootItem(T newItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}