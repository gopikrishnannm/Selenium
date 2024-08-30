package day39;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args)  {
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		for(WebElement link : links) {
			String href = link.getAttribute("href");
			if(href == null || href.isEmpty()) {
				System.out.println("href not found");
				continue;
			}
			
			// hit url to server
			try {
				URL linkURL = new URL(href);
				HttpURLConnection connection = (HttpURLConnection) linkURL.openConnection();
				connection.connect();
				int responseCode = connection.getResponseCode();
				if(responseCode >= 400) {
					System.out.println(href + "is a broken link");
				}
				else {
					System.out.println(href + "is not a broken link");
				}
				
			}
			catch(Exception e) {}
			
			
			
		}
		
		

	}

}
