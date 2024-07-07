package day25;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FBExample {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.facebook.com/reg");
		
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//div[@id='reg_form_box']/child::div[11]/button"));
		
		//driver.findElement(By.xpath("//button[text()='Sign Up']")).click();
		
		System.out.println(driver.findElement(By.xpath("//button[text()='Sign Up']/parent::div/parent::div/child::div[1]/div/div/div/div/div")).getText());
		
		
		
		//identify password from mobile number field - following - 
		//input[@id='u_0_g_Eg']/following::input
		
		System.out.println(driver.findElement(By.xpath("//input[@id='password_step_input']/preceding::input[1]")).getText());
		
		
	}

}
