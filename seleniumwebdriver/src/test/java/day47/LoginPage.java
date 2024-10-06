package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	
	WebDriver driver;
	
	// constructor
	LoginPage(WebDriver driver){
		this.driver = driver;
	}
	
	// locator
	
	By txt_username_loc=By.xpath("//input[@placeholder='username']");
	By txt_password_loc=By.xpath("//input[@placeholder='password']");
	By btn_login_loc=By.xpath("//button[normalize-space()='Login']");

	
	
	//action method
	
	public void setUsername(String username) {
		driver.findElement(txt_username_loc).sendKeys(username);
	}
	public void setPassword(String password) {
		driver.findElement(txt_password_loc).sendKeys(password);;
	}
	public void clickLogin() {
		driver.findElement(btn_login_loc).click();;
	}
}
