package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {
	
	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		
		//1) scroll down page by pixel number
		
		js.executeScript("window.scrollBy(0,15000)", "");
		System.out.println(js.executeScript("return window.pageYOffset;")); //1500
		
		//upto an element
		
		WebElement ele = driver.findElement(By.xpath("//strong[text()='Community poll']"));
		//js.executeScript("arguments[0].scrollIntoView();", ele);
		//System.out.println(js.executeScript("return window.pageYOffset;")); 
		
		//till end  of document
		
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)", "");
		
		//System.out.println(js.executeScript("return window.pageYOffset;"));
		
		// return to top of the document
		
		//Thread.sleep(2000);
		
		//js.executeScript("window.scrollBy(0,-document.body.scrollHeight)", "");
		 
		
		
		
		
		
		
		
		
		
	}

}
