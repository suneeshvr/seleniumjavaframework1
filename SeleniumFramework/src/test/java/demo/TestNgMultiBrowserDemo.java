package demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgMultiBrowserDemo {
	private WebDriver driver = null;
	private String projectPath = System.getProperty("user.dir");

	@BeforeTest
	@Parameters("browserName")
	public void setup(String browserName) {
		System.out.println("browserName=" + browserName);
		if (browserName.equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", projectPath + "/drivers/geckodriver/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browserName.equals("ie")) {
			DesiredCapabilities cap = new DesiredCapabilities();
			cap.setCapability("ignoreProtectedModeSettings", true);
			System.setProperty("webdriver.ie.driver", projectPath + "/drivers/iedriver/IEDriverServer.exe");

			driver = new InternetExplorerDriver(cap);
		}
	}

	@Test
	public void test1() throws InterruptedException {
		driver.get("https://google.com");
		Thread.sleep(4000);
	}

	@AfterTest
	public void teardown() {
		driver.close();
		System.out.println("Test completed successfully");
	}

}
