package day41;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FDCalculator {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		
		String xlfile = System.getProperty("user.dir")+"\\testdata\\caldata.xlsx";
		
		String xlsheet = "Sheet1";
		
		int rowCount = ExcelUtil.getRowCount(xlfile, xlsheet);
		//int colCount = ExcelUtil.getCellCount(xlfile, xlsheet, rowCount);
		
		for(int r=1;r<=rowCount;r++) {
			// read data 
			
			String principle = ExcelUtil.getCellData(xlfile, xlsheet, r, 0);
			String ROI = ExcelUtil.getCellData(xlfile, xlsheet, r, 1);
			String period1 = ExcelUtil.getCellData(xlfile, xlsheet, r, 2);
			String period2 = ExcelUtil.getCellData(xlfile, xlsheet, r, 3);
			String frequency = ExcelUtil.getCellData(xlfile, xlsheet, r, 4);
			String expectedResult = ExcelUtil.getCellData(xlfile, xlsheet, r, 5);
			
			
			// pass to app
			
			driver.findElement(By.xpath("//input[@id='principal']")).sendKeys(principle);
			driver.findElement(By.xpath("//input[@id='interest']")).sendKeys(ROI);
			driver.findElement(By.xpath("//input[@id='tenure']")).sendKeys(period1);
			
			WebElement periodDropDown = driver.findElement(By.xpath("//select[@id='tenurePeriod']"));
			Select periodDropDownselect = new Select(periodDropDown);
			periodDropDownselect.selectByVisibleText(period2);
			
			Select fredrp=new Select(driver.findElement(By.xpath("//select[@id='frequency']")));
			fredrp.selectByVisibleText(frequency);
			
			driver.findElement(By.xpath("//div[@class='cal_div']//a[1]")).click();

			
			
			//validation
			
			String act_mvalue=driver.findElement(By.xpath("//span[@id='resp_matval']//strong")).getText();
			
			if(Double.parseDouble(expectedResult) == Double.parseDouble(act_mvalue)) {
				ExcelUtil.setCellData(xlfile, xlsheet, r, 7, "Passed");
				ExcelUtil.fillGreenColor(xlfile, xlsheet, r, 7);
				System.out.println("TC passed");
			}
			else {
				ExcelUtil.setCellData(xlfile, xlsheet, r, 7, "Failed");
				ExcelUtil.fillRedColor(xlfile, xlsheet, r, 7);
				System.out.println("TC Failed");
			}
			
			driver.findElement(By.xpath("//img[@class='PL5']")).click(); 
	
			
		}
		
		driver.quit();

	}

}
