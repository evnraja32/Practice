package testcases.ruff;

import org.testng.annotations.Test;

import util.ExcelUtility;

import java.util.Iterator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.testng.annotations.DataProvider;

public class NewTest {
	@Test(dataProvider="getTransIDs")
	public  void testMethod(String transactionID) {
		System.out.println(transactionID);
	}

	@DataProvider(name = "getTransIDs")
	public static Iterator<String[]> dataIterator() {
		ExcelUtility.prepareExcelSheet("Meeseva", "Sheet1");

		return IntStream.rangeClosed(1, ExcelUtility.sheet.getLastRowNum()).mapToObj(value -> new String[]{ExcelUtility.readExcel(value, 0)}).iterator();

	}
	
	public String method (int value){
		
		return new String(ExcelUtility.readExcel(value, 0));
	}
}
