package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DisableAutomatedMessage {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		option.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});

		WebDriver driver = new ChromeDriver(option);

		driver.get("https://demo.opencart.com/");
		
		Thread.sleep(5000);

		String actualTitle = driver.getTitle();

		if (actualTitle.equals("Your Store")) {
			System.out.println("TC pass");
		} else {
			System.out.println("TC failed");
		}

		driver.close();

	}

}
