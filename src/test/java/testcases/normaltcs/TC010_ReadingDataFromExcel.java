package testcases.normaltcs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * Note1:
 * Before reading an Excel data should be stored into an area.
 * Here in this project all data related Files were maintained under
 * 
 * src/main/resources/data folder
 * 
 * Note2:
 * poi, poi-ooxml must be added to pom.xml
 * 
 * @author RAJA
 *
 */
public class TC010_ReadingDataFromExcel {

	public static void main(String[] args) {
		
		try {
			//intializing Excel Work Book
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream("./src/main/resources/data/TrainsList.xlsx"));
			
			//Initializing Work Sheet
			XSSFSheet sheet = workbook.getSheet("Sheet1");
			
			//or
			
//			XSSFSheet sheet = workbook.getSheetAt(0);
			
			//get Rows
			/*Note:
			 * index value 0 gives the data stored in table header
			 */
			XSSFRow row = sheet.getRow(1);
			
			
			//get Cell
			XSSFCell cell = row.getCell(0);
			String source = cell.getStringCellValue();
			
			String destination = row.getCell(1).getStringCellValue();
			Date dateOfJourney = row.getCell(2).getDateCellValue();
			String noOfTrains = row.getCell(3).getStringCellValue();
			
			System.out.println("Source: "+source);
			System.out.println("Destination: "+destination);
			System.out.println("Date Of Journey: "+dateOfJourney);
			System.out.println("No.of Trains: "+noOfTrains);
			
			
			workbook.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
