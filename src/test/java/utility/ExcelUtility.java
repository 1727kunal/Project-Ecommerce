package utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	String sheetLocation;
	FileInputStream fis;
	Workbook wb;
	Sheet currentSheet;
	int rowCount;
	int columnCount;

	public ExcelUtility(String sheetLocation) {
		this.sheetLocation = sheetLocation;
	}

	public int getRowCount(String sheetName) {
		try {
			fis = new FileInputStream(sheetLocation);
			wb = WorkbookFactory.create(fis);
			currentSheet = wb.getSheet(sheetName);
			rowCount = currentSheet.getPhysicalNumberOfRows();
			wb.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return rowCount;
	}

	public int getColumnCount(String sheetName, int rowNum) {
		try {
			fis = new FileInputStream(sheetLocation);
			wb = WorkbookFactory.create(fis);
			currentSheet = wb.getSheet(sheetName);
			columnCount = currentSheet.getRow(rowNum).getLastCellNum();
			wb.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return columnCount;
	}

	public Object[][] getSheetData(String sheetName, int rows, int columns) {
		Object[][] sheetDataArray = new Object[rows - 1][columns];
		try {
			fis = new FileInputStream(sheetLocation);
			wb = WorkbookFactory.create(fis);
			currentSheet = wb.getSheet(sheetName);
			for (int i = 0; i < rows - 1; i++) {
				for (int j = 0; j < columns; j++) {
					sheetDataArray[i][j] = String.valueOf(currentSheet.getRow(i + 1).getCell(j));
				}
			}
			wb.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return sheetDataArray;
	}
}
