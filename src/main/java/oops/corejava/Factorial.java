package oops.corejava;

public class Factorial {

	public static void main(String[] args) {

		// Scanner scanner = new Scanner ( System.in);
		
		// int fact = scanner.nextInt();
		
		int factorial =1 , fact = 6;

		for( int i =1; i <= fact; i++)
			
			factorial = factorial* i;
		
		System.out.println("factorila" + factorial);
		
		int fact2 = fact(fact);
		
		System.out.println(fact2);		
		
	}

	private static int fact(int n) {

		int b = 1;
		
		// System.out.println("before comparision : " + n + " : " + b);
		
		if(n>1)
			
			b = n * fact(n-1);
		
		 // System.out.println("after comparision : " + n + " : " + b);	
		
		return b;
	}
	

}
