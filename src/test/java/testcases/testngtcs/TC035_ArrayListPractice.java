package testcases.testngtcs;

import java.util.ArrayList;

import org.testng.annotations.Test;

public class TC035_ArrayListPractice  {
	
	
	private ArrayList<String> arrayList;

	@Test(priority = -1,groups={"JavaCollections","JavaHashCollections"})
	public void createArrayList() {
		arrayList = new ArrayList<String>();
	}

	@Test(priority = 3,groups={"JavaCollections"})
	public void addData() {
		arrayList.add("first");
		arrayList.add("Second");
		arrayList.add("third");
	}

	@Test(priority = 4,groups={"JavaCollections","JavaHashCollections"})
	public void printList() {
		for (String string : arrayList) {
			System.out.println(string);
		}
	}
}
