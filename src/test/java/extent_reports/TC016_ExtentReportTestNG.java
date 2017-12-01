package extent_reports;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import util.ExtentReporter;


public class TC016_ExtentReportTestNG{
	private static String testCaseName;
	private static String testCaseDesc;
	private static int i = 1;


	@BeforeSuite
	public void beforeSuite(){
		ExtentReporter.startResult();
		System.out.println("before suite executes");

	}

	@BeforeClass
	public void beforeClass(){
		
		testCaseDesc = "Sample Test Case to test the execution flow of ExtentReport using the TestNG Framework";
		System.out.println("before class");
	}

	@BeforeMethod
	public void beforeMethod(){
		testCaseName = "Test Case "+i;
		ExtentReporter.startTestCase(testCaseName,testCaseDesc);
		System.out.println("before method");
	}

	@Test(invocationCount = 15)
	public static void testCase() {
		System.out.println("at test case");
		/*
		 - Now i'll execute startTestCase() method using for nested loops {i,j}.
		 - In I loop forevery i%5 == 0 && i == j, I want to conclude the test case as "FAIL" else "PASS"
		 - In I loop forevery i%2 == j%3 will be reported as info.
		 */

		for(int j = 1 ; j <= 20 ; j++){
			if(i%5 == 0 && i == j){
				try{
					ExtentReporter.reportStep("Since "+i+"%5 == 0 && "+i+" == "+j+" is satisfied reporting status as fail", "fail");
				}catch(RuntimeException e){
					break;
				}
			}else{
				if(i%2 == j%3){
					ExtentReporter.reportStep("Since "+i+"%2 == "+j+"%3 is satisfied reporting status as info", "info");
				}else{
					ExtentReporter.reportStep("Normal step and status is pass", "pass");
				}
			}
		}
	}

	@AfterMethod
	public void afterMethod(){
		ExtentReporter.endResult();
		++i;
		System.out.println("after method");
	}

}
