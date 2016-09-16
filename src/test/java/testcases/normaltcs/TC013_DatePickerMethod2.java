package testcases.normaltcs;

import wrapper.ProjectWrapper;

public class TC013_DatePickerMethod2 extends ProjectWrapper{
	private static int expDay;
	private static int expMonth;
	private static int expYear;
	private static int blockChoice;

	private static void gotoPrevMonth(){
		locateElementByXpath("//div[@class='monthBlock first']/div/a");
		clickOnElement();
		//System.out.println("Previous Month");
	}

	private static void gotoNextMonth(){
		locateElementByXpath("//div[@class='monthBlock last']/div/a");
		clickOnElement();
		//System.out.println("Next Month");
	}

	public static void setDate(int day, String month, int year){

		expDay = day;
		expMonth = getMonthValue(month);
		expYear = year;

		if(processYear() && processMonth()){
				pickDate();
		}
	}

	private static boolean processYear(){
		//System.out.println("inside year");
		locateElementByXpath("(//div[@class='title']/span[2])[1]");
		int block1Year = Integer.parseInt(element.getText());

		locateElementByXpath("(//div[@class='title']/span[2])[2]");
		int block2Year = Integer.parseInt(element.getText());
		
		//System.out.println(expYear+" - "+block1Year+" - "+block2Year);
		
		switch((block1Year == expYear)?((block2Year == expYear)?1:3):(block2Year == expYear?2:4)
				){
				case 1: //System.out.println("year case 1");	
						return true; 

				case 2: //System.out.println("year case 2");			
						gotoNextMonth(); break;

				case 3: //System.out.println("year case 3");	
						gotoPrevMonth(); break;

				case 4: //System.out.println("year case 4");
						monthNavigator(expYear < block1Year && expYear < block2Year);
						processYear();
						return true;
		}
		//System.out.println("Year done");
		return false;
	}

	
	private static void monthNavigator(boolean flag){
		if(flag){
			gotoPrevMonth();
		}else{
			gotoNextMonth();
		}
	}
	private static boolean processMonth(){
		
		//System.out.println("inside month");
		
		locateElementByXpath("(//div[@class='title']/span[1])[1]");
		int block1Month = getMonthValue(element.getText());

		locateElementByXpath("(//div[@class='title']/span[1])[2]");
		int block2Month = getMonthValue(element.getText());

		//System.out.println(expMonth+" - "+block1Month+" - "+block2Month);
		
		switch(
		(block1Month == expMonth)?((block2Month == expMonth)?1:3):(block2Month == expMonth?2:4)
				){
				case 1: //System.out.println("Month case 1");
						return false;

				case 2: //System.out.println("Month case 2");
						blockChoice = 2;
						return true;

				case 3: //System.out.println("Month case 3");
						blockChoice = 1;
						return true;

				case 4: //System.out.println("Month case 4");
						monthNavigator(expMonth < block1Month);
						processMonth();
						return true;
		}
		//System.out.println("Month done");
		return false;
	}

	private static void pickDate(){
		//System.out.println("(//td/a[text()='"+expDay+"'])["+blockChoice+"]");
		locateElementByXpath("(//td/a[text()='"+expDay+"'])["+blockChoice+"]");
		clickOnElement();
		//System.out.println("Date Selected");
	}

	private static int getMonthValue(String month){
		int currentMonth = 0;
		switch(month.toLowerCase()){
		case "january"	: currentMonth = 1; 	break;
		case "february"	: currentMonth = 2;		break;
		case "march"	: currentMonth = 3;		break;
		case "april"	: currentMonth = 4;		break;
		case "may"		: currentMonth = 5;		break;
		case "june"		: currentMonth = 6;		break;
		case "july"		: currentMonth = 7;		break;
		case "august"	: currentMonth = 8;		break;
		case "september": currentMonth = 9;		break;
		case "october"	: currentMonth = 10;	break;
		case "november"	: currentMonth = 11;	break;
		case "december"	: currentMonth = 12;	break;
		}
		return currentMonth;
	}

	public static void main(String args[]){
		launchApp("firefox","https://www.cleartrip.com");

		locateElementByID("DepartDate");
		clickOnElement();

		locateElementByClassName("ctDatePicker");
		if(element.isDisplayed()){
			setDate(25,"August",2017);
			locateElementByXpath("//*[@id='DepartDate']/following::input");
			System.out.println(element.getAttribute("value"));
		}
		
		locateElementByID("DepartDate");
		clickOnElement();

		locateElementByClassName("ctDatePicker");
		if(element.isDisplayed()){
			setDate(25,"August",2018);
			locateElementByXpath("//*[@id='DepartDate']/following::input");
			System.out.println(element.getAttribute("value"));
		}
		
		
		locateElementByID("DepartDate");
		clickOnElement();

		locateElementByClassName("ctDatePicker");
		if(element.isDisplayed()){
			setDate(25,"December",2017);
			locateElementByXpath("//*[@id='DepartDate']/following::input");
			System.out.println(element.getAttribute("value"));
		}

		locateElementByID("DepartDate");
		clickOnElement();

		locateElementByClassName("ctDatePicker");
		if(element.isDisplayed()){
			setDate(25,"August",2016);
			locateElementByXpath("//*[@id='DepartDate']/following::input");
			System.out.println(element.getAttribute("value"));
		}
		
		locateElementByID("DepartDate");
		clickOnElement();

		locateElementByClassName("ctDatePicker");
		if(element.isDisplayed()){
			setDate(25,"December",2016);
			locateElementByXpath("//*[@id='DepartDate']/following::input");
			System.out.println(element.getAttribute("value"));
		}
		
		locateElementByID("DepartDate");
		clickOnElement();

		locateElementByClassName("ctDatePicker");
		if(element.isDisplayed()){
			setDate(5,"january",2017);
			locateElementByXpath("//*[@id='DepartDate']/following::input");
			System.out.println(element.getAttribute("value"));
		}

				closeTheBrowser();

	}
}