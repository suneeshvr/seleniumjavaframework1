package config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

import test.TestNG_demo;

public class PropertiesFile {

	public static void main(String[] args) {
		getProperties();
		setProperties();
		getProperties();
	}

	public static void getProperties() {

		try {
			Properties prop = new Properties();
			String propertyPath = System.getProperty("user.dir");
			InputStream input = new FileInputStream(propertyPath + "/src/test/java/config/config.properties");
			prop.load(input);
			String browser = prop.getProperty("browser");
			System.out.println(browser);
			TestNG_demo.browserName = browser;
			System.out.println(TestNG_demo.browserName);
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getCause());
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void setProperties() {
		Properties prop = new Properties();
		String propertyPath = System.getProperty("user.dir");
		try {
			OutputStream output = new FileOutputStream(propertyPath + "/src/test/java/config/config.properties");
			prop.setProperty("browser", "chrome");
			prop.store(output, null);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
