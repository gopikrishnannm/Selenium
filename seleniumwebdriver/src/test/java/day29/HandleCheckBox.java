package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBox {
	
	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		driver.manage().window().maximize();
		
		//1.select check box
		WebElement checkbox = driver.findElement(By.xpath("//input[@id='sunday']"));
		
		if(!checkbox.isSelected()) {
			//checkbox.click();
			System.out.println("check box now clicked? "+ checkbox.isSelected());
		}
		
		//2.capturing all the checkboxes
		
		List<WebElement> totalDays = driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox']"));
		
		System.out.println(totalDays.size());
		
		//3.selecting all checkboxes
		
//		for(int day=0;day<totalDays.size();day++) {
//			
//			totalDays.get(day).click();
//			
//			WebElement label = driver.findElement(By.cssSelector("label[for='"+totalDays.get(day).getAttribute("id")+"']"));
//			
//			System.out.println(label.getText());
//			
//		}
		
		
		
//		for(WebElement day : totalDays) {
//
//			WebElement label = driver.findElement(By.cssSelector("label[for='" + day.getAttribute("id") + "']"));
//			
//			System.out.println(label.getText());
//			
//		}
		
		// selecting last 3 checkboxes 
		
//		for(int i=totalDays.size()-1;i>= totalDays.size()-3; i--) {
//			totalDays.get(i).click();
//		}
		
		//check if unchecked and vice versa
		
		// checking few checkboxes
		
//		for(int i=0;i<totalDays.size();i++) {
//			if(i%2 == 0) {
//				totalDays.get(i).click();
//			}
//		}
		
		// applying requirment
		
//		
		
		//selecting perticular checkbox
		
		for(WebElement day : totalDays) {
			String label = driver.findElement(By.cssSelector("label[for='"+day.getAttribute("id")+"']")).getText();
			if(label.equals("Sunday") || label.equals("Saturday")) {
				day.click();
			}
		}
		
		//8) select checkbox based on the value
		
		String weekname="Saturday";
		
		switch(weekname)
		{
		case "Sunday" : driver.findElement(By.xpath("//input[@id='sunday']")).click();
						break;
		
		case "Monday" : driver.findElement(By.xpath("//input[@id='monday']")).click();
						break;

		case "Tuesday" : driver.findElement(By.xpath("//input[@id='tuesday']")).click();
						break;

		case "Wednessday" : driver.findElement(By.xpath("//input[@id='wednessday']")).click();
						break;

		case "Thursday" : driver.findElement(By.xpath("//input[@id='thursday']")).click();
						break;

		case "Friday" : driver.findElement(By.xpath("//input[@id='friday']")).click();
						break;

		case "Saturday" : driver.findElement(By.xpath("//input[@id='saturday']")).click();
						break;
		default	: System.out.println("Invalid week name");
		
		
		}

		
		
		
		
		
		
	}

}
