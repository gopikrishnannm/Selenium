package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataToExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\filecreated.xlsx");
		
		XSSFWorkbook wb = new XSSFWorkbook();
		
		XSSFSheet sheet = wb.createSheet("exp.data");
		
		XSSFRow row0 = sheet.createRow(0);
		row0.createCell(0).setCellValue("domain");
		row0.createCell(1).setCellValue("Exp");
		XSSFRow row1 = sheet.createRow(1);
		row1.createCell(0).setCellValue("Testing");
		row1.createCell(1).setCellValue(2);
		
		wb.write(file); // attach workbook to file
		wb.close();
		file.close();
		
		System.out.println("file created...");
	}

}
