package oops.corejava;

/**
 * 
 * @author Sunil Nalluru Date 07-10-2016 12:30 PM
 *
 */

public class StaticMethodSubClass extends StaticMethodsSuperClass{
	
	static int getA(){
		
		a = 20; 
		
		return a;
	}
	
	static int getSum( int a, int b, int c){
		
		StaticMethodSubClass.a = a;
		
		StaticMethodSubClass.b = b;
		
		StaticMethodSubClass.c = c;
		
		return a + b + c;
		
	}
 	
}
