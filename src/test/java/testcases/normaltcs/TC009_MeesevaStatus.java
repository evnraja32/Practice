package testcases.normaltcs;

import java.time.LocalTime;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;

import util.ExcelUtility;
import wrapper.ProjectWrapper;

public class TC009_MeesevaStatus extends ProjectWrapper{

	protected static String url = "http://apdept.meeseva.gov.in/apsdcdeptportal/userinterface/TransactionSearch.aspx?%3fenc=2QwRHvPtRL6ckOHJMl4uYKdQxo7hmhrvZMjusmH1znR2+I7fJmRJcxPBQ7wlFZRMB2d2OO9AjarJpRYJ0R%2fh6w%3d%3d";

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		LocalTime time1 = LocalTime.now();
		
		ExcelUtility.prepareExcelSheet("Meeseva", "Sheet1");
		ExcelUtility.createOutputSheet("Meeseva");
		
		launchApp("chrome", url);

		browserWait();

		int count = 1078;
		int endPoint = count+12;
		for(int i = count ; i <= endPoint ; i++){
			

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
				locateElementByID("txtAppNo");
				sendKeysToWebElement(transactionID);

				//2. Click on Get details
				locateElementByID("btnSearch");
				clickOnElement();

				browserWait();

				locateElementByID("lblTransId");
				transactionID = getWebElement().getText();

				locateElementByID("lblAppNo");
				ApplicationNo = getWebElement().getText();

				locateElementByID("lblName");
				Name = getWebElement().getText();

				locateElementByID("lblSerName");
				ServiceName = getWebElement().getText();

				locateElementByID("lblTransDate");
				TransactionDate = getWebElement().getText();

				locateElementByID("lblAmount");
				Amount = "Rs. "+getWebElement().getText();

				locateElementByID("lblStatus");
				Status = getWebElement().getText();

				locateElementByID("lblRemarks");
				Remarks = getWebElement().getText();

				locateElementByID("lblAppDate");
				Approve = getWebElement().getText();

				locateElementByID("lblPrintDate");
				PrintDate = getWebElement().getText();

				locateElementByID("lblPrintedBy");
				PrintedBy = getWebElement().getText();

				locateElementByID("lblchannelid");
				VLEID = getWebElement().getText();

				locateElementByID("lblDistrict");
				District = getWebElement().getText();

				locateElementByID("lblmandal");
				Mandal = getWebElement().getText();

			}
			catch(StaleElementReferenceException e){
//				System.err.println(e.getMessage());
				continue;
			}
			catch(NoSuchElementException e){
//				System.err.println(e.getMessage());
				continue;
			}
			catch(NullPointerException e){
//				System.err.println(e.getMessage());
				continue;
			}finally{
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
				
//				ExcelUtility.commitChangesToExcel();
				LocalTime time2 = LocalTime.now();
				System.out.println(i+" => "+(time2.getHour()-time1.getHour())+":"+(Math.abs(time2.getMinute()-time1.getMinute()))+":"+(Math.abs(time2.getSecond()-time1.getSecond())));
			}

			System.out.println();

		}

		ExcelUtility.commitChangesToExcel();
		closeTheBrowser();

	}

}
