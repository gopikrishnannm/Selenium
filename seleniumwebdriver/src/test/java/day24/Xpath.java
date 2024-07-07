package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpath {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://demo.opencart.com/");
		
		//Xpath with single attribute
		
		//driver.findElement(By.xpath("//*[@title=\"MacBook\"]")).click();
		
		//xpath with multiple attributes
		
		//driver.findElement(By.xpath("//*[@title=\"MacBook\"][@class='img-fluid']")).click();

		
		//xpath with 'and'  'or' operators
		
		
		//driver.findElement(By.xpath("//*[@name='search' and @placeholder='Search']")).sendKeys("pixel");
		
		
		//xpath with inner text - text()
		
		//driver.findElement(By.xpath("//a[text()='MacBook']")).click();
		
		//driver.findElement(By.xpath("//a[text()='MacBook']")).click();
		
//		Boolean isDisplayed = driver.findElement(By.xpath("//h3[text()='Featured']")).isDisplayed();
//		String featured = driver.findElement(By.xpath("//h3[text()='Featured']")).getText();
//		
//		System.out.println(featured + isDisplayed);
		
		//contains method
		
		//driver.findElement(By.xpath("//*[contains(@placeholder, 'Sea')]")).sendKeys("hi");
		
		
		//starts-with
		
		
		//driver.findElement(By.xpath("//*[starts-with(@placeholder, 'Sea')]")).sendKeys("hi");
		
		//chained xpath 
		
		//System.out.println(driver.findElement(By.xpath("//div[@id='logo']/a/img")).isDisplayed());

		System.out.println(driver.findElement(By.xpath("/html/body/main/div[2]/div/div/text()")).getText());

	}

}
