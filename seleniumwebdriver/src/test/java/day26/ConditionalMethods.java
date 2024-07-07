package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/register");
		
		driver.manage().window().maximize();
		
		
		boolean isLogoDisplayed = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		
		System.out.println("display status of logo is "+ isLogoDisplayed);
		
		boolean isFirstNameEnabled = driver.findElement(By.id("FirstName")).isEnabled();
		
		System.out.println("FirstName field status is Enabled ? "+ isFirstNameEnabled);
		
		boolean isGenderSelected = driver.findElement(By.xpath("//input[@id='gender-male' or @id='gender-female']")).isSelected();
		
		System.out.println("gender selected?"+isGenderSelected);
		
		boolean isNewsLetterDefultlySelected = driver.findElement(By.id("Newsletter")).isSelected();
		
		System.out.println("isNewsLetterDefultlySelected "+isNewsLetterDefultlySelected);
	}

}
