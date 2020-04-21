package test;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import config.PropertiesFile;

public class TestNG_demo {

	private WebDriver driver;
	public static String browserName;
	private String projectPath = System.getProperty("user.dir");

	@BeforeTest
	public void setUpTest() {
		PropertiesFile.getProperties();
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		}

	}

	@Test
	public void googleSearch() {
		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation steps by steps");
//		driver.findElement(By.name("btnK")).sendKeys(Keys.RETURN);
//		driver.findElement(By.name("btnK")).click();
		driver.findElement(By.xpath("//div[@class='FPdoLc tfB0Bf']//input[@name='btnK']")).sendKeys(Keys.RETURN);
//		new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='index.html']")));

	}

	@AfterTest
	public void tearDownTest() {
		driver.close();
		System.out.println("Test created successfully");
		PropertiesFile.setProperties();
	}

}
