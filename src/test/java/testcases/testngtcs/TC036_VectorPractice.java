package testcases.testngtcs;

import java.util.Vector;

import org.testng.annotations.Test;

public class TC036_VectorPractice {
	private Vector<String> vector;

	@Test(priority = -1)
	public void createvector() {
		vector = new Vector<String>();
	}

	@Test(priority = 3)
	public void addData() {
		vector.add("first");
		vector.add("Second");
		vector.add("third");
	}

	@Test(priority = 4)
	public void printList() {
		for (String string : vector) {
			System.out.println(string);
		}
	}
}
