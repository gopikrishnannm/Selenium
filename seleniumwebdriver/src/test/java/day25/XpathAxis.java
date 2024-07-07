package day25;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class XpathAxis {
public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.manage().window().maximize();
		
		driver.get("https://money.rediff.com/gainers");
		
		// anchor tag
		//self
		String comp1 = driver.findElement(By.xpath("//a[contains(text(),'Camex Ltd.')]/self::a")).getText();
		// td tag but still give anchor tag value ie camex ltd
		//parent
		String comp2 = driver.findElement(By.xpath("//a[contains(text(),'Camex Ltd.')]/parent::*")).getText();
		
		//System.out.println(comp2.equals(comp1)); // true
		
		//ancestor
		
		List<WebElement> td = driver.findElements(By.xpath("//a[contains(text(),'Camex Ltd.')]/ancestor::tr/child::td"));
		
		
//		for(WebElement e: td) {
//			System.out.println(e.getText());
//		}
		
		//decendant
		
		List<WebElement> decendant1 = driver.findElements(By.xpath("//a[contains(text(),'Camex Ltd.')]/ancestor::tr/child::td"));
		
		List<WebElement> decendant2 = driver.findElements(By.xpath("//a[contains(text(),'Camex Ltd.')]/ancestor::tr/child::*"));
		
		//System.out.println(decendant1.size()+decendant2.size());
		
		// following - select everything in the document after closing tag of the current node
		
		List<WebElement> followingCompany = driver.findElements(By.xpath("//a[contains(text(),'Camex Ltd.')]/ancestor::tr/following::tr"));
		
		
		//System.out.println(followingCompany.size());
		
		
		//preceding - select all nodes appears before the curent node of the document
		
		
		List<WebElement> PrecedingCompany = driver.findElements(By.xpath("//a[contains(text(),'Camex Ltd.')]/ancestor::tr/preceding::tr"));
		
		//System.out.println(PrecedingCompany.size()); // header part included
		
		
		
		// preceding-sibling
		
		List<WebElement> PrecedingCompanyWithoutHeader = driver.findElements(By.xpath("//a[contains(text(),'Camex Ltd.')]/ancestor::tr/preceding-sibling::tr"));
		
		
		//System.out.println(PrecedingCompanyWithoutHeader.size());
		
		
		driver.close();
		
		
		
			
	}
}
