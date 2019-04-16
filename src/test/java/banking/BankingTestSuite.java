package banking;

import org.junit.Test;
import java.util.*;
import java.util.regex.*;
import java.util.Arrays;
import static org.junit.Assert.*;


/**
 * This class will contain all the test methods that we will be making for the banking program
 *
 */
public class BankingTestSuite {
    //Bank class Tests

    /**
     * This is an example for a test
     *
     * This will test to make sure that Banks main method runs without throwing an error
     * As banks main method is build(even though it will nether be), we will add the needed test process
     */
    @Test
    public final void testBankMainRuns() {
        //This string will hold the expected value of the test.
        //Set to "Passed" as a basic result as the tested method does not return or change anything internally
        String expectedResult = "Passed";
        //This string will hold the actual value of the test.
        String actualResult;

        try{
            //Calling the method that is being tested
            Bank.main(new String[0]);
            //As long as the main does not crash we will set the actualResult to "Passed", same as the expectedResult
            actualResult = "Passed";
        }
        catch (RuntimeException e){
            //If the tested method throws an error, we will catch is as set it to actualResult, so that it will fail the test
            actualResult = e.toString();
        }
        //This is the Junit part, were we will compare the values, and if they are the same the test passes
        assertEquals("Should run without throwing an error", expectedResult, actualResult);
    }

    @Test
    public void testBank() {

        String expectedValue = " Not Wells Fargo";

        Bank bank = new Bank("Not Wells Fargo");
        String result = bank.getNAME();
        assertEquals(" The Bank name equals the expected name. ", result, expectedValue);
    }

    @Test
    public void testBankEmptyString() {
        String expectedValue = "";
        String result;
        try {
            Bank bank = new Bank("");
            result = bank.getNAME();
        }
        catch (IllegalArgumentException e) {
            result = e.toString();
        }
        assertEquals(" Setting a Bank name to an empty string isn't acceptable. ", expectedValue,result);

    }

    @Test
    public void testBankNull() {
        String expectedValue = null;
        String result;
        try {
            Bank bank = new Bank(null);
            result = bank.getNAME();
        }
        catch (IllegalArgumentException e) {
            result = e.toString();
        }
        assertEquals(" Setting a Bank name to an empty string isn't acceptable. ", expectedValue,result);
    }

    @Test
    public void testAddCustomer() {
        Bank bank = new Bank("Not Wells Fargo");

        String expFirstName = "Dave";
        String expLastName = "Dinkins";

        String returnedID = bank.addCustomer("Dinkins","Dave");
        Customer customer = bank.getCustomer(returnedID);
        String returnedFName = customer.getFirstName();
        assertEquals(" The passed Customer name equals the expected Customer name ", expFirstName, returnedFName);

        String returnedLName = customer.getLastName();
        assertEquals(" The passed Customer last name equals the expected Customer last name. ", expLastName,returnedLName);

    }

    @Test
    public void testAddCustomerNull() {
        Bank bank = new Bank("Not Wells Fargo");
        String expFirstName = "Dave";
        String expLastName = "Dinkins";

        String returnedID = bank.addCustomer(null, "Dave");
        Customer customer = bank.getCustomer(returnedID);
        String returnedFName = customer.getFirstName();
        assertNull(" The passed Customer name . ", returnedFName);
        String returnedLName = customer.getLastName();
        assertNull(" The passed customer name is a null value. ", returnedLName);
    }

    @Test
    public void testAddCustomerEmpty() {
        Bank bank = new Bank("Not Wells Fargo");
        String expFirstName = "Dave";
        String expLastName = "Dinkins";

        String returnedID = bank.addCustomer("", "Dave");
        Customer customer = bank.getCustomer(returnedID);
        String returnedFName = customer.getFirstName();
        assertNull(" The passed Customer name . ", returnedFName);
        String returnedLName = customer.getLastName();
        assertNull(" The passed customer name is an empty string. ", returnedLName);
    }

    // Just an idea or prototype, we would need to know more about it's implementation
    @Test
    public void testGetAllCustomers() {
        SortedSet<Customer> customerList = new TreeSet();
        Bank bank = new Bank("Not Wells Fargo");
        Customer customer1 = new Customer(bank, "Dinkins","Dave");
        Customer customer2 = new Customer(bank, "Tee","Mister");
        Customer customer3 = new Customer(bank, "Coleman","Gary");

        customerList.add(customer1);
        customerList.add(customer2);
        customerList.add(customer3);
        SortedSet customerResult = bank.getAllCustomers();

        assertEquals(" The customer list result equals the expected customer list. ", customerResult,customerList);
    }

