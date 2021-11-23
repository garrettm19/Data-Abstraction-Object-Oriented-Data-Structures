/**
 *
 * @author Mason Garrett
 */

package assg2_garrettm19;

public class RewardsAccount extends StudentAccount{
    
    /**
     * Variable to record the reward balance
     */
    private double rewards;

    /**
     * Default constructor which sets the rewards variable to zero.
     */
    public RewardsAccount() {
        rewards = 0;
    }

    /**
     * Parameterized constructor which checks the balance of the current account and rewards the user with $5 if their balance is $100 or more.
     *
     * @param balance A variable of the current balance.
     */
    public RewardsAccount(double balance) {
        super(balance);
        if (balance > 0) {
            if (balance >= 100) {
                this.rewards += 5;
            }
        }
        else {
            System.out.println("This account is empty.");
        }
    }

    /*
     * Returns the rewarded balance.
     * 
     * @return rewards A variable for the current rewarded balance.
     */
    public double getRewards(){
        return rewards;
    }
    
    /*
     * Adds the rewarded balance to the current balance of the user if they have $25 or more available.
     * 
     * @return rewards A variable for the current rewarded balance.
     */
    public double redeemRewards(){
        if (this.rewards >= 25) {
            double balance = getBalance(); 
            setBalance(balance + rewards);
            rewards = 0;
        }
         else {
            System.out.println("You have insufficient funds to redeem a reward.");
        }
    return rewards;
    }
    
    /*
     * Converts the current object to a string and returns the account information.
     *
     * @return thisString Returns account information in string form.
     */
    @Override
    public String toString() {
        String thisString = "Account Number: " + getAccNo() + "\nCurrent balance: " + getBalance() + "\nRewards balance: " + this.rewards;
    return thisString;
    }
    
    /*
     * Adds the user inputed number to the current balance and stores it. If the inputed number is 100 or more than 5 gets added to the rewards balance.
     *
     * @param inputedNumber A variable for the value the user would like to deposit or charge from their account.
     */
    @Override
    public void deposit(double inputedNumber) {
        if (inputedNumber > 0) {
            double balance = getBalance();
            setBalance(balance + inputedNumber);
            if (inputedNumber >= 100) {
                rewards += 5;
            }
            System.out.println("The account balance has been updated succesfully.");
        }
        else {
            System.out.println("Please enter a positive number to deposit."); 
        }
    }

     /*
     * Prints the current account number, balance, and rewards balance for the user.
     */
    @Override
    public void printInfo() {
        System.out.println("Account number: " + getAccNo());
        System.out.println("Current balance: " + getBalance());
        System.out.println("Rewards balance: " + rewards);
    }
}
