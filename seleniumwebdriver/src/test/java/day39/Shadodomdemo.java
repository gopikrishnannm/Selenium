package day39;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Shadodomdemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
 
		driver.get("https://books-pwakit.appspot.com/");
		driver.manage().window().maximize();
		
		SearchContext root1 = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot();
		//Thread.sleep(1000);
		root1.findElement(By.cssSelector("#input")).sendKeys("book");

	}

}
