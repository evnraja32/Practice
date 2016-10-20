package oops.corejava;

// Demonstrate finally.

class FinallyDemo {
	
	// Throw an exception out of the method.
	
	static void procA() {
	
		// throw new RuntimeException("demo");
		
		try {
			System.out.println("inside procA");
			throw new RuntimeException("demo");
		}		
			finally {
			System.out.println("procA's finally");
		}
	}

	// Return from within a try block.
	static void procB() {
		try {
			System.out.println("inside procB");
			return;
		} finally {
			System.out.println("procB's finally");
		}
	}

	// Return from within a try block.

	static int procBC() {
		try {
			System.out.println("inside procBC");
			return 1;
		}

		finally {

			System.out.println("procBC's finally");
			return 2;
		}
	}

	// Execute a try block normally.
	static void procC() {
		try {
			System.out.println("inside procC");
		} finally {
			System.out.println("procC's finally");
		}
	}
	
	public static void main(String args[]) {
		
		try {
			int zz = 1/0; 
			
		}
		
		/*catch(ArithmeticException e){
			System.out.println(e.getMessage());
		}
		*/
		finally{
			System.out.println("In finally Divide By zero");
		}			
		
		//		procA();

		try {
				procA();
			
		} catch (Exception e) {
			
			System.out.println("Exception caught");
		} 
		finally {
		
			System.out.println("main finally");
		}
		
		procB();
		procC();
		
		System.out.println(procBC());

		int b = procBC();

		System.out.println(b);

		// System.out.println(procBC());

	}
}