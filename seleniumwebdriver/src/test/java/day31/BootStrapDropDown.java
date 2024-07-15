package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootStrapDropDown {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://www.jquery-az.com/boots/demo.php?ex=63.0_2");

		driver.manage().window().maximize();

		driver.findElement(By.xpath("//button[contains(@class,'multiselect')]")).click();

		// select single option

		driver.findElement(By.xpath("//input[@value='Java']")).click();

		// capture all options

		List<WebElement> options = driver
				.findElements(By.xpath("//ul[contains(@class,'multiselect-container')]//input"));

		System.out.println(options.size());

		/*
		 * The issue with the original XPath //parent::label is that the double slashes
		 * // indicate searching for nodes anywhere in the document relative to the
		 * current node, which is not what you want when trying to locate the immediate
		 * parent. Instead, you should directly locate the parent node without using
		 * double slashes.
		 * 
		 * To understand better, let's break down the XPaths:
		 * 
		 * //parent::label:
		 * 
		 * The // indicates a search for nodes at any level in the document from the
		 * current node. parent::label is meant to select the parent label of the
		 * current node, but due to the preceding //, it searches for any parent label
		 * nodes anywhere in the document, which is incorrect and likely leads to no
		 * matches or incorrect matches. parent::label:
		 * 
		 * This correctly specifies to select the immediate parent node that is a label.
		 */

		for (WebElement option : options) {

			if (option.isSelected()) {
				option.click();
			}

			WebElement label = option.findElement(By.xpath("parent::label"));

			//System.out.println(label.getText());
		}
		// print only labels
		
		List<WebElement> labelsInDropDown = driver.findElements(By.xpath("//li[contains(@class,'multiselect-item')]//label"));
		
		for(WebElement label :  labelsInDropDown) {
			System.out.println(label.getText());
		}

		// other approch
		
		/* 
		select multiple options
		capture all the options and find out size
		List<WebElement> options = driver.findElements(By.xpath("//ul[contains(@class,'multiselect')]//label"));
		System.out.println("Number of labels:" + options.size()); // 14

		for (WebElement op : options) {
			String option = op.getText();

			if (option.equals("Java") || option.equals("Python") || option.equals("MySQL")) {
				op.click();
			}
		}
*/

		
	}

}
