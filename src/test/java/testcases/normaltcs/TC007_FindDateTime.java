package testcases.normaltcs;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

/**
 * Earlier versions of Java (till Java 7.0) have java.util package classes like Calender,
 * GregorianCalender, Data, TimeZone, etc; however, these classes do not have efficient methods to handle
 * data and time.
 * 
 * Joda-Time:
 * Joda-Time is an API created by joda.org which offers better classes to handle date and time.
 * This API is included into Java 8.0 with the package java.time
 *
 * 
 * Using LocalDate and LocalTime class
 * To display system date and time
 * @author RAJA
 *
 */

public class TC007_FindDateTime {
	public static void main(String[] args) {
		//locaDate.now() gives system date into LocalDate Obj
		LocalDate today = LocalDate.now();
		
		//LocalTime.now() gives system date into LocalTime Obj
		LocalTime time = LocalTime.now();
		
		//java.util.Date old method of finding date
		Date date = new Date();
		
		System.out.println(today);
		System.out.println(time);
		System.out.println(date);
		
	}
}
