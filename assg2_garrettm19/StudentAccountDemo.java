/**
 *
 * @author Mason Garrett
 */

package assg2_garrettm19;

import java.util.*;

public class StudentAccountDemo {
    public static void main(String[] args) {
        
        StudentAccount studentOne = new StudentAccount(); // Test default constructor (Student Account)
        StudentAccount studentTwo = new StudentAccount(50); // Test paramterized constructor (Student Account)
    
        System.out.println("Student One's Account(printInfo): "); // Testing printInfo
        studentOne.printInfo();
        System.out.println("");
        
        System.out.println("Student One's Account(toString): "); // Testing toString
        System.out.println(studentOne.toString());
        System.out.println("");
       
        System.out.println("Student Two's Account: ");
        studentTwo.printInfo();
        System.out.println("");
        
        System.out.println("Get methods for Student Two: ");
        System.out.println("Account Number: " + studentTwo.getAccNo()); // Testing getAcc
        System.out.println("Balance: " + studentTwo.getBalance()); // Testing getBalance
        System.out.println("Counter: " + StudentAccount.getCounter()); // Testing getCounter
        System.out.println("");
        
        System.out.println("Setting balance to 10 for Student One: "); // Testing setBalance
        studentOne.setBalance(10);
        studentOne.printInfo();
        System.out.println("");
        
        System.out.println("Depositing 25 to Student One's account: "); // Testing deposit
        studentOne.deposit(25);
        studentOne.printInfo();
        System.out.println("");
        
        System.out.println("Charging 5 from Student One's account: "); // Testing charge
        studentOne.charge(5);
        studentOne.printInfo(); 
        System.out.println("");
        
        System.out.println("Transferring 30 into Student One's account from Student Two's account: "); // Testing transferIn
        studentOne.transferIn(studentTwo, 30); 
        studentOne.printInfo();
        System.out.println("");
        studentTwo.printInfo();
        System.out.println("");
        
        System.out.println("Transferring 20 out from Student One's account to Student Two's account: "); // Testing transferOut
        studentOne.transferOut(studentTwo, 20); 
        studentOne.printInfo();
        studentTwo.printInfo();
        System.out.println("");
        
        System.out.println("Comparing the two accounts: "); // Testing compareTo (Equal case)
        System.out.println("1 if Student One is larger.");
        System.out.println("0 if they are equal.");
        System.out.println("-1 if Student Two is larger.");
        System.out.println("Result: " + studentOne.compareTo(studentTwo));
       
        StudentAccount studentThree = new StudentAccount(41); 
        System.out.println("");
        
        System.out.println("Student Three's Account: "); // Testing compareTo (-1/second number is greater case)
        studentThree.printInfo();
        System.out.println("");
        System.out.println("Comparing Student Two's account to Student Three's account: ");
        System.out.println("Result: " + studentTwo.compareTo(studentThree));
        System.out.println("");
        
        RewardsAccount studentFour = new RewardsAccount(); // Test default constructor (Rewards Account)
        RewardsAccount studentFive = new RewardsAccount(100); // Test parameterized constructor (Rewards Account)
        
        System.out.println("Student Four's Account (First Rewards Account): "); // Testing printInfo (Rewards Account)
        studentFour.printInfo();
        System.out.println("");
        System.out.println("Student Four's Account (toString): "); // Testing toString (Rewards Account)
        System.out.println(studentFour.toString());
        System.out.println("");
        System.out.println("Student Five's Account (Second Rewards Account): "); // Testing parameterized constructor reward for $100 ($5 reward)
        studentFive.printInfo();
        System.out.println("");
        
        System.out.println("Depositing $100 four times to get to $25 total in rewards: ");
        studentFive.deposit(100);
        studentFive.deposit(100);
        studentFive.deposit(100);
        studentFive.deposit(100);
        studentFive.printInfo();
        System.out.println("");
       
        System.out.println("Rewards balance: " + studentFive.getRewards()); // Testing getRewards
        System.out.println("");
        System.out.println("Claiming Rewards now: "); // Testing redeemRewards
        studentFive.redeemRewards();
        studentFive.printInfo();
        System.out.println("");
        
        System.out.println("Claiming Rewards now: "); // Testing redeemRewards (insufficient funds)
        studentFive.redeemRewards();
        studentFive.printInfo();
                
        
        
        
    
    }
}
