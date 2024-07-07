package day30;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HandleAlerts {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		
		
		// Alert with OK button
//		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
//		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.alertIsPresent());
//        
//		Thread.sleep(3000);
//		
//		Alert alert = driver.switchTo().alert();
//		
//		alert.accept();
		 
		//Alert with Cancel Button
		
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		
		Thread.sleep(3000);
		
		Alert confirm = driver.switchTo().alert();
		
		//confirm.accept();
		
		confirm.dismiss();
		
		
	}

}
