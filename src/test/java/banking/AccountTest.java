package banking;

import org.junit.Test;

import static org.junit.Assert.*;

public class AccountTest {
    private double balance;
    @Test
    public void Account() {
        this.balance = 0;
    }

    @Test
    public void deposit(double amount) {
        if (amount<0){
            System.out.println("Invalid amount");
        }
            else
            {
               balance = balance+amount;
            }
        }
    

    @Test
    public void withdraw(double withdrawAmount) {
        if (balance > 0){
            if (balance < withdrawAmount)
                System.out.println("Insufficient funds");
        }
        else 
        {
             balance = balance - withdrawAmount;
             System.out.println("Withdrawal successful");   
        }
    }

    @Test
    public void transfer() {
    }

    @Test
    public void getTransactions() {
    }

    @Test
    public void getTransaction() {
    }
}