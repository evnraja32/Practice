package oops.corejava;

public class StringConcatExp {

	public static void main(String[] args) {
		
		String s = "abc";
		
		s.concat("def");
		
		System.out.println(s);
		
		s = s.concat("def");
		
		s = s + "ghi";
		
		System.out.println(s);
		
		String s2 = s.concat("def");
		
		System.out.println(s2);
		
		String s3 = new String("kgh");
		
		s3 = s3.concat("hfjf");
		
		System.out.println(s3);
		
		s3 = s3.substring(2);
		
		System.out.println(s3);
		
		s3 = s3.replace('h', 'n');
		
		System.out.println(s3);
		
		s3 = "  " + s3 + " ";
		
		System.out.println(s3);
		
		s3 =  s3.trim();
		
		System.out.println(s3);			

	}

}