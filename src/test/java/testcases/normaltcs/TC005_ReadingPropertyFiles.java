package testcases.normaltcs;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
/**
 * for reading a property file we have to use Properties class
 * this file will be resided in java.util package
 * 
 * 
 * @param args
 */
public class TC005_ReadingPropertyFiles {
	public static void main(String[] args) {
		
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("./src/main/resources/objectrepo/Example.properties"));
			System.out.println(prop.getProperty("text1"));
			System.out.println(prop.getProperty("text2"));
			System.out.println(prop.getProperty("text3"));
			System.out.println(prop.getProperty("text4"));
			System.out.println(prop.getProperty("text5"));
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
