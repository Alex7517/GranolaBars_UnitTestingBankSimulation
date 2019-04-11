package banking;

import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTest {

    @Test
    public void Customer() {
        Customer testCustomer = new Customer(bankName,"John", "Doe");
    }

    @Test
    public void addSavingsAccount() {
     Customer testCustomer = new Customer(bankName,"John", "Doe");          
     assertEquals(1000, "Savings Account");                   

    }

    @Test
    public void getAccount() {
      Customer testCustomer = new Customer(bankName,"John", "Doe");  
      Account custAccount =  testCustomer.getAccount(testCustomer.getCustomerID());
      assertEquals("", custAccount.getAccountID());
    }

    @Test
    public void getCustomerAccounts() {
        Customer testCustomer = new Customer(bankName,"John", "Doe");    
        testCustomer.getCustomerAccounts();
    }

    @Test
    public void removeAccount() {
        Customer testCustomer = new Customer(bankName,"John", "Doe");
        testCustomer.removeAccount ( testCustomer.getCustomerID());
    }

    @Test
    public void YtdFees() {
        Customer testCustomer = new Customer(bankName,"John", "Doe");
        Assert.assertEquals(0.0, testCustomer.YtdFees());
    }

    @Test
    public void YtdInterest() {
        Customer testCustomer = new Customer(bankName,"John", "Doe");
        Assert.assertEquals(0.0, testCustomer.YtdInterest());
    }

}