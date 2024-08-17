package day37;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.scrollTo(0, 0)"); // Reset scroll to the top
		js.executeScript("window.scrollBy(0,150000)"); 
		System.out.println(js.executeScript("return window.pageYOffset;"));// 2377.333251953125
		js.executeScript("window.scrollTo(0, 0)"); // Reset scroll to the top
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;")); // 1877.3333740234375
		
		
		

	}

}
