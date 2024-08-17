package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		WebElement input = driver.findElement(By.xpath("//input[@id='filesToUpload']"));

		// uploading one file
		
		String file1 = "C:\\Users\\gopik\\OneDrive\\Documents\\SDET\\Text1.txt";
		input.sendKeys(file1);
		
		// uploading multiple files at a time
		
		String file2 = "C:\\\\Users\\\\gopik\\\\OneDrive\\\\Documents\\\\SDET\\\\Text2.txt";
		//input.sendKeys(file1+"\n"+file2);
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']//li[1]")).getText().equals("Text1.txt")) {
			System.out.println("TC passed");
		}
	}

}
