package oops.corejava;

/**
 *
 * @author Sunil Nalluru Date 07-10-2016 10:30 AM
 *
 */

public class StaticMethodsSuperClass {
	
	static {
		
	System.out.println("Inside static block");
	
	}
	
		static int a, b, c;
		
		static int getA(){
			
			a = a + 10;
			
			return a;
		}				
		
		static int getSum(){
			
			return a+b;
		}
		
		
		static int getSum( int a, int b, int c){
			
			// this.a = a;
			
			StaticMethodsSuperClass.a = a; 
			
			StaticMethodsSuperClass.b = b;
			
			StaticMethodsSuperClass.c = c;			
			
			return a + b + c;
		}

}
