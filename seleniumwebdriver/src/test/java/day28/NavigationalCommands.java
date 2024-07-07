package day28;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationalCommands {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		driver.navigate().refresh();
		
		
		
		
//		URL url = new URL("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
//		
//		
//		driver.navigate().to(url);// loads in same tab
		
		
		driver.navigate().back();
		System.out.println(driver.getCurrentUrl());
		
		
		
//		try {
//			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//			
//			wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
//			
//			Thread.sleep(10000);
//			driver.navigate().forward();
//			System.out.println(driver.getCurrentUrl());
//		}
//		catch(TimeoutException  e) {
//			 System.out.println("Timeout waiting for URL to load: " + e.getMessage());
//			 //e.printStackTrace();
//		}
//		finally {
//			driver.quit();
//		}
		
		
		
		

	}

}
