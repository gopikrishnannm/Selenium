package day43;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertExample {

    @Test
    public void testMultipleAssertions() {
        SoftAssert softAssert = new SoftAssert();

        System.out.println("Starting Test");
        
        // First assertion - this will pass, but we add a print statement to show it
        softAssert.assertEquals(5, 5, "First Assertion Passed");
        
        
        // Second assertion - this will fail
        softAssert.assertEquals(5, 10, "Second Assertion Failed");
        
        // Third assertion - this will fail
        softAssert.assertTrue(10 > 20, "Third Assertion Failed");
        
        // Fourth assertion - this will fail
        softAssert.assertFalse(5 > 1, "Fourth Assertion Failed");
        
        System.out.println("Continuing Test even after assertion failures");
        
        // Collect all failures at the end
        softAssert.assertAll();
    }
}
