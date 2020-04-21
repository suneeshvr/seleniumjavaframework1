package demo;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGparameterDemo {
	@Test
	@Parameters({ "myname" })
	public void test(@Optional("Suneesh") String name) {
		System.out.println("name is :" + name);
	}

}
