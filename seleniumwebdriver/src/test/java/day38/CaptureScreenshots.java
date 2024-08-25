package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshots {

	public static void main(String[] args) {
		
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// 1. take full screenshot
		
//		TakesScreenshot ts = (TakesScreenshot) driver;
//		File sourceFile = ts.getScreenshotAs(OutputType.FILE);
//		File targerFile = new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage2.png");
//		sourceFile.renameTo(targerFile);
		
		
		// 2. screenshot of specific section
//		WebElement continueShopping = driver.findElement(By.xpath("//div[@id='HTML1']//div[@class='widget-content']"));
//		File sourceFile2 = continueShopping.getScreenshotAs(OutputType.FILE);
//		File targetFile2 = new File(System.getProperty("user.dir")+"\\Screenshots\\table.png");
//		sourceFile2.renameTo(targetFile2);
		
		// an element
		WebElement wikiImageElement = driver.findElement(By.xpath("//img[@class='wikipedia-icon']"));
		File sourceFile3 = wikiImageElement.getScreenshotAs(OutputType.FILE);
		File targetFile3 = new File(System.getProperty("user.dir")+"\\Screenshots\\wiki.png");
		sourceFile3.renameTo(targetFile3);
		
	}

}
