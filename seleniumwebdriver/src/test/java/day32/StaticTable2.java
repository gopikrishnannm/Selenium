package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable2 {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		int rowCount = driver.findElements(By.xpath("//table[@name='BookTable']//tr")).size();
		int columnCount = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		
		/* 
		for(int i=0;i<rowCount;i++) {
			List<WebElement> cells;
			if(i==0) {
				
				cells = rows.get(0).findElements(By.tagName("th"));
			}
			
			else {
				cells = rows.get(i).findElements(By.tagName("td"));
			}
			
			for(WebElement cell: cells) {
				String value = cell.getText();
				System.out.print(value+"\t");
			}
			System.out.println();
		}
		*/
		
		//retrieving books based on author 'Mukesh' 
		
		List<WebElement> rowsWithoutHeader = driver.findElements(By.xpath("//table[@name='BookTable']//tr[not(th)]"));
			
		for(WebElement row : rowsWithoutHeader) {
			
			//System.out.println(row.getAttribute("innerHTML"));
			
			String book = row.findElement(By.xpath(".//td[1]")).getText();
			String author = row.findElement(By.xpath(".//td[2]")).getText();
			
			if(author.equals("Mukesh")) {
				System.out.println(book);
			}
	
		}
		
		/*
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		for (WebElement row : rows) {
		    // Print the text content of the row
		    System.out.println(row.getText());

		    List<WebElement> columns = row.findElements(By.xpath(".//td"));
		    if (columns.size() > 1) {
		        String book = columns.get(0).getText();
		        String author = columns.get(1).getText();

		        if (author.equals("Mukesh")) {
		            System.out.println(book);
		        }
		    }
		}
		
		*/

			
		
		
		
		
		driver.quit();

	}

}
