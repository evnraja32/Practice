package oops.corejava;

//This program contains an error and will not compile.

class ThrowsDemo {

/*	static void throwOne() throws IllegalAccessException {
		
		System.out.println("Inside throwOne.");
		
		throw new IllegalAccessException("demo");
	}
*/
	static void throwOne() throws IllegalAccessException {
		
		System.out.println("Inside throwOne.");
		
		try {
			
			throw new IllegalAccessException("demo");
			
		} 
		
		finally {

			System.out.println("in finally");
		}
			
			/*catch (IllegalAccessException e) {
		}
			// TODO Auto-generated catch block

		System.out.println(e.getMessage());
			
			// e.printStackTrace();
		}
*/	}

	
	public static void main(String args[])  {
	
		try {
			
		throwOne();
	}
		catch(IllegalAccessException e){
			
			System.out.println(e.getMessage());
		}

		
		// throwOne();		
	
	}

}