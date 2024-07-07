package own;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sample {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//driver = new EdgeDriver();
		
		driver.get("file:///C:/Users/gopik/OneDrive/Documents/SDET/sample.html");
		
		List<WebElement> ele = driver.findElements(By.xpath("//*[@class='list-item']"));
		
		for(WebElement e: ele ) {
			System.out.println(e.getText());
		}
	}

}
