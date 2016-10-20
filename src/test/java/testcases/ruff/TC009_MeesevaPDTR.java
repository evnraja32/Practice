package testcases.ruff;

import java.time.LocalTime;
import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import util.ExcelUtility;
import wrapper.ProjectWrapper;

@SuppressWarnings("deprecation")
public class TC009_MeesevaPDTR extends ProjectWrapper{

	protected static String url = "http://apdept.meeseva.gov.in/apsdcdeptportal/userinterface/TransactionSearch.aspx?%3fenc=pof+M6UqLs3nPkZqbmvKxcbJO6Qe3lkbZr2XzTKPc2Np0Z6xFnihoogdwwGvgt%2f3iEcvDHcuwDw2hxQjYJefWw%3d%3d";
	protected static int browserCloseCount=0;
	@BeforeTest
	public void beforeTest(){
		launchApp("firefox", url);
		browserWait();
	}

	@Test(priority=5, dataProvider="getTransIDs")
	public  void testMethod(String transactionID) {

		ExcelUtility.prepareExcelSheet("Meeseva", "Sheet1");

		String Status = "";//7
		String Remarks = "";//8
		String Approve = "";//9
		String PrintDate = "";//10
		String PrintedBy = "";//11
		try{
			locateElementByID("txtAppNo");
			sendKeysToWebElement(transactionID);

			locateElementByID("btnSearch");
			clickOnElement();

			browserWait();

			Status = getData("lblStatus");
			Remarks = getData("lblRemarks");
			Approve = getData("lblAppDate");
			PrintDate = getData("lblPrintDate");
			PrintedBy = getData("lblPrintedBy");
			
		}
		catch(StaleElementReferenceException e){
		}
		catch(NoSuchElementException e){
		}
		
		catch(NullPointerException e){
		}
		catch(WebDriverException e){
			launchApp("chrome", url);
			browserWait();
		}
		finally{
			ExcelUtility.appendCellValueAt(++browserCloseCount,6,Status );
			ExcelUtility.appendCellValueAt(browserCloseCount,7,Remarks );
			ExcelUtility.appendCellValueAt(browserCloseCount,8,Approve );
			ExcelUtility.appendCellValueAt(browserCloseCount,9, PrintDate);
			ExcelUtility.appendCellValueAt(browserCloseCount,10,PrintedBy );

			ExcelUtility.commitChangesToExcel();
			System.out.println(transactionID+" => "+Status+" => "+LocalTime.now());
		}

	}

	@DataProvider(name = "getTransIDs")
	public static Iterator<String[]> dataIterator() {
		ExcelUtility.prepareExcelSheet("Meeseva", "Sheet1");

		return IntStream.rangeClosed(1, ExcelUtility.sheet.getLastRowNum()).mapToObj(value -> new String[]{ExcelUtility.readExcel(value, 0)}).iterator();

	}

    

	public  String getData(String locatorValue){
		locateElementByID(locatorValue);
		return getWebElement().getText();
	}

	@AfterSuite
	public void tearDown(){
		closeTheBrowser();
	}


}
