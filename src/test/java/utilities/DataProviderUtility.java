package utilities;

import org.testng.annotations.DataProvider;

public class DataProviderUtility {

	@DataProvider(name = "emp data")
	public Object[][] getEmployeeData() {
		ExcelHelper excel = new ExcelHelper();
		return excel.getExcelData("", "testdata.xls", "employeeData");
	}

	@DataProvider(name = "role data")
	public Object[][] getRoleData() {
		ExcelHelper excel = new ExcelHelper();
		return excel.getExcelData("", "testdata.xls", "roleData");
	}
}
