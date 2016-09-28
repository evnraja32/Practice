package testcases.ruff;

import java.time.LocalTime;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.remote.SessionNotFoundException;
import org.testng.annotations.Test;

import util.ExcelUtility;
import wrapper.ProjectWrapper;

public class TC009_MeesevaStatus6 extends ProjectWrapper{

	protected static String url = "http://apdept.meeseva.gov.in/apsdcdeptportal/userinterface/TransactionSearch.aspx?%3fenc=pof+M6UqLs3nPkZqbmvKxcbJO6Qe3lkbZr2XzTKPc2Np0Z6xFnihoogdwwGvgt%2f3iEcvDHcuwDw2hxQjYJefWw%3d%3d";
	@Test(priority=6)
	public static void testMethod() {

		LocalTime time1 = LocalTime.now();

		launchApp("EDGE", url);

		browserWait();

		int count = 7301;
		int endPoint = 7440;
		int browserCloseCount=0;
		for(int i = count ; i <= endPoint ; i++){
			ExcelUtility.prepareExcelSheet("Meeseva", "Sheet1");

			//1. Enter Transaction Number
			String transactionID = "TALRBD01160111"+i;//0
			String ApplicationNo = "RBD01160111"+i;//1
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
				if(browserCloseCount==20){
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
				++browserCloseCount;
			}
			catch(StaleElementReferenceException e){
				//								System.err.println(e.getMessage());
				//				continue;
			}
			catch(NoSuchElementException e){
				//								System.err.println(e.getMessage());
				//				continue;
			}
			catch(NullPointerException e){
				//								System.err.println(e.getMessage());
				//				continue;
			}catch(@SuppressWarnings("deprecation") SessionNotFoundException e){
				//				--i;
				launchApp("chrome", url);

				browserWait();
				//				continue;
			}
			finally{
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
				LocalTime time2 = LocalTime.now();
				System.out.println(transactionID+" => "+Status+" => "+(time2.getHour()-time1.getHour())+":"+(Math.abs(time2.getMinute()-time1.getMinute()))+":"+(Math.abs(time2.getSecond()-time1.getSecond())));
			}
			//			System.out.println();
		}
		//		ExcelUtility.commitChangesToExcel();
		closeTheBrowser();
	}

	public static String getData(String locatorValue){
		locateElementByID(locatorValue);
		return getWebElement().getText();
	}

}
