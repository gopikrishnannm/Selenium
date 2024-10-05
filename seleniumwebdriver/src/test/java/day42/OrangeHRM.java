package day42;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class OrangeHRM {

	WebDriver driver;

	@Test
	void openApp() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
	}

	@Test(priority = 1)
	void testLogo() throws InterruptedException {
		Thread.sleep(3000);
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		System.out.println("logo displayed..."+status);

//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement logo = wait.until(ExpectedConditions.visibilityOfElementLocated(
//                By.xpath("//div[@class='orangehrm-login-logo-mobile']//img[@alt='orangehrm-logo']")));
//		System.out.println(logo.isDisplayed());
//		System.out.println("display : "+ logo.getCssValue("display"));
//		System.out.println(logo.getCssValue("visibility"));

	}
	

 
	@Test(priority = 2)
	void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();

	}

	@Test(priority = 3)
	void logout() {
		driver.quit();
	}

}
