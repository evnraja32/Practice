package testcases.normaltcs;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstDriverProgram {

	public static void main(String[] args) {
		// Launching Firefox driver
		FirefoxDriver driver = new FirefoxDriver();
		
		//Maximize the browser
		Dimension d = driver.manage().window().getSize();
		System.out.println("Height :  "+d.getHeight()+"\nWidth : "+d.getHeight());
		
		driver.manage().window().setSize(new Dimension(d.getHeight()-50, d.getWidth()-50));
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		//URL Navigation
		driver.get("http://demo1.opentaps.org/opentaps/control/main");

		System.out.println("Before Login Browser Title Name : "+driver.getTitle());
		
		//Entering Username
		driver.findElementById("username").sendKeys("DemoSalesManager");
	//	driver.findElement(by);
		
		//Entering Password
		driver.findElementByName("PASSWORD").sendKeys("crmsfa");
		
		//Pressing Login button
		driver.findElementByClassName("decorativeSubmit").click();
		
		System.out.println("After Login Browser Title Name : "+driver.getTitle());
		
		//Loguot 
		driver.findElementByClassName("decorativeSubmit").click();
		
		
		//closing the browser
		
		driver.quit();
		
		
		
	}

}
