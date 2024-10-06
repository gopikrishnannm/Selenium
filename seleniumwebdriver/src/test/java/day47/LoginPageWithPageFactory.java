package day47;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPageWithPageFactory {
	
	WebDriver driver;
	
	// constructor
	LoginPageWithPageFactory(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	// locator

	@FindBy(xpath="//input[@placeholder='password']") WebElement txt_password;

	@FindBy(how=How.XPATH, using="//input[@placeholder='username']") WebElement txt_username;
	
	@FindBy(xpath="//button[text()=' Login ']") WebElement btn_login;
	//@FindBy(tagName="a") List<WebElement> links;
	
	
	//action method
	
	public void setUsername(String username) {
		txt_username.sendKeys(username);
	}
	public void setPassword(String password) {
		txt_password.sendKeys(password);;
	}
	public void clickLogin() {
		btn_login.click();;
	}
}
