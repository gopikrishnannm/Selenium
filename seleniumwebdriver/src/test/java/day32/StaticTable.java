package day32;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTable {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		
		int rowsWithoutHeader = driver.findElements(By.xpath("//table[@name='BookTable']//tr[not(th)]")).size();
		
		//System.out.println(rows);
		
		
		int columns = driver.findElements(By.xpath("//table[@name='BookTable']//th")).size();
		
		
		//retrieve data from 2nd row and 3rd column
		String text = driver.findElement(By.xpath("//table[@name='BookTable']//tr[2]//td[3]")).getText();
		
		//System.out.println(text);
		
		
		for(int i=1;i<=rowsWithoutHeader;i++) {
			if(i==1) {
				for(int j=1;j<=columns;j++) {
					String th = driver.findElement(By.xpath("//table[@name='BookTable']//tr[1]//th["+j+"]")).getText();
					System.out.print(th+"\t");
				}
				System.out.println();
			}
			else {
				for(int j=1;j <=columns;j++) {
					String td = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
					System.out.print(td+"\t");
				}
				System.out.println();
			}
	
		}
		

        //Print book names whose author is Mukesh
		
		/*for(int r=2;r<=rows;r++)
		{
			String authorName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText();
			
			if(authorName.equals("Mukesh"))
			{
				String bookName=driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName+"\t"+authorName);
			}
			
		}
		*/
		
		// price of all books 
		
		int total = 0;
		
		for(int r=2; r<=rowsWithoutHeader+1;r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			
			total += Integer.parseInt(price);
		}
		
		System.out.println(total);
		
		
		
		
		
		
		
		
		driver.quit();

	}

}
