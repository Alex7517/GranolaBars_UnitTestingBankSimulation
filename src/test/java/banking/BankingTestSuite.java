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

    //Transaction Class Tests

}
