package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDown {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		WebElement dropDownElement = driver.findElement(By.id("country"));
		
		Select eachElement = new Select(dropDownElement);
		
		eachElement.selectByVisibleText("France");
		
		eachElement.selectByValue("uk");
		
		eachElement.selectByIndex(0);
		
		
		List<WebElement> totalOptions = eachElement.getOptions();
		
		System.out.println(totalOptions.size());
		
		
		for(WebElement option : totalOptions) {
			System.out.println(option.getText());
		}
		

	}

}
