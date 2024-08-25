package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessDemo {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");

		WebDriver driver = new ChromeDriver(option);

		driver.get("https://demo.opencart.com/");

		String actualTitle = driver.getTitle();

		if (actualTitle.equals("Your Store")) {
			System.out.println("TC pass");
		} else {
			System.out.println("TC failed");
		}

		driver.close();

	}

}
