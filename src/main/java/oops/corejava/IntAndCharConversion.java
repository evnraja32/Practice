package oops.corejava;

public class IntAndCharConversion {

	public static void main(String[] args) {

		char a[] = new char[10];
	
		
		for(int i = 0; i < 10; i++)
			a[i] = 'i';
		
		System.out.println("Printing in char mode");

		for(char b : a)
			System.out.print(b);
		
		for( int c: a)
			System.out.println(c);

/*		// int cannot directly assigned vthout literal 
		
		for(int i = 0; i < 10; i++)
			a[i] = i;
		
		System.out.println("Printing in char mode");

		for(char b : a)
			System.out.print(b);
		
		for( int c: a)
			System.out.print(c);
*/

	}

}
