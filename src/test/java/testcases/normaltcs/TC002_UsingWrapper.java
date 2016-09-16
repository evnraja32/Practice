package testcases.normaltcs;

import wrapper.ProjectWrapper;

public class TC002_UsingWrapper extends ProjectWrapper{
	/**
	 * The intenstion of this test case is to check for successfull navigation
	 * 
	 * Expected Result: when submit button in "Register Page" is clicked the Page should land into "Forms action page".
	 * 
	 * @param args
	 */
	
	protected static String parentWindow = "chrome";
	protected static String url = "file:///H:/Practice/src/main/java/htmlpages/registerpage.html";
	
	public static void main(String[] args) {
		
	launchApp(parentWindow, url);	
	
	locateElementByID("firstname");
	sendKeysToWebElement("First Name");

	locateElementByID("lastname");
	sendKeysToWebElement("Last Name");
	
	locateElementByID("submit");
	clickOnElement();
	
	
	if(verifyWindowTitle("Forms action page")){
		System.out.println("Test Case Success");
	}else{
		System.err.println("Test Case Failed");
	}
	
	closeTheBrowser();
	
	}

}
