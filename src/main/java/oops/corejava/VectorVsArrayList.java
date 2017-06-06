package pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Vector;

public class VectorVsArrayList {
	public static void main(String[] args) {
			vecM();
			hasS();
	}
	
	public static void vecM(){
		Vector<String> v = new Vector<String>();

		long st = System.currentTimeMillis();
		for (int i = 1; i <= 300000; i++) {
			v.add("aslkfjsdlkfjskdjfkajf");
		}
		long en = System.currentTimeMillis();
		long ou = en-st;
		System.out.println(v.size());
		System.out.println("Vector :"+ou);
			
	}
	
	public static void hasS(){
		ArrayList<String> v = new ArrayList<String>();

		long st = System.currentTimeMillis();
		for (int i = 1; i <= 300000; i++) {
			v.add("aslkfjsdlkfjskdjfkajf");
		}
		long en = System.currentTimeMillis();
		long ou = en-st;
		System.out.println(v.size());
		System.out.println("ArrayList :"+ou);
			
	}
}
