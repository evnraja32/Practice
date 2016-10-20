package util;

import java.io.File;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentReporter {

	private static ExtentTest test;
	private static ExtentReports extent;

	public static void reportStep(String desc, String status) {

		switch(status.toUpperCase().trim()){
		case "PASS": test.log(LogStatus.PASS, desc); break;
		case "FAIL": test.log(LogStatus.FAIL, desc); throw new RuntimeException("FAILED");
		case "INFO": test.log(LogStatus.INFO, desc); break;
		}
	}

	public static void startResult(){
		extent = new ExtentReports("./output/reports/result.html", true);
		extent.loadConfig(new File("./config/extent-config.xml"));
	}

	public static void startTestCase(String testCaseName,String testCaseDesc){
		test = extent.startTest(testCaseName,testCaseDesc );
	}

	public static void endResult(){
		extent.endTest(test);
		extent.flush();
	}
}
