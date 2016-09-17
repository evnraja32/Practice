package testcases.testngtcs;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import wrapper.TestNGWrapper;

public class TC017_YouTubeRefreshTest extends TestNGWrapper{

	@BeforeClass
	public void setWebPageCofig(){
		browser = "chrome";
		url = "https://www.youtube.com/watch?v=Pn6R654ZdVc";

	}


	@Test(invocationCount=1)
	public void testCase() {
			new WebDriverWait(driver, 30).until(ExpectedConditions.elementToBeClickable(By.xpath(".//*[@id='logo-container']/span[1]")));
			try {
				Thread.sleep(15000);
				driver.navigate().refresh();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}


	}
}
