package oops.corejava;

/**
 * 
 * @author Sunil Nalluru DATE :  09-10-2016 08:48 PM
 *
 */

public class ManualBoxingAndUnboxing {

	public static void main(String[] args) {

		// Manual Boxing
		
		Integer i = new Integer(10);
		
		System.out.println(i);
		
		//Manual Unboxing
		
		int a = i.intValue();
		
		System.out.println(a);

	}

}
