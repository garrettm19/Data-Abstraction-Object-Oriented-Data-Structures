/**
 *
 * @author Mason Garrett
 */
package assg8_garrettm19;

public class Customer extends KeyedItem<String> {
    
    private String name;
    private String phoneNumber;
    
    /*
     * Parameterized constructor for customer's ID, name, and phone number. 
     * 
     * @param ID A String for the customer's ID.
     * @param name A String for the name of the customer.
     * @param phoneNumber A string for the phone number of the customer.
     */
    public Customer(String ID, String name, String phoneNumber) {
        
        super(ID);
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    
    /* Converts all of the variables into one string.
     * 
     * @return Returns the ID, name, and phone number in one string. 
     */
    public String toString() {
        return getKey() + "\t" + name + "\t" + phoneNumber;
    }
    
    /*
     * Returns the name variable.
     * 
     * @return name A variable for the name of the customer.
     */
    public String getName() {
        return name;
    }
    
    /*
     * Returns the phone number variable.
     * 
     * @return phoneNumber A variable for the number of the customer.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    /*
     * Sets the name of the customer.
     *
     * @param name A variable for the name of the customer.
     */
    public void setName(String name) {
        this.name = name;
    }    
    
    /*
     * Sets the phone number variable.
     *
     * @param phoneNumber A variable for the number of the customer.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
