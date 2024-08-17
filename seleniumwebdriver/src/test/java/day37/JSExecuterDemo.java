package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JSExecuterDemo {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement inp = driver.findElement(By.xpath("//input[@id='name']"));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		//ChromeDriver driver = new ChromeDriver();
		//JavascriptExecutor js = driver;
		
		// sendkeys
		js.executeScript("arguments[0].setAttribute('value','abc')",inp);
		
		// click
		WebElement rd = driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", rd);
		
	}

}
