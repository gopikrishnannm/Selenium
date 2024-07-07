package day27;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ImplicitWait {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.manage().window().maximize();
		
		
		WebElement nextPageLink = driver.findElement(By.linkText("OrangeHRM, Inc"));
		
		nextPageLink.click();
		
		driver.close();
		
		//System.out.println(driver.getCurrentUrl());
		
	}

}
