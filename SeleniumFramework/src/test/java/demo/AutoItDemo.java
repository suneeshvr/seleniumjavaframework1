package demo;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AutoItDemo {
	@Test
	public static void test() {
		String projectPath = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", projectPath + "/drivers/chromedriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://tinyupload.com");
		driver.findElement(By.name("uploaded_file")).click();
		try {
			Runtime.getRuntime()
					.exec("D:\\Personal\\suneesh\\courses\\selenium\\SeleniumFramework\\fileuploadscript.exe");
			Thread.sleep(3000);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		driver.close();
	}
}
