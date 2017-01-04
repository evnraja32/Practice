package keyword;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.Method;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import util.ExtentReporter;

public class FetchMap {
	public static void execute(String moduleName) throws Exception{
		ExtentReporter.startTestCase("Executing Functionality: "+moduleName, "");

		Class<BaseClass> vClass = BaseClass.class;
		Object vObject = vClass.newInstance();

		Method[] methods = vClass.getMethods();

		FileInputStream fis = new FileInputStream(new File("./src/main/resources/data/KeywordsExcel.xlsx"));
		@SuppressWarnings("resource")
		XSSFSheet sheet = new XSSFWorkbook(fis).getSheet(moduleName);

		// get the number of rows
		int rowCount = sheet.getLastRowNum();

		for (int i = 1; i <= rowCount; i++) {

			String command = "";
			String arg1 = "";
			String arg2 = "";
			try {
				command = sheet.getRow(i).getCell(0).getStringCellValue();
				arg1 = sheet.getRow(i).getCell(1).getStringCellValue();
				arg2 = sheet.getRow(i).getCell(2).getStringCellValue();
			} catch (NullPointerException e) {
			}

			for (Method method : methods) {
				// checking method name
				if (method.getName().equals(command)) {
					// matching arguments
					if (arg1.equals("") && arg2.equals("")) {
						// triggering or calling the actual method
						method.invoke(vObject); // execute();
					} else if (arg2.equals("")) {
						method.invoke(vObject, arg1);
					} else {
						method.invoke(vObject, arg1, arg2);
					}

				}
			}

		}

	}
}
