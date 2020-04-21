package demo;

import org.testng.annotations.Test;

@Test(groups = { "AllClassTests" })
public class TestNGGroupDemo {
	@Test(groups = { "sanity" })
	public void test1() {
		System.out.println("this is test1");
	}

	@Test(groups = { "sanity", "smoke" })
	public void test2() {
		System.out.println("this is test2");
	}

	@Test(groups = { "sanity", "regressionF" })
	public void test3() {
		System.out.println("this is test3");
	}

	public void test4() {
		System.out.println("this is test4");
	}

	@Test(groups = { "regressionF" })
	public void test5() {
		System.out.println("this is test5");
	}

}
