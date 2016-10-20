package oops.corejava;

/**
 * 
 * @author Sunil Nalluru DATE 18-10-2016 09-11 PM 
 *
 */

public class ExpWithConstructor {

	/*final ExpWithConstructor(){   // final, static are not allowed on constructor
	
		k = 10;
		
		System.out.println("In constructor");
	}
	*/

	static int k;
	
	ExpWithConstructor(int j) {
		
		k = j;
		
	System.out.println("Inside constructor");
		
	}
	
	public static void main(String args[]){
		
		
		ExpWithConstructor exc = new ExpWithConstructor(10);
		
		System.out.println(k);		
		
	}	
}
