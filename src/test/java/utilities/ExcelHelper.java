package utilities;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelHelper {

	Workbook book;
	Sheet sheet;

	// set excel
	public void setExcel(String folderName, String fileName, String sheetName) {
		try {
			FileInputStream fis = new FileInputStream(GenericHelper.getFilePath(folderName, fileName));
			if (fileName.endsWith("xls")) {
				book = new HSSFWorkbook(fis);
			} else {
				book = new XSSFWorkbook(fis);
			}
			sheet = book.getSheet(sheetName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// count number of rows
	public int rowCount() {
		return sheet.getLastRowNum();
	}

	// count number of columns
	public int columnCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public String readData(int rnum, int cnum) {
		String data = null;
		Cell cell = sheet.getRow(rnum).getCell(cnum);
		CellType cellTypeEnum = cell.getCellTypeEnum();
		switch (cellTypeEnum) {
		case STRING:
			data = cell.getStringCellValue();
			break;
		case NUMERIC:
			int i = (int) cell.getNumericCellValue();
			data = Integer.toString(i);
		default:
			data = "";
		}
		return data;
	}

	public String[][] getExcelData(String folderName, String fileName, String sheetName) {
		setExcel(folderName, fileName, sheetName);
		int nor = rowCount();
		int noc = columnCount();
		String[][] data = new String[nor][noc];
		for (int i = 1; i <= nor; i++) {
			for (int c = 0; c < noc; c++) {
				data[i-1][c] = readData(i, c);
			}
		}
		return data;
	}

	public static void main(String[] args) {
		ExcelHelper excel = new ExcelHelper();
		String[][] data = excel.getExcelData("", "testdata.xls", "employeeData");
		for (int i = 0; i < 5; i++) {
			for (int c = 0; c < 4; c++) {
				System.out.print(data[i][c] + "\t");
			}
			System.out.println();
		}
	}
}
