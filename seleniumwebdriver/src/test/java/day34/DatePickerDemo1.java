package day34;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePickerDemo1 {
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://jqueryui.com/datepicker/");
		driver.manage().window().maximize();
		
		//switch to frame
		//driver.switchTo().frame(0);
		WebElement frame = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(frame);
		
		// sending date as string
		WebElement datePicker = driver.findElement(By.id("datepicker"));
		//datePicker.sendKeys("07/07/2023");
		
		//using datepicker
		String year = "2022";
		String month = "May";
		String date = "12";
		
		Map<String, Integer> monthMap = new HashMap<>();
		monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);
		
		datePicker.click();
		
		
		
		//finding our month and year
		
		while(true) {
			
			String actualMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[1]")).getText();
			String actualYear = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']//span[2]")).getText();
			
			if(actualYear.equals(year) && actualMonth.equals(month)) {
				break;
			}
			if(Integer.parseInt(year) > Integer.parseInt(actualYear)) {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
			else if(Integer.parseInt(year) < Integer.parseInt(actualYear)){
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
			}
			else {
				
				int actualMonthInt = monthMap.get(actualMonth); 
				int targetMonth = monthMap.get(month);
				
				if(actualMonthInt > targetMonth) {
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-w']")).click();
				}
				if(targetMonth > actualMonthInt) {
					driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				}
				
			}
			
			
		}
		
		
		
		
	}
}
