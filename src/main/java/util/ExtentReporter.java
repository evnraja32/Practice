package util;

import java.io.File;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import wrapper.PageFactoryWrapper;

public class ExtentReporter  extends PageFactoryWrapper{

	private static ExtentTest test;
	private static ExtentReports extent;

	public static void reportStep(String desc, String status) {

		long imageName = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
//		takeScreenShot(""+imageName);
		
		switch(status.toUpperCase().trim()){
		case "PASS": test.log(LogStatus.PASS, desc+test.addScreenCapture(takeScreenShot(""+imageName)));
					 break;
		case "FAIL": test.log(LogStatus.FAIL, desc+test.addScreenCapture(takeScreenShot(""+imageName))); 
					 endResult(); 
					 throw new RuntimeException("FAILED");
		case "FATAL": test.log(LogStatus.FATAL, desc); 
					  endResult(); 
					  throw new RuntimeException("FATAL Error");
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
