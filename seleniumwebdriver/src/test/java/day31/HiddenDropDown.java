package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropDown {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.manage().window().maximize();

		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		
		//Login
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//clicking pim
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		//clicking dropdown element
		driver.findElement(By.xpath("//div[6]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]")).click();
		
		Thread.sleep(5000);
	
		// clicking one item
		//driver.findElement(By.xpath("//span[normalize-space()='Automaton Tester']")).click();
		
		
		//count the no of jobs in the list
		List<WebElement> jobs = driver.findElements(By.xpath("//div[@role='listbox']//span"));
		
		System.out.println(jobs.size());
		
		for(WebElement job : jobs) {
			System.out.println(job.getText());
		}
		
		
		
		

	}

}
