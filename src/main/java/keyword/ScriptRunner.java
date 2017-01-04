package keyword;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import util.ExtentReporter;

public class ScriptRunner {
	public static void main(String args[]) {

		// Need to fetch the applicable modules
		ExtentReporter.startResult();

		try {
			FileInputStream fis = new FileInputStream(new File("./src/main/resources/data/KeywordsExcel.xlsx"));
			@SuppressWarnings("resource")
			XSSFSheet sheet = new XSSFWorkbook(fis).getSheet("Summary");

			// get the number of rows
			int rowCount = sheet.getLastRowNum();
			for (int row = 1; row <= rowCount; row++) {
				if ((sheet.getRow(row).getCell(1).getStringCellValue()).equals("Y")) {
					FetchMap.execute(sheet.getRow(row).getCell(0).getStringCellValue());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
