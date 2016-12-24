package testcases.testngtcs.priority.newsuite;

import org.testng.annotations.Test;

import java.time.LocalTime;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

//@Listeners(TestLiseteners.class)
public class NewTest2 extends TestNGWrapperTest{
	@Test(groups="Smoke")
	public void f() {
		System.out.println("[Test Case 2] Test Method "+(LocalTime.now()));
	}

	@BeforeClass(groups="Smoke")
	public void beforeClass() {
		System.out.println("[Test Case 2] Before Class Method");
	}

	@AfterClass(groups="Smoke")
	public void afterClass() {
		System.out.println("[Test Case 2] After Class Method");
	}
	
	
	/*@Test
	public void f1() {
		System.out.println("@ Test Method 1");
	}
	
	@Test
	public void f2() {
		System.out.println("@ Test Method 2");
	}

	@BeforeTest
	public void beforeTest1() {
		System.out.println("Before Test 1");
	}

	@AfterTest
	public void afterTest1() {
		System.out.println("After Test 1");
	}
	
	@AfterTest
	public void afterTest2() {
		System.out.println("After Test 2");
	}*/
	

}
