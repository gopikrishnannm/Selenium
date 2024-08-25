package day38;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class EnableExtension {

	public static void main(String[] args) throws InterruptedException {
		
		ChromeOptions option = new ChromeOptions();
		File file = new File("C:\\Users\\gopik\\Downloads\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
		option.addExtensions(file);

		WebDriver driver = new ChromeDriver(option);

		driver.get("https://demo.opencart.com/");
		
		Thread.sleep(10000);

		String actualTitle = driver.getTitle();

		if (actualTitle.equals("Your Store")) {
			System.out.println("TC pass");
		} else {
			System.out.println("TC failed");
		}

		driver.close();

	}

}
