package testcases.normaltcs;

import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TC014_TestTestCase1 {

	public static void main(String args[]) throws InterruptedException{
		FirefoxDriver driver= new FirefoxDriver();
		WebDriverWait slept = new WebDriverWait(driver, 10);

		try{
			driver.get("https://jqueryui.com");
			driver.manage().window().maximize();

			driver.findElement(By.linkText("Selectmenu")).click();
			
			Thread.sleep(5000);

			System.out.println(new Date().toString()+"  -  " + driver.getTitle());


			driver = (FirefoxDriver) driver.switchTo().frame(slept.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("iframe"))));

			Thread.sleep(5000);
			System.out.println(new Date().toString()+"  -  " +driver.getTitle());

			//		slept.until(ExpectedConditions.elementSelectionStateToBe();

//			Select sel= new Select(slept.until(ExpectedConditions.elementToBeClickable(By.xpath("//fieldset/select"))));
			Select sel = new Select(driver.findElement(By.id("speed")));
			sel.selectByVisibleText("Slow");

			driver.findElement(By.xpath("//select[@id='files']"));
			sel.selectByIndex(3);

			driver.findElement(By.xpath("//select[@id='number']//span"));
			sel.selectByIndex(18);

			driver.findElement(By.xpath("//select[@id='salutation']//span"));
			sel.selectByIndex(1);

		}catch(TimeoutException e){
			System.err.println("Time out exception");
			e.printStackTrace();
			driver.close();
		}
	}

}
