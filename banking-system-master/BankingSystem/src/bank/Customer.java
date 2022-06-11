package bank;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Customer   {
//OVERVIEW: Customer objects have a name, password, balance and a level,
// the Customer class is mutable because of the balance and level parameters.
//A Customer can withdraw and deposit money, changing the balance, making this
//class mutable.
//Abstraction Function: AF(c) = a Customer object such that
//this.name = Name;
//this.password = Password;
//this.checkBalance = CheqBalance
//Rep Invariant: such that
//c.name != null
//c.password != null
//c.checkbalance > 0

    protected int checkBalance;
    private String name;
    private String password;
    private static Level mylevel=new Gold();
    //private Level mylevel;
    static BufferedWriter writer = null;

    public Customer(String Name, String Password, int CheqBalance) {
    //REQUIRES: 
    //EFFECTS: Assigns a Customer with a name, password and balance 
    //MODIFIES: name, password, checkBalance
        this.name = Name;
        this.password = Password;
        this.checkBalance = CheqBalance;

    }

    public String getName() {
    //EFFECTS: Returns the name of a Customer
            return Customer.this.name;
    }

    public String getPassword() {
    //EFFECTS: Returns the password of a Customer
            return Customer.this.password;
    }

    public int getCheckBalance() throws IllegalArgumentException{
    //EFECTS: Returns the checkBalance of a Customer
        System.out.println("in function getcheckbalance");
       /* if (checkBalance<=0)
        {
            throw new IllegalArgumentException("number must be between 0 and 100");
        }
*/
        return Customer.this.checkBalance;
    }

    public void cheqDeposit(int Amount) {
        //EFFECTS: Adds input to the checkBalance of Customer.
        //MODIFIES: checkBalance of Customer.
if (Amount>0)
            Customer.this.checkBalance += Amount;

                                        }

    public boolean cheqWithdraw(int Amount) {
    //EFFECTS: Withdraws specified amount from Customer's checkBalance. Will return
    //         return true if the Amount input is less than the checkBalance of
    //         the customer or else returns false.
    //MODIFIES: checkBalance of Customer
        int temp = Customer.this.checkBalance - Amount;
        if (positiveCheck(temp)) {
            Customer.this.checkBalance = temp;
            return true;
        } else {
            return false;
        }        
    }
        
    public boolean positiveCheck(int money) {       //problem
    // EFFECTS: Checks whether the input is a positive integer. Will return true
    //          if the input is greater than 0 or else returns false.
        if (money >= 0) {
            return true;
        }
        return false;
    }
    
    public void setTheLevel(Level level) {
    // EFFECTS: Sets the level of the customer.
    	mylevel.setTheLevel(this);
        //mylevel=level;
    }
    
    public boolean onlinePurchase(int Amount, Customer currUser) {
    // REQUIRES: needs Amount to be greater than 50.
    // EFFECTS: Will deduct Amount from Customer checkBalance plus a fee based
    //          on the Customer's level. Will return true if the Amount plus
    //          the fee is greater than the checkBalance or else returns false.
    // MODIFIES: checkBalance of Customer
    	currUser.setTheLevel(mylevel);
    	Level temp = Customer.getLevel();
    	int temp1 = 0;
    	int temp2 = Customer.this.checkBalance;
    	if (Amount >= 50) {
    		
	    	if ((temp.toString()).contains("Platinum")) {
	    		temp1 = Amount;
	    	}
	    	if ((temp.toString()).contains("Gold")) {
	    		temp1 = Amount + 10;
	    	}
	    	if ((temp.toString()).contains("Silver")) {
	    		temp1 = Amount + 20;
	    	}
	    	
	    	int temp3 = temp2 - temp1;
	        if (positiveCheck(temp3)) {
	            Customer.this.checkBalance -= temp1;
                    return true;
	        }	    	
	    }
        return false;
    }
    
    public void setLevel(Level level) {
    // EFFECTS: sets the input to the level of the Customer.
    // MODIFIES: level of the Customer.
    	mylevel = level;
    }
    
    public static Level getLevel()
    //public  Level getLevel()
    {
    // EFFECTS: returns the level of the Customer.
    	return mylevel;
    }
    
    public void updateBalance(String Name1, String Password1, int newBalance) {
    // REQUIRES: needs the name and password to not be null.
    // EFFECTS: changes the checkBalance of the Customer with the username and
    //          password provided.
    // MODIFIES: checkBalance of Customer.
        String tmp1 = Name1;
        String tmp2 = Password1;
        int num = newBalance;
        String tmp3 = Integer.toString(num);
        
        File file = new File(""+Name1+".txt");
        file.delete();
        
        if ((tmp1 != null) && (tmp2 != null)) {
            try {
            	writer = new BufferedWriter(new OutputStreamWriter(
            			new FileOutputStream("" +tmp1+".txt"), "utf-8"));
            	writer.write(tmp1);
            	writer.newLine();
            	writer.write(tmp2);
            	writer.newLine();
            	writer.write(tmp3);
            } catch(IOException ex) {
            	System.out.println("File" +tmp1+".txt not created");
            } finally {
            	try {writer.close();} catch(Exception ex) {
            		System.out.println("File not closed properly.");
            	}
            }
        }
    }

    public Level getMylevel() {
        return mylevel ;
    }
}