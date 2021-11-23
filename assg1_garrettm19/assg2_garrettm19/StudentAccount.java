/**
 *
 * @author Mason Garrett
 */

package assg2_garrettm19;

public class StudentAccount implements Comparable<StudentAccount> {

    /**
     * Variables to identify the account number and balance.
     */
    private int accNo;
    private double balance;
    private static int counter;

    /**
     * Default constructor which sets the balance to zero and the account number to the counter. 
     */
    public StudentAccount() {
        this.balance = 0;
        ++counter;
        accNo = counter;
    }

    /**
     * Parameterized constructor which sets the balance to the inputed value and sets the account number to the counter.
     *
     * @param balance A variable of the current balance.
     */
    public StudentAccount(double balance) {
        this.balance = balance;
        ++counter;
        accNo = counter;
    }

    /*
     * Returns the account number.
     * 
     * @return accNo A variable of the current account number.
     */
    public int getAccNo() {
        return accNo;
    }

    /*
     * Returns the current balance.
     *
     * @return balance A variable of the current balance.
     */
    public double getBalance() {
        return balance;
    }

    /*
     * Returns the number of accounts created.
     *
     * @return counter A variable of the current number of accounts created.
     */
    public static int getCounter() {
        return counter;
    }
    
    /*
     * Sets the balance variable.
     *
     * @param balance The balance of the current account.
     */
    public void setBalance(double balance) {
        this.balance = balance;
    }

    /*
     * Adds the user inputed number to the current balance and stores it. If the inputed number is equal to or less than 0 then it prints out a message for the user.
     *
     * @param inputedNumber A variable for the value the user would like to deposit or charge from their account.
     */
    public void deposit(double inputedNumber) {
        if (inputedNumber > 0) {
            this.balance += inputedNumber;
            System.out.println("The account balance has been updated succesfully.");
        }
        else {
            System.out.println("Please enter a positive number to deposit."); 
        }
    }

     /*
     * Charges the account based on the user input and stores it. If the inputed number is equal to or less than 0 then it prints out a message for the user.
     *
     * @param inputedNumber A variable for the value the user would like to deposit or charge from their account.
     */
    public void charge(double inputedNumber) {
        if (inputedNumber > 0) {
            this.balance -= inputedNumber;
            System.out.println("The account balance has been updated succesfully.");
        }
        else {
            System.out.println("Please enter a positive number to charge the account."); 
        }
    }

    /*
     * Transfer into the account the inputed number if it is greater than 0. If the inputed number is equal to or less than 0 then it prints out a message for the user.
     *
     * @param StudentAccount n A variable for the account the user wants to transfer from.
     * @param inputedNumber A variable for the value the user would like to deposit or charge from their account.
     */
    public void transferIn(StudentAccount n, double inputedNumber) {
        if (inputedNumber > 0) {
            if (inputedNumber > n.balance) {
                System.out.println("Insuffient funds to transfer, please enter a smaller number.");
            }
            else {
                this.balance += inputedNumber;
                n.balance -= inputedNumber;
                System.out.println("Both account balances have been updated succesfully.");
            }
        }
        else {
            System.out.println("Please enter a positive number to transfer into the account."); 
        }
    }

    /*
     * Transfer out of the account the inputed number if it is greater than 0 and the current account has a high enough balance. If the inputed number is equal to or less than 0 then it prints out a message for the user.
     *
     * @param StudentAccount n A variable for the account the user wants to transfer from.
     * @param inputedNumber A variable for the value the user would like to deposit or charge from their account.
     */
    public void transferOut(StudentAccount n, double inputedNumber) {
        if (inputedNumber > 0) {
            if (inputedNumber > this.balance) {
                System.out.println("Insufficient funds to transfer, please enter a smaller number.");
            }
            else {
                this.balance -= inputedNumber;
                n.balance += inputedNumber;
                System.out.println("Both account balances have been updated succesfully.");
            }
        }
        else {
            System.out.println("Please enter a positive number to transfer out of the account."); 
        }
    }

    /*
     * Prints the current account number and balance for the user.
     */
    public void printInfo() {
        System.out.println("Account number: " + this.accNo);
        System.out.println("Current balance: " + this.balance);
    }

    /*
     * Converts the current object to a string and returns the account information.
     *
     * @return thisString Returns account information in string form.
     */
    @Override
    public String toString() {
        String thisString = "Account Number: " + this.accNo + "\nCurrent balance: " + this.balance;
    return thisString;
    }
    
    /*
     * Compares the current object to a parameter and returns a value based on if it has a larger, smaller or equal balance.
     *
     * @param StudentAccount n Inputed object used to compare to current object.
     * @return 0 Default return statement.
     */
    @Override
    public int compareTo(StudentAccount n) {
        if (this.balance == n.getBalance()) {
            return 0;
        } else if (this.balance > n.getBalance()) {
            return 1;
        } else if (this.balance < n.getBalance()) {
            return -1;
        } 
        return 0;
    }
};
