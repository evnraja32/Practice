package testcases.testngtcs.priority;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class TC024_PriorityTestCaseTwo {
	@Test(priority=1)
	public void testMethod() {
		msg("Test Case 2 testMethod");
	}
	@BeforeMethod
	public void beforeMethod() {
		msg("Test Case 2 beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		msg("Test Case 2 afterMethod");
	}

	@BeforeClass
	public void beforeClass() {
		msg("Test Case 2 beforeClass");
	}

	@AfterClass
	public void afterClass() {
		msg("Test Case 2 afterClass");
	}

	@BeforeTest
	public void beforeTest() {
		msg("Test Case 2 beforeTest");
	}

	@AfterTest
	public void afterTest() {
		msg("Test Case 2 afterTest");
	}

	@BeforeSuite
	public void beforeSuite() {
		msg("Test Case 2 beforeSuite");
	}

	@AfterSuite
	public void afterSuite() {
		msg("Test Case 2 afterSuite");
	}

	public void msg(String str){
		System.out.println(str);
	}


}