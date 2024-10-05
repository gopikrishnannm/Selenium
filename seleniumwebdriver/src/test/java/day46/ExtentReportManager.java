package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	ExtentSparkReporter sparkReporter;
	ExtentReports extent;
	ExtentTest test;
	
	public void onStart(ITestContext context) {
		
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html");
		sparkReporter.config().setDocumentTitle("AutomationTesting");
		sparkReporter.config().setReportName("ORANge HrM");
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		extent.setSystemInfo("Computer Name", "machine01");
		extent.setSystemInfo("Env", "testing");
		extent.setSystemInfo("tester", "gk");
		extent.setSystemInfo("OS", "11");
		extent.setSystemInfo("Browser", "chrome");
		
	}
	public void onTestSuccess(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "test case passed is "+ result.getName() );
		
	}
	public void onTestFailure(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "test case failed is "+result.getName());
		test.log(Status.FAIL, "Test case failure cause "+ result.getThrowable());
		
	}
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "test casse skipped is "+result.getName());
	}
	public void onFinish(ITestContext context) {
		extent.flush();  //// Writes everything to the report file
	}
	
	
}
