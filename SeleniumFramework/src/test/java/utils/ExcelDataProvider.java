package utils;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	private WebDriver driver;

	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
	}

	@Test(dataProvider = "test1data")
	public void test1(String username, String password) throws InterruptedException {
		System.out.println(username + "|" + password);
		driver.get("https://opensource-demo.orangehrmlive.com/");
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		Thread.sleep(2000);

	}

	@DataProvider(name = "test1data")
	public static Object[][] getData() {
		String projectPath = System.getProperty("user.dir");
		String excelPath = projectPath + "/excel/data.xlsx";
		String sheetname = "data";
		ExcelUtils excel = new ExcelUtils(excelPath, sheetname);

		HashMap<String, String> map = excel.getAllRows();
		Object[][] objs = new Object[map.size()][ExcelUtils.getColCount()];
		int rowCount = 0;
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
			objs[rowCount][0] = entry.getKey();
			objs[rowCount][1] = entry.getValue();
			rowCount++;
		}
		return objs;

	}

	public void testData(String excelPath, String sheetName) {

		ExcelUtils excel = new ExcelUtils(excelPath, sheetName);
		for (Map.Entry<String, String> entry : excel.getAllRows().entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}

	}

}