    @Test
    public void testGetCustomersAccounts() {
        List<Account> list = new ArrayList<>();

    }
    //Customer class Tests

    //SavingAccount class Tests, this will also be testing the Account class due to SavingAccount extending Account
    /*  check simple account method from constructor: */
    /**
     * Test of getAccountDescription & set method, of class SavingsAccount.
     */
    @Test
    public void testGetAccountDescriptionWithSet() {
        System.out.println("getAccountDescription");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 0,"Test");
        testAcc.setAccountDescription("Test-newDesc");
            
        String expResult = "Test-newDesc";
        String actResult=testAcc.getAccountDescription();
        if(! actResult.equals(expResult)){
          fail("Test change account description :\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
        }
    }
    

/**
     * Test of getAccountDescription method, of class SavingsAccount.
     */
    @Test
    public void testGetAccountDescriptionForConstructor() {
        System.out.println("GetAccountDescriptionForConstructor");
        Bank bank=new Bank("Trsut");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 0,"Test");
            
        String expResult = "Test";
        String actResult=testAcc.getAccountDescription();
        if(! actResult.equals(expResult)){
          fail("Test change account description :\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
    }
    }
        
    /**
     * Test of getBalance method with 0 balance, of class SavingsAccount.
     */
    @Test
    public void testGetBalanceByConstructor0() {
        System.out.println("Constructor with 0 balance");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 0,"Test");
            
