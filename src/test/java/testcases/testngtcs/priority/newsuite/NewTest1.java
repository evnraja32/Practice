package testcases.testngtcs.priority.newsuite;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

import java.time.LocalTime;

import org.testng.Assert;
import org.testng.annotations.AfterClass;

//@Listeners(TestLiseteners.class)

public class NewTest1 extends TestNGWrapperTest {
	
	@Test(groups = { "Smoke", "Sanity", "Regression" }, threadPoolSize = 2, invocationCount = 5)
	public void f() {
		System.out.println("[Test Case 1]   Test Method " + (LocalTime.now()));
		Assert.assertTrue(false);
	}

	@BeforeClass(groups = { "Smoke", "Sanity", "Regression" })
	public void beforeClass() {
		System.out.println("[Test Case 1]   Before Class Method");
		Assert.assertTrue(false);
	}

	@AfterClass(groups = { "Smoke", "Sanity", "Regression" })
	public void afterClass() {
		System.out.println("[Test Case 1]   After Class Method");
	}

}
