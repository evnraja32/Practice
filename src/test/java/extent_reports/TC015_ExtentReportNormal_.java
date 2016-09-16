package extent_reports;

import util.ExtentReporter;


public class TC015_ExtentReportNormal_{
	public static void main(String[] args) {
		ExtentReporter.startResult();
		/*
		 - Now i'll execute startTestCase() method using for nested loops {i,j}.
		 - In I loop forevery i%5 == 0 && i == j, I want to conclude the test case as "FAIL" else "PASS"
		 - In I loop forevery i%2 == j%3 will be reported as info.
		 */
		for(int i = 1 ; i <= 200 ; i++){
			ExtentReporter.startTestCase("Test Case "+i,"Sample Test Case "+i);
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
			ExtentReporter.endResult();
		}


	}

}
