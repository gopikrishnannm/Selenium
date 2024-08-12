 package day36;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		
		Actions action = new Actions(driver);
		
		WebElement minSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		//System.out.println("Location in (x, y) " + minSlider.getLocation());  // 56, 249
		//System.out.println("Location in x :" + minSlider.getLocation().getX());
		
		action.dragAndDropBy(minSlider, 100, 0).perform(); 
		//System.out.println("Location in (x, y) after drag and drop" + minSlider.getLocation());//150, 249
		
		WebElement maxSlider = driver.findElement(By.xpath("//div[@class='price-range-block']//span[2]"));
		
		System.out.println("Location in (x, y) " + maxSlider.getLocation());  // 56, 249
		action.dragAndDropBy(maxSlider, -100, 0).perform(); 
		System.out.println("Location in (x, y) " + maxSlider.getLocation());  // 56, 249


	}

}
