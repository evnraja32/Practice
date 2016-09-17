package testcases.normaltcs;

import wrapper.ProjectWrapper;

public class TC018_YouTubeRefreshTest extends ProjectWrapper{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser = "chrome",
				url = "https://www.youtube.com/watch?v=Pn6R654ZdVc";

		launchApp(browser, url);

		for(int i = 1 ; i <= 100 ; i++){
			driver.navigate().refresh();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
