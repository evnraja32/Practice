package testcases.testngtcs.priority.newsuite;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

//@Listeners(testcases.testngtcs.priority.newsuite.TestLiseteners.class)
public class TestNGWrapperTest {

	@BeforeMethod(groups={"Smoke","Sanity","Regression"})
	public void beforeMethod() {
		System.out.println("[Wrapper Class] Before Method");
	}

	@AfterMethod(groups={"Smoke","Sanity","Regression"})
	public void afterMethod() {
		System.out.println("[Wrapper Class] After Method");
	}

	@BeforeTest(groups={"Smoke","Sanity","Regression"})
	public void beforeTest() {
		System.out.println("[Wrapper Class] Before Test Method");
	}

	@AfterTest(groups={"Smoke","Sanity","Regression"})
	public void afterTest() {
		System.out.println("[Wrapper Class] After Test Method");
	}

	@BeforeSuite(groups={"Smoke","Sanity","Regression"})
	public void beforeSuite() {
		System.out.println("[Wrapper Class] Before Suite Method");
	}

	@AfterSuite(groups={"Smoke","Sanity","Regression"})
	public void afterSuite() {
		System.out.println("[Wrapper Class] After Suite Method");
	}

}
