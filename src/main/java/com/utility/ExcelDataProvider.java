package com.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;
	
	public ExcelDataProvider() throws Exception {
		
		File src = new File(System.getProperty("user.dir")+"\\Testdata\\exceldata.xlsx");
		FileInputStream file = new FileInputStream(src);
		
		wb = new XSSFWorkbook(file);	
	}
	
	public String getStringData(String sheetname, int row, int cell) {
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
	}
	
	public double getNumericData(String sheetname, int row, int cell) {
		return wb.getSheet(sheetname).getRow(row).getCell(cell).getNumericCellValue();
	}
	
	
}
