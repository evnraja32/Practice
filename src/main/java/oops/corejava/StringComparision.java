package oops.corejava;

public class StringComparision {

	public static void main(String[] args) {
	
		String s = "abc";
		
		System.out.println(s.hashCode());
		
		String s2 = "abc";
		
		System.out.println(s2.hashCode());
		
		String s3 = new String("abc");
		
		System.out.println(s3.hashCode());
		
		String s4 = new String("abc");
		
		System.out.println(s4.hashCode());
		
		// String constant comparison
		
		if(s.equals(s2))
			
			System.out.println("s equals s2");
		
		if(s == s2)
			
			System.out.println("s  == s2");

		
		// String constant and String Object comparison
		
		if(s.equals(s3))
			
			System.out.println("s equals s3");
		
		if(s == s3)
			
			System.out.println("s  == s3");
 
		// String Object comparison
		
		if(s4.equals(s3))
			
			System.out.println("s4 equals s3");
		
		if(s4 == s3)
			
			System.out.println("s4  == s3");
		
	}

}
