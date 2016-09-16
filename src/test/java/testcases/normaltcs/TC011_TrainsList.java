package testcases.normaltcs;

import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;

import wrapper.ProjectWrapper;

public class TC011_TrainsList extends ProjectWrapper{
	protected static String url = "http://erail.in/";
	
	public static void main(String[] args) throws InterruptedException {
		try{
		launchApp("chrome", url);
		
//		browserWait();
		Thread.sleep(1000*30);
		locateElementByID("txtStationFrom");
		sendKeysToWebElement("MAS"+Keys.TAB);
		
		locateElementByID("txtStationTo");
		sendKeysToWebElement("YA"+Keys.ENTER);
		
		locateElementByID("buttonFromTo");
		clickOnElement();
		
		String splitUrl[] = driver.getCurrentUrl().toString().split("::");
		
		char alpabets[] = new char[26];
		alpabets[0] = 'A';
		for(int i = 1 ; i <= 25 ; i++){
			alpabets[i] = (char)(((int)'A')+i);
			System.out.println(alpabets[i]);
		}
		
		for(char a : alpabets){
			for(char b : alpabets){
				for(char c : alpabets){
					System.out.println((splitUrl[0]+"::"+a+""+b+""+c));
//					driver.get(splitUrl[0]+"::"+a+b+c);
				}
			}
		}
		}catch(TimeoutException e){
			e.printStackTrace();
		}
		finally{
//			closeTheBrowser(); 
		}
	}

}
