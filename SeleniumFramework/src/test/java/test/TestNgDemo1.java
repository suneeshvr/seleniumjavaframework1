package test;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNgDemo1 {
	@BeforeTest
	public void setUpMytest() {
		System.out.println("My test setup");
	}

	@Test
	public void myTest1() {
		System.out.println("My test1");
	}

	@Test
	public void myTest2() {
		System.out.println("My test2");
	}
	@Test
	public void myTest3() {
		System.out.println("My test3");
	}

	@AfterTest
	public void myTearDownTest() {
		System.out.println("My teardown tests");
	}
}
