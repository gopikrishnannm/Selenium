package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class day26 {
	
	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		driver.manage().window().maximize();
		
		Thread.sleep(3000);
		
		String title = driver.getTitle();
		
		System.out.println("title is "+title);
		
		String currentURL = driver.getCurrentUrl();
		
		if(currentURL.equals("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login")) {
			
			System.out.println("both links are same");
		}
		
		String currentWindowId = driver.getWindowHandle();
		
		System.out.println("currentWindowId is "+ currentWindowId);
		
		WebElement nextPageLink = driver.findElement(By.linkText("OrangeHRM, Inc"));
		
		nextPageLink.click();
		
		Set<String> windowHandles= driver.getWindowHandles();
		
		System.out.println(windowHandles);
		
		Thread.sleep(3000);
		
		
		driver.close();
		
	}

}
