package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReaddatafromExcel {

	public static void main(String[] args) throws IOException {
		
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(file);
		XSSFSheet sheet = wb.getSheet("Sheet1");
		//XSSFSheet sheet2 = wb.getSheetAt(1);
		int rows = sheet.getLastRowNum(); // counting from 0
		int col = sheet.getRow(1).getLastCellNum(); // counting from 1
		
		for(int r=0;r<=rows;r++) {
			
			XSSFRow currentRow = sheet.getRow(r);
			
			for(int c=0;c<col;c++) {
				
				XSSFCell currentCell = currentRow.getCell(c);
				System.out.print(currentCell.toString()+"\t");
			}
			System.out.println();
		}
		
		wb.close();
		file.close();
	}

}
