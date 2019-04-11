package banking;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

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
            //If the tested method throws an error, we will catch it and set it to actualResult, so that it will fail the test
            actualResult = e.toString();
        }
        //This is the Junit part, were we will compare the values, and if they are the same the test passes
        assertEquals("Should run without throwing an error", expectedResult, actualResult);
    }

    /**
     * This will test that the Bank Classes addCustomer method properly creates adds a standard customer with the proper values
     */
    @Test
    public final void testBankAddCustomerStandard(){
        String returnedCustomerID;
        Customer returnedCustomerObject;

        String expectedFirstName = "TESTFirstName";
        String actualFirstName;

        String expectedLastName = "TESTLastName";
        String actualLastName;

        try{
            Bank testBank = new Bank("Test Bank");
            returnedCustomerID = testBank.addCustomer(expectedLastName,expectedFirstName);
            returnedCustomerObject = testBank.getCustomer(returnedCustomerID);

            actualFirstName = returnedCustomerObject.getFirstName();
            actualLastName = returnedCustomerObject.getLastName();

        }
        catch (RuntimeException e){
            actualFirstName = e.toString();
            actualLastName = e.toString();
        }
        assertEquals("Check FirstName String", expectedFirstName, actualFirstName);
        assertEquals("Check LastName String", expectedLastName, actualLastName);
    }

    //Customer class Tests

    //SavingAccount class Tests, this will also be testing the Account class due to SavingAccount extending Account

    //Transaction Class Tests

    /**
     * This will test that the transaction constructor properly creates a object with valid passed arguments
     */
    @Test
    public final void testTransactionClassConstructorStandard(){
        Transaction returnedObject;

        TransactionType expectedTransactionType = TransactionType.CHECK;
        TransactionType actualTransactionType = null;

        Double expectedAmountDouble = 10d;
        Double actualAmountDouble = null;

        String expectedDescriptionString = "TEST, NOT A REAL TRANSACTION";
        String actualDescriptionString = null;

        try{
            //Calling the method that is being tested
            returnedObject = new Transaction(expectedTransactionType,expectedAmountDouble,expectedDescriptionString);
            actualTransactionType = returnedObject.getType();
            actualAmountDouble = returnedObject.getAmount();
            actualDescriptionString = returnedObject.getDescription();
        }
        catch (RuntimeException e){
            returnedObject = null;
        }
        assertNotNull("Created object should exist", returnedObject);
        assertEquals("Check Transaction Type", expectedTransactionType, actualTransactionType);
        assertEquals("Check Amount Double", expectedAmountDouble, actualAmountDouble);
        assertEquals("Check Description String", expectedDescriptionString, actualDescriptionString);
    }

    /**
     * This will test that the transaction constructor properly creates a object with a Negative Amount passed
     */
    @Test
    public final void testTransactionClassConstructorNegativeAmount(){
        Transaction returnedObject;

        TransactionType expectedTransactionType = TransactionType.CHECK;
        TransactionType actualTransactionType = null;

        Double expectedAmountDouble = -10d;
        Double actualAmountDouble = null;

        String expectedDescriptionString = "TEST, NOT A REAL TRANSACTION";
        String actualDescriptionString = null;

        try{
            //Calling the method that is being tested
            returnedObject = new Transaction(expectedTransactionType,expectedAmountDouble,expectedDescriptionString);
            actualTransactionType = returnedObject.getType();
            actualAmountDouble = returnedObject.getAmount();
            actualDescriptionString = returnedObject.getDescription();
        }
        catch (RuntimeException e){
            returnedObject = null;
        }
        assertNotNull("Created object should exist", returnedObject);
        assertEquals("Check Transaction Type", expectedTransactionType, actualTransactionType);
        assertEquals("Check Amount Double", expectedAmountDouble, actualAmountDouble);
        assertEquals("Check Description String", expectedDescriptionString, actualDescriptionString);
    }
}
