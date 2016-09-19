package testcases.testngtcs.priority;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TC023_PriorityTestCaseOne {
	@Test(priority=2)
	public void testMethod() {
		msg("Test Case 1 testMethod");
	}
	@BeforeMethod
	public void beforeMethod() {
		msg("Test Case 1 beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		msg("Test Case 1 afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		msg("Test Case 1 beforeClass");
	}

	@AfterClass
	public void afterClass() {
		msg("Test Case 1 afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		msg("Test Case 1 beforeTest");
	}

	@AfterTest
	public void afterTest() {
		msg("Test Case 1 afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		msg("Test Case 1 beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		msg("Test Case 1 afterSuite");
	}

	public void msg(String str){
		System.out.println(str);
	}


}
