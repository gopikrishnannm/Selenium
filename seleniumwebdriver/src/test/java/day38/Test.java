package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Test {

	public static void main(String[] args) {
		
		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless=new");
		
		WebDriver driver = new ChromeDriver(option);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		// an element
		WebElement wikiImageElement = driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
		File sourceFile3 = wikiImageElement.getScreenshotAs(OutputType.FILE);
		File targetFile3 = new File(System.getProperty("user.dir")+"\\Screenshots\\wikiHeadless.png");
		sourceFile3.renameTo(targetFile3);
		
	}

}
