package day41;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static CellStyle style;
	
	public static int getRowCount(String xlfile, String xlsheet) throws IOException {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		int rowCount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowCount;
	}
	
	public static int getCellCount(String xlfile, String xlsheet, int rownum) throws IOException {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		int cellCount = row.getLastCellNum();
		wb.close();
		fi.close();
		return cellCount;
	}
	public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		String data;
		try {
			//data = cell.toString();
			DataFormatter formatter = new DataFormatter();
			data = formatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data = "";
		}
		finally {
			wb.close();
			fi.close();
		}
		return data;
	}
	public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException {
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		/* 
		 The XSSFWorkbook class, which represents the 
		 workbook in memory, contains methods for working 
		 with sheets, such as getSheet and createSheet, 
		 regardless of whether you're using FileInputStream 
		 (fi) or FileOutputStream (fo) to interact with the file

		 */
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
	}
	public static void fillGreenColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		/*
		 IndexedColors.GREEN.getIndex() retrieves the index value of 
		 the color green from the IndexedColors enumeration, which 
		 contains a list of standard colors used in Excel.
		 */
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}
	public static void fillRedColor(String xlfile, String xlsheet, int rownum, int colnum) throws IOException {
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		row = ws.getRow(rownum);
		cell = row.getCell(colnum);
		
		style = wb.createCellStyle();
		style.setFillForegroundColor(IndexedColors.RED.getIndex());
		style.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		
		cell.setCellStyle(style);
		
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
	}

	
}
