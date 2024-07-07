package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		
		//tag#id
		
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Pixel");
		
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Pixel");
		
		//tag.className
		
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Pixel2");
		
		// tag[attribute=\"value\"]
		//driver.findElement(By.cssSelector("[placeholder=\"Search store\"]")).sendKeys("pixel5");
		
		//tag className attribute
		driver.findElement(By.cssSelector("input.search-box-text[placeholder='Search store']")).sendKeys("hello");
		
		
		
		
	}

}
