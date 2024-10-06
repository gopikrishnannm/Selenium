package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class Test2 {
	
	public static void main(String[] args) {
				
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/");
		
		// name locator
//		WebElement searchBox= driver.findElement(By.name("search"));
//		
//		searchBox.sendKeys("MacBook");
		
		
		//id locator
		
		//System.out.println(driver.findElement(By.id("logo")).isDisplayed());
		
		// LinkText
		
		
		
//        WebElement linkElement = driver.findElement(By.linkText("Phones & PDAs"));
//        linkElement.click();
		
		
//		List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
//		
//		System.out.println(headerLinks.size());
		
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a")); // img for image
		
		
		
		
		
		
		driver.close();
	}
	
}
