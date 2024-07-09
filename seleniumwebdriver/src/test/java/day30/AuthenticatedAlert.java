package day30;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticatedAlert {
	
public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		
		//handiling authenticated alert
		
		//inject username and password in url
		// https://username:password@the-internet.herokuapp.com/basic_auth
		
		driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
		
		driver.manage().window().maximize();
		
		
		String message = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
		if(message.contains("Congratulations! You must have the proper credentials")) {
			System.out.println("successful login");
		}
		else {
			System.out.println("login failed");
		}
	}
}
