package utility;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider
	public Object[][] dataProviderForLogin() {
		ExcelUtility excelUtility = new ExcelUtility(
				"C:\\Users\\admin\\eclipse-workspace\\ProjectEcommerce\\TestData\\TestDataSheet.xlsx");
		int rows = excelUtility.getRowCount("LoginTestData");
		int columns = excelUtility.getColumnCount("LoginTestData", 0);
		Object[][] dataArray = new Object[rows][columns];
		dataArray = excelUtility.getSheetData("LoginTestData", rows, columns);
		return dataArray;
	}
}
