package day38;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SSLhandling {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		
		option.addArguments("--headless=new");
		
		option.setAcceptInsecureCerts(true);
		

		WebDriver driver = new ChromeDriver(option);

		driver.get("https://expired.badssl.com/");

		String title = driver.getTitle();

		System.out.println(title);

		driver.close();

	}

}
