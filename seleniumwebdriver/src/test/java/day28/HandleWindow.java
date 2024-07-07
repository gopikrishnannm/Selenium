package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleWindow {

	public static void main(String[] args) {


		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.manage().window().maximize();
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		WebElement link = driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']"));
		
		link.click();
		
		Set<String> WindowIds = driver.getWindowHandles();
		
		
		//approch 1 : by using list , accessing idividual item
		
//		List<String> windowList = new ArrayList(WindowIds);
//		
//		
//		String parentId = windowList.get(0);
//		
//		String childId = windowList.get(1);
//		
//		
//		System.out.println(driver.getTitle()); // parent title
		
		//WebElement emailBox = driver.findElement(By.id("Form_submitForm_EmailHomePage"));
		// throw nosuchelementexception
		
		//emailBox.sendKeys("gmail");
		
		//approach 2
		for(String id:WindowIds) {
			
			String title = driver.switchTo().window(id).getTitle();
			
			if(title.equals("OrangeHRM")) {
				//System.out.println(driver.getCurrentUrl());
				driver.close();
				//break; if needs to close only one  
			}
			// if we need to close multiple title window then put || in if condition
		
			
		}

	}

}
