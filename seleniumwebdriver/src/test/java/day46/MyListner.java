package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListner implements ITestListener{
	
	  public void onStart(ITestContext context) {
		    System.out.println("before starting the execution of all tests");
		  }
	  public void onTestStart(ITestResult result) {
		  System.out.println("before every tests");
	  }
	  public void onTestSuccess(ITestResult result) {
		    System.out.println("test passed");
		  }
	  public void onTestFailure(ITestResult result) {
		   System.out.println("test failed");
		  }
	  public void onTestSkipped(ITestResult result) {
		    System.out.println("test skipped");
		  }
	  public void onFinish(ITestContext context) {
		    System.out.println("all test completed");
		  }
	
}
