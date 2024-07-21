package day33;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable2 {

	public static void main(String[] args) throws InterruptedException {
		
		//Initialization
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		// finding no of pages
		
		List<WebElement> pagesElement = driver.findElements(By.xpath("//ul[@id='pagination']//li"));
		int noOfPages = pagesElement.size();
		
		// finding no of rows in table
		
		List<WebElement> rowsElements = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr"));
		
		int noOfRows = rowsElements.size();
		
		// iterating throw pages 
		
		for(int page=1;page<=noOfPages;page++) {
			
			// clicking the page
			if(page>1) {
				
				driver.findElement(By.xpath("//ul[@id='pagination']//a[text()='"+page+"']")).click();
				Thread.sleep(3000);
			}
			// checking the box
			
			for(int row=1;row<=noOfRows;row++) {
				
				WebElement checkBox = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+row+"]//td[4]//input"));
				
				Thread.sleep(1000);
				checkBox.click();

		
			}
			Thread.sleep(2000);
			
		}
		
	}
}

		
		
		
		
