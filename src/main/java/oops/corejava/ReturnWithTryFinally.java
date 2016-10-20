package oops.corejava;

/**
 * 
 * @author Sunil Nalluru Date 22-09-2016 09:30 PM
 *
 */

public class ReturnWithTryFinally {

	
	static int a=40,b;
	
	static int method(){
			
		try{			
			
			b= a/0;
			
			return a=10;
		}
		
		catch(ArithmeticException e){
			
			System.out.println("In catch block" + e.getMessage());
		}
		
		finally{
		System.out.println("In finally block");
		
		return a=20;
		}
	}
		static int method2(){
			
			try {
				b = 42/0;
			return a = 40;
		}
			finally{
				
				System.out.println("In method2 finally block");
				return a=50;
			}
		
	}
	
	
	public static void main(String[] args) {
		
		try{
			System.out.println("In main methd try block");
		}
		
		/*catch(Exception e)
		{
			
		}*/
		
		finally{
			
			
		}
		
		System.out.println(System.lineSeparator());
		
		
	System.out.println(method());
	System.out.println(method2());
		

	}

}