        double expResult = 0;
        double actResult=testAcc.getBalance();
        if(! (Math.abs((double)expResult-actResult)<1.e-2)){
          fail("Test set balance throw constructor (0):\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
    }
        
   /**
     * Test of getBalance method, of class SavingsAccoun 
     */
    @Test
    public void testGetBalanceByConstructorNot0() {
        System.out.println("Constructor with not 0 balance");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 123,"Test");
            
        double expResult = 123;
        double actResult=testAcc.getBalance();
        if(! (Math.abs((double)expResult-actResult)<1.e-2)){
          fail("Test set balance throw constructor (not 0):\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
    }
    
    /**
     * Test of get customer id for account
     */
    @Test
    public void testGetCustomerID() {
        System.out.println("getCustomerID");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 123,"Test");
            
        String expResult = testCust.getCustomerId();
        String actResult=testAcc.getCustomerId();
        if(! actResult.equals(expResult)){
          fail("Test getCustomerID:\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
    }
        

    /**
     * Test of creating date (less that now)
     */
    @Test
    public void testGetCreatingDate() {
        System.out.println("get auto generated date");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 123,"Test");
            
        LocalDateTime expResult = LocalDateTime.now();
        LocalDateTime actResult=testAcc.getAccountCreationDate();
        if(actResult.isAfter(expResult)){
          fail("Test check correct date creating:\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
    }
    
    
    /**
     * Test of transaction amount
     */
    @Test
    public void testGetTransactionsEmpty() {
        System.out.println("get transaction without operation");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 123,"Test");
            
        int expResult =0;
        int actResult=testAcc.getTransactions().size();
        if(actResult!=expResult){
          fail("Test check amount transaction for newly created account:\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
    }
    
    /**
     * Test of transaction amount
     */
    @Test
    public void testGetTransactionsNotEmpty() {
        System.out.println("get transaction amount after 1 operation");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 1000,"Test");
        testAcc.addInterestTransaction(1);
            
        int expResult =1;
        int actResult=testAcc.getTransactions().size();
        if(actResult!=expResult){
          fail("Test check amount transaction for newly created account with 1 interisting transaction:\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
    }
    
    
    /**
     * Test of transaction amount
     */
    @Test
    public void testChangeBalance() {
        System.out.println("get balance after 1 interisting");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 1000,"Test");
        testAcc.addInterestTransaction(1);
            
        int expResult =1;
        int actResult=testAcc.getTransactions().size();
        if(actResult!=expResult){
          fail("Test check amount transaction for newly created account with 1 transaction:\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
        else //if correct amount transaction, check sum:
        {
            double expSum=Math.round(123*1.01);
            double actSum=testAcc.getBalance();
            if(Math.abs(actSum-expSum)>1e-2){
              fail("Test check amount money after 1 interisting:\n"+
              "Expect: "+expSum + "\n"+
              "Actual: "+actSum+"\n"+"");
                }
        }
    }
    
    /**
     * Test of deposit method, of class SavingsAccount.
     */
    @Test
    public void testDeposit() {
        System.out.println("check for deposit");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 1000,"Test");
        testAcc.deposit(100);
        //take out money:
        int expResult =1;
        int actResult=testAcc.getTransactions().size();
        if(actResult!=expResult){
          fail("Test check amount transaction for newly created account with 1 transaction:\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
        else //if correct amount transaction, check sum:
        {
            double expSum=1000+100;
            double actSum=testAcc.getBalance();
            if(Math.abs(actSum-expSum)>1e-2){
              fail("Test check amount money after 1 withdraw (100 USD):\n"+
              "Expect: "+expSum + "\n"+
              "Actual: "+actSum+"\n"+"");
                }
        }        
    }

    /**
     * Test of deposit method, of class SavingsAccount.for bad deposit value
     */
    @Test
    public void testDepositBadValue() {
        System.out.println("check for bad deposit");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 1000,"Test");
        try{
        testAcc.deposit(-100);
          fail("Test check for bad value of the deposit:\n"+
          "Expect: Crash for bad deposit\n"+
          "Actual: "+testAcc.toString()+"\n"+"");
            }
        catch(Exception e)
        {
        }
        
        
    }
    
    /**
     * Test of withdraw method, of class SavingsAccount.
     */
    @Test
    public void testWithdraw() {
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 1000,"Test");
        testAcc.withdraw(100);
        //take out money:
        int expResult =1;
        int actResult=testAcc.getTransactions().size();
        if(actResult!=expResult){
          fail("Test check amount transaction for newly created account with 1 transaction:\n"+
          "Expect: "+expResult + "\n"+
          "Actual: "+actResult+"\n"+"");
            }
        else //if correct amount transaction, check sum:
        {
            double expSum=1000-100;
            double actSum=testAcc.getBalance();
            if(Math.abs(actSum-expSum)>1e-2){
              fail("Test check amount money after 1 withdraw (100 USD):\n"+
              "Expect: "+expSum + "\n"+
              "Actual: "+actSum+"\n"+"");
                }
        }
        
    }

    /**
     * Test of deposit method, of class SavingsAccount.for bad deposit value
     */
    @Test
    public void testWithdrowBadValue() {
        System.out.println("check for bad deposit");
        Bank bank=new Bank("Trust");
        Customer testCust=new Customer(bank, "Smith", "John");
        SavingsAccount testAcc=new SavingsAccount (testCust, 1000,"Test");
        try{
        testAcc.withdraw(-100);
          fail("Test check for bad value of the withdrow:\n"+
          "Expect: Crash for bad deposit\n"+
          "Actual: "+testAcc.toString()+"\n"+"");
            }
        catch(Exception e)
        {
        }
        
        
    }
    
    /**
     * Test of getDefaultInterestRate method, of class SavingsAccount.
     */
    @Test
    public void testGetDefaultInterestRate() {
        System.out.println("getDefaultInterestRate");
        double expResult = 2.0;
        double result = SavingsAccount.getDefaultInterestRate();
        if(Math.abs(expResult-result)>1e-3)
                fail("Test check for get default interest rate:\n"+
                "Expect: "+expResult+"\n"+
                    "Actual: "+result+"\n"+"");
    }

    /**
     * Test of setDefaultInterestRate method, of class SavingsAccount.
     */
    @Test
    public void testSetDefaultInterestRate() {
        System.out.println("setDefaultInterestRate");
        double expResult = 2.0;
        SavingsAccount.setDefaultInterestRate(expResult);
        if(Math.abs(expResult-SavingsAccount.getDefaultInterestRate())>1e-3)
                fail("Test check for get default interest rate:\n"+
                "Expect: "+SavingsAccount.getDefaultInterestRate()+"\n"+
                    "Actual: "+SavingsAccount.getDefaultInterestRate()+"\n"+"");
    }

    //Transaction Class Tests

}
