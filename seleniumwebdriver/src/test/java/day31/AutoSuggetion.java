package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggetion {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.google.com/");

		driver.manage().window().maximize();
		
		driver.findElement(By.name("q")).sendKeys("selenium");//Search box
		Thread.sleep(5000);

		
		List<WebElement> list = driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
		
		for(WebElement item: list) {
//			if("selenium".equals(item.getText())) {
//				item.click();
//			}
			WebElement label = item.findElement(By.xpath(".//span"));
			System.out.println(label.getText());
		}
		
		
		
		

	}

}
