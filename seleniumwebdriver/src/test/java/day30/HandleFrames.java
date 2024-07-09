package day30;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {
			
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

	
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//switch to frame1
		
		//frame[@src='frame_1.html']
		WebElement frame1 = driver.findElement(By.xpath("/html/frameset/frame[1]"));
		
		
		
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("abc");
		
		//switch to frame2 
		
		driver.switchTo().defaultContent();
		
		WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		
		
		
		driver.switchTo().frame(frame2);
		
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("second");
		
		
		// switch to frame 3
		
		
		driver.switchTo().defaultContent();
		
		WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		
		
		
		driver.switchTo().frame(frame3);
		
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("third");
		
		//switch to iframe (part of frame3)
		
		driver.switchTo().frame(0); // since there is only one frame
		
		//div[@id='i5']/descendant::div[@class='AB7Lab Id5V1']
		//div[@id='i5']//div[@class='AB7Lab Id5V1']
		
		
		driver.findElement(By.xpath("//div[@id='i5']//div[@class='AB7Lab Id5V1']")).click();
		
		
		driver.switchTo().defaultContent();
		
		
		WebElement frame5 = driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		
		driver.switchTo().frame(frame5);
		
		
		driver.findElement(By.linkText("https://a9t9.com")).click();
		
		
		System.out.println(driver.findElement(By.xpath("//img[@class='responsive-img' and @alt='UI Vision by a9t9 software - Image-Driven Automation']")).isDisplayed());
		
		

		
		
		
		
					
	}

}
