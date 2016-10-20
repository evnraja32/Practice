package oops.corejava;

/**
 * 
 * @author Sunil Nalluru 	Date 17-10-2016 10:09 PM 
 *
 */

public interface ExpWithInterface {
		
	public static final int m = 10;
	
		static int c = 0 ;
	
		int a =10;
		
		// a = 20;   // a =20 is illegal
		
		String t = "a";
		
		// t= t+"abc";
		
	   int add(int j, int k); 
	  
	   abstract int sub(int l, int j);
	   
	   default String getString() {
		   return "Default String";
		   }
		
}

