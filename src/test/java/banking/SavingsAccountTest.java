package banking;

import org.junit.Test;

import static org.junit.Assert.*;

public class SavingsAccountTest {
    private static double DEFAULT_INTEREST_RATE = 2.0;

    @Test
    public void SavingsAccount(double initialBalance) {
        
    }

    @Test
    public void addInterest(double balance, double initialBalance) {
        balance = initialBalance + (initialBalance * DEFAULT_INTEREST_RATE);
    }
}