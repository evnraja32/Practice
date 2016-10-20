package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


public class ExcelUtility {
	private static String dataFolderPath = "./src/main/resources/data/";
	private static String dataOutputFolderPath = "./output/";
	private static String outputFileName = null;

	//====== Handling Excel Files =======

	public static XSSFWorkbook workbook = null;
	public static XSSFSheet sheet = null;
	public static XSSFRow row = null;
	public static XSSFCell cell = null;
	private static File excelFile = null;
	private static FileInputStream fis = null;
	private static FileOutputStream fout = null;

	public static void prepareExcelSheet(String excelFileName,String sheetName){
		excelFile = new File(dataOutputFolderPath+excelFileName+".xlsx");
		try{
			fis = new FileInputStream(excelFile);
			workbook = new XSSFWorkbook(fis);
			if(!sheetName.equals("")){
				sheet = workbook.getSheet(sheetName);
			}else{
				sheet = workbook.getSheetAt(0);
			}
//			fis.close();
		}catch(IOException e){
			printException(e, "Error in excel book");
		}

	}

	public static String readExcel(int rowIndex, int colnum) 
	{
		row = sheet.getRow(rowIndex);
		cell = row.getCell(colnum);
		return cell.getStringCellValue();
	}

	public static void appendDataAt(int cellIndex,String data){
		try{
			sheet.createRow(sheet.getLastRowNum()+1).createCell(cellIndex).setCellValue(data);
			//			fout = new FileOutputStream(excelFile);
//			createOutputSheet();
		}
		catch(Exception e){
			printException(e, "Error in appending to excel method");
		}
	}

	public static XSSFWorkbook createWorkBook(String fileName) {
		try{
			fout = new FileOutputStream(new File(dataFolderPath+fileName+".xlsx"));
			workbook = new XSSFWorkbook();
		}catch(Exception e){
			printException(e, "Work Book Creation Failed");
		} 
		return workbook;
	}

	public static XSSFSheet createWorkSheet(String sheetName){
		try{
			sheet = workbook.createSheet(sheetName);
		}catch(Exception e){
			printException(e, "Work Sheet Creation Failed");
		} 
		return sheet;
	}

	public static XSSFRow createRowAt(int rowNum){
		try{
			row = sheet.createRow(rowNum);
		}catch(Exception e){
			printException(e, "Work Sheet Creation Failed in creating Row");
		} 
		return row;
	}

	public static void appendCellValueAt(int rownum,int cellNum, String cellValue){
		try{
			sheet.getRow(rownum).createCell(cellNum).setCellValue(cellValue);
		}catch(Exception e){
			printException(e, "Work Sheet Creation Failed in creating cell value");
		} 
	}
	public static void setCellValueAt(int cellNum, String cellValue){
		try{
			row.createCell(cellNum).setCellValue(cellValue);
		}catch(Exception e){
			printException(e, "Work Sheet Creation Failed in creating cell value");
		} 
	}

	public static void createOutputSheet(String excelFileName){

		outputFileName = excelFileName;//+(LocalDate.now().getYear()+""+LocalDate.now().getMonth()+LocalDate.now().getDayOfMonth()+"-"
//										+LocalTime.now().getHour()+"-"+LocalTime.now().getMinute()+"-"+LocalTime.now().getSecond());
		System.out.println(outputFileName);
			try {
				fout = new FileOutputStream(dataOutputFolderPath+outputFileName+".xlsx");
			} catch (FileNotFoundException e) {
				printException(e, "Fail to create a output file");
			}
	}
	public static void commitChangesToExcel(){
		try {
			fout = new FileOutputStream(excelFile);
//			System.out.println(dataOutputFolderPath+excelFi+".xlsx");
			workbook.write(fout);

			workbook.close();
			fout.close();
		} catch (IOException e) {
			printException(e, "Writing to excel failed");
		}
	}


	//====== Handling Excel Files =======
	//====== Exception Handles ==========

	public static  void  printException(Throwable e, String errorMessage) {

		//			System.err.println(errorMessage);
		////			System.err.println(e.getMessage()	);
		//			e.printStackTrace();

	}





}
