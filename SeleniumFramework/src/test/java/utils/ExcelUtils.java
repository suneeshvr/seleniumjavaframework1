package utils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	private static String excelPath;
	private static String sheetName;

	public static void main(String[] args) {
//		getRowCount();
//		getCellData(1,1);
//		getCellDataNumber(1, 1);
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/excel/data.xlsx";
		String sheetname = "data";
		new ExcelUtils(excelPath, sheetname).getCellData(1, 1);
		new ExcelUtils(excelPath, sheetname).getAllRows();
	}

	public ExcelUtils(String excelPath, String sheetName) {
		this.excelPath = excelPath;
		this.sheetName = sheetName;
	}

	public int getRowCount() {
		XSSFWorkbook workbook = null;
		String projectPath = System.getProperty("user.dir");
		try {
			workbook = new XSSFWorkbook(projectPath + "/excel/data.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("data");
		int rowNo = sheet.getPhysicalNumberOfRows();
		System.out.println("no of rows =" + rowNo);
		return rowNo;

	}

	public static int getColCount() {
		XSSFWorkbook workbook = null;
		String projectPath = System.getProperty("user.dir");
		try {
			workbook = new XSSFWorkbook(projectPath + "/excel/data.xlsx");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet("data");
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("no of cells =" + cellCount);
		return cellCount;
	}

	public HashMap<String, String> getAllRows() {
		HashMap<String, String> users = new HashMap<String, String>();
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(this.excelPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(this.sheetName);
		for (Row row : sheet) {
			System.out.println(row.getRowNum());
			if (row.getRowNum() == 0) {
				continue;
			}
			String user = row.getCell(0).getStringCellValue();
			String password = null;
			String passwordType = row.getCell(1).getCellType().toString();
			if ("STRING".equals(passwordType)) {
				password = row.getCell(1).getStringCellValue();
			} else if ("NUMERIC".equals(passwordType)) {
				double d = row.getCell(1).getNumericCellValue();
				password = String.valueOf(d);
			}

			users.put(user, password);
			for (Map.Entry<String, String> entry : users.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
//			for (Cell cell : row) {
//				System.out.println(cell.getCellType());
//			}
		}
		return users;
	}

	public static void getCellData(int rownum, int colnum) {
		HashMap<String, String> map = new HashMap<String, String>();
		XSSFWorkbook workbook = null;
		try {
			workbook = new XSSFWorkbook(excelPath);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		XSSFSheet sheet = workbook.getSheet(sheetName);

		XSSFCell cell = sheet.getRow(rownum).getCell(colnum);
		String cellType = cell.getCellType().toString();
		System.out.println(cellType);
		if ("NUMERIC".equals(cellType)) {
			double cellvalue = sheet.getRow(rownum).getCell(colnum).getNumericCellValue();
			System.out.println(cellvalue);

		} else if ("STRING".equals(cellType)) {
			String cellvalue = sheet.getRow(rownum).getCell(colnum).getStringCellValue();
			System.out.println(cellvalue);
		}

	}

	public static void getCellDataNumber(int rowNum, int colNum) {

//		XSSFWorkbook workbook = null;
//		String projectPath = System.getProperty("user.dir");
//		try {
//			workbook = new XSSFWorkbook(this.);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		XSSFSheet sheet = workbook.getSheet("data");
//		XSSFCell cell = sheet.getRow(rowNum).getCell(colNum);
//		System.out.println("cell type=" + CellType.NUMERIC);
//
//		double cellDataNumber = cell.getNumericCellValue();
//		System.out.println(cellDataNumber);

	}
}
