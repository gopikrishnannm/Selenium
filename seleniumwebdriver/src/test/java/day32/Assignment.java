package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment {

	public static void main(String[] args) {
		
		WebDriver driver =new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://blazedemo.com/");
		driver.manage().window().maximize();
		
		//Choose your departure city:
		WebElement departureList = driver.findElement(By.xpath("//select[@name='fromPort']"));
		
//		departureList.click();
		
		Select select = new Select(departureList);
		
		select.selectByVisibleText("Mexico City");
		
		
		// clicking find flight button
		driver.findElement(By.xpath("//input[@value='Find Flights']")).click();
		
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table']//tbody//tr"));
		
		int n = rows.size();
		
		// finding the lowsest price flight
		
		float minFlight = Float.MAX_VALUE;
		int cheapFlightRow = -1;
		
		for(int row=1;row<=n;row++) {
			String priceInDollar = rows.get(row-1).findElement(By.xpath(".//td[6]")).getText();
			String priceWO = priceInDollar.replace("$", "");
			float price = Float.parseFloat(priceWO);
			if(price <= minFlight) {
				minFlight = price;
				cheapFlightRow = row;
			}
		}
		
		//clicking on the button to redirect to booking ticket
		
		
		WebElement button = driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+cheapFlightRow+"]//td[1]//input"));
		
		button.click();
		
		/* Filling form */
		
		
		driver.findElement(By.id("inputName")).sendKeys("abc");
		
		driver.findElement(By.id("address")).sendKeys("address");
		
		driver.findElement(By.id("city")).sendKeys("city");
		
		driver.findElement(By.id("zipCode")).sendKeys("zipCode");
		
		WebElement dropDown = driver.findElement(By.id("cardType"));
		
		Select select2 = new Select(dropDown);
		
		select2.selectByIndex(0);
		
		int cardNumber = 123456789;
		
		driver.findElement(By.id("creditCardNumber"))
			.sendKeys(String.valueOf(cardNumber));
		
		
		driver.findElement(By.id("zipCode")).sendKeys("zipCode");
		
		WebElement creditCardMonth = driver.findElement(By.id("creditCardMonth"));
		creditCardMonth.clear();
		creditCardMonth.sendKeys("12");
		
		WebElement creditCardYear = driver.findElement(By.id("creditCardYear"));
		creditCardYear.clear();
		creditCardYear.sendKeys("2023");
		
		
		driver.findElement(By.id("nameOnCard")).sendKeys("jhon");
		
		driver.findElement(By.id("rememberMe")).click();
		
		
		driver.findElement(By.xpath("//input[@value='Purchase Flight']")).click();
		
		
		WebElement successMessage = driver.findElement(By.xpath("//h1[text()='Thank you for your purchase today!']"));
		
		if(successMessage.isDisplayed()) {
			System.out.println("Booking Succssfull!");
		}
		
		
		/* capture prices then store in array
		
		String pricesArr[]=new String[rows];   //0-4
		
		for(int r=1;r<=rows;r++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
			pricesArr[r-1]=price; //adding price into array
		}
		
	//7- Sort prices then find lower price value
		
		for(String arrvalue:pricesArr)
		{
			System.out.println(arrvalue);
		}
		
		Arrays.sort(pricesArr); // this will able to sort strings. so no need to convert to number
		String lowestPrice=pricesArr[0];
		System.out.println("Lower price:"+lowestPrice);
		
	//8- Find record in table having lower price
		
		for(int r=1;r<=rows;r++)
		{
			String price=driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[6]")).getText();
			
			if(price.equals(lowestPrice))
			{
				driver.findElement(By.xpath("//table[@class='table']//tbody//tr["+r+"]/td[1]//input")).click();
				break;
			}

		}
*/
		
	
		
		
		
		
		
		


	}

}
