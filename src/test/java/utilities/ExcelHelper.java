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

}
