package test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportDemoWithTestNg {
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;
	WebDriver driver;

	@BeforeSuite
	public void setUp() {
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
	}

	@BeforeTest
	public void setUpTest() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();

	}

	@Test
	public void test1() {
		
		ExtentTest test = extent.createTest("MyFirst Test", "sample test");
		driver.get("https://google.com");
		test.pass("Navigated");
		test.log(Status.INFO, "this shows usage of logs");
		test.info("show usage of info");
		try {
			test.fail("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void test2() {
		ExtentTest test = extent.createTest("MyFirst Test", "sample test");
		test.log(Status.INFO, "this shows usage of logs");
		test.info("show usage of info");
		try {
			test.pass("details", MediaEntityBuilder.createScreenCaptureFromPath("screenshot.png").build());
			test.addScreenCaptureFromPath("screenshot.png");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@AfterSuite
	public void teatDown() {
		extent.flush();
	}
	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("Test created successfully");
	}


}
