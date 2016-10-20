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
public class TC009_MeesevaIteratorDataProvider extends ProjectWrapper{

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

		//1. Enter Transaction Number
//		String transactionID = transIterator;//0
		String ApplicationNo = transactionID.split("TA")[1];//1
		String Name = "Data Not Found";//3
		String ServiceName = "Data Not Found";//4
		String TransactionDate = "Data Not Found";//5
		String Amount = "Data Not Found";//6
		String Status = "Data Not Found";//7
		String Remarks = "Data Not Found";//8
		String Approve = "Data Not Found";//9
		String PrintDate = "Data Not Found";//10
		String PrintedBy = "Data Not Found";//11
		String VLEID = "Data Not Found";//12
		String District = "Data Not Found";//13
		String Mandal = "Data Not Found";//14
		try{
			if(browserCloseCount==250){
				browserCloseCount=0;
				closeTheBrowser();
			}
			locateElementByID("txtAppNo");
			sendKeysToWebElement(transactionID);

			locateElementByID("btnSearch");
			clickOnElement();

			browserWait();

			transactionID = getData("lblTransId");
			ApplicationNo = getData("lblAppNo");
			Name = getData("lblName");
			ServiceName = getData("lblSerName");
			TransactionDate = getData("lblTransDate");
			Amount = "Rs. "+getData("lblAmount");
			Status = getData("lblStatus");
			Remarks = getData("lblRemarks");
			Approve = getData("lblAppDate");
			PrintDate = getData("lblPrintDate");
			PrintedBy = getData("lblPrintedBy");
			VLEID = getData("lblchannelid");
			District = getData("lblDistrict");
			Mandal = getData("lblmandal");
			
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
			++browserCloseCount;
			ExcelUtility.createRowAt(ExcelUtility.sheet.getLastRowNum()+1);
			ExcelUtility.setCellValueAt(0, transactionID);
			ExcelUtility.setCellValueAt(1,ApplicationNo);
			ExcelUtility.setCellValueAt(2,Name );
			ExcelUtility.setCellValueAt(3,ServiceName );
			ExcelUtility.setCellValueAt(4,TransactionDate );
			ExcelUtility.setCellValueAt(5,Amount );
			ExcelUtility.setCellValueAt(6,Status );
			ExcelUtility.setCellValueAt(7,Remarks );
			ExcelUtility.setCellValueAt(8,Approve );
			ExcelUtility.setCellValueAt(9, PrintDate);
			ExcelUtility.setCellValueAt(10,PrintedBy );
			ExcelUtility.setCellValueAt(11,VLEID );
			ExcelUtility.setCellValueAt(12, District);
			ExcelUtility.setCellValueAt(13, Mandal);
			
			ExcelUtility.commitChangesToExcel();
			System.out.println(transactionID+" => "+Status+" => "+LocalTime.now());
		}

	}

	@DataProvider(name = "getTransIDs")
	public static Iterator<String[]> dataIterator() {
        return IntStream.rangeClosed(6000, 6123).mapToObj(value -> new String[]{"TALRBD01160111"+value}).iterator();
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
