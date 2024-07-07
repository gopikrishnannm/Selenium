package day21;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.WebDriver;


public class FistTest {
	
	public static void main(String[] args) {
		
		// Launching the browser
		
		//ChromeDriver driver = new ChromeDriver();
		
		
		
		
		WebDriver driver = new ChromeDriver();
		
		//driver = new EdgeDriver();
		
		driver.get("https://demo.opencart.com/");
		
		
		// validate title of page "Your Store"
		
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals("Your Store")) {
			System.out.println("TC pass");
		}
		else {
			System.out.println("TC failed");
		}
		
		
		// close browser
		
		driver.close();
		
		
		
		
		
		
	}
	
}
