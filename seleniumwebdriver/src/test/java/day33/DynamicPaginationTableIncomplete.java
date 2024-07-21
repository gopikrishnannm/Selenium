package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTableIncomplete {

	public static void main(String[] args) throws InterruptedException {
		
		//Initialization
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo-opencart.com/admin/index.php?route=common/login");
		driver.manage().window().maximize();
		
		//Login
		
		driver.findElement(By.id("input-username")).sendKeys("demo");
		driver.findElement(By.id("input-password")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//Handling information window
		
		WebElement InformationWindow = driver.findElement(By.xpath("//button[@class='btn-close']"));
		if(InformationWindow.isDisplayed()) {
			InformationWindow.click();
			
		}
		
		// navigating to pagination table page
		
		driver.findElement(By.partialLinkText("Customers")).click();
		driver.findElement(By.xpath("//ul[@id='collapse-5']//a[contains(text(),'Customers')]")).click();
		
		// retrieving no of pages in the table
		
		String pagesInforamtion = driver.findElement(By.xpath("//div[@class='col-sm-6 text-end']")).getText();
		int startingIndex = pagesInforamtion.indexOf('(')+1;
		int endingIndex = pagesInforamtion.indexOf("Pages")-1;
		String totalPagesInString = 
				pagesInforamtion.substring(startingIndex,endingIndex);
		
		int totalPages = Integer.parseInt(totalPagesInString);
		
		// iterating throw pages
//		for(int page=1;page<=totalPages;page++) {
//			if(page>1) {
//				//driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='"+String.valueOf(page)+"']")).click();
//			
//				WebElement element = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='" + page + "']"));
//				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
//				element.click();
//			}
//			
//			
//		}
		for(int p=1;p<=3;p++)
		{
			
			if(p>1)
			{
				WebElement active_page=driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				active_page.click();
				Thread.sleep(3000);
			}
			
			//reading data from the page
					
			int noOfRows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			for(int r=1;r<=noOfRows;r++)
			{
				String customerName=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[2]")).getText();
				String email=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[3]")).getText();
				String status=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+r+"]/td[5]")).getText();
				
				System.out.println(customerName+"\t"+email+"\t"+status);
				
			}
			
		}

		
		
		
		
		
		
	
		
		
		
		

	}

}
