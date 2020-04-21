package listeners;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class TestNgListenerDemo {
	@Test
	public void test1() {
		System.out.println("I am inside test1");
	}

	@Test
	public void test2() {
		System.out.println("I am inside test2");
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("https://google.com");
		driver.findElement(By.name("q")).sendKeys("Automation steps by steps");
		driver.findElement(By.name("qaaa")).sendKeys("Automation steps by steps");

		driver.close();
	}

	@Test
	public void test3() {
		System.out.println("I am inside test3");
		throw new SkipException("This test is skipped");
	}
}
