package rspleyto.testautomation.excelreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {
	
	private XSSFWorkbook workbook;
	private XSSFSheet sheet;
	
	public ExcelFileReader(String filePath) {
		try {
			
			File file = new File(filePath);
			FileInputStream is = new FileInputStream(file);
			workbook = new XSSFWorkbook(is);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getCellValue (int sheetNumber, int row, int column) {
		sheet = workbook.getSheetAt(sheetNumber);
		
		return sheet.getRow(row).getCell(column).getStringCellValue();
	}
	
	public int getRowCount (int sheetNumber) {
		int row = workbook.getSheetAt(sheetNumber).getLastRowNum();
		
		return row + 1;
	}

}
