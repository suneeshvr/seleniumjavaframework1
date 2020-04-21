package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentReporter;

public class ExtentReportBasicDemo {
	public static void main(String[] args) {
		ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extentreport.html");
		ExtentReports extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		ExtentTest test1 = extent.createTest("Google Search Test one", "Test to validate search");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		test1.log(Status.INFO, "Starting Test case");

		driver.get("https://google.com");
		test1.pass("Navigated to gooogle.com ");
		driver.findElement(By.name("q")).sendKeys("Selenium tests");
		test1.pass("Entered text in textbox ");

		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.RETURN);

		test1.pass("Pressed keybord enter key ");
		driver.close();
		driver.quit();
		test1.pass("Closed the browser");
		test1.info("Test completed");
		
		
		ExtentTest test2 = extent.createTest("Google Search Test one", "Test to validate search");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		 driver = new ChromeDriver();
		 test2.log(Status.INFO, "Starting Test case");

		driver.get("https://google.com");
		test2.pass("Navigated to gooogle.com ");
		driver.findElement(By.name("q")).sendKeys("Selenium tests");
		test2.pass("Entered text in textbox ");

		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.RETURN);

		test2.fail("Pressed keybord enter key ");
		driver.close();
		driver.quit();
		test2.pass("Closed the browser");
		test2.info("Test completed");
		
		
		extent.flush();

	}

}
