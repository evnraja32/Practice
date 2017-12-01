package oops.corejava;

public class StringMethods {

	public static void main(String[] args) {
		String str = new String();
		str = "Original String";

		System.out.println("Char At index 7:" + str.charAt(7));

		int result = str.compareTo("Another string");
		System.out.println("compareTo : " + result);

		result = str.compareToIgnoreCase("String");
		System.out.println("compareToIgnoreCase : " + result);

		boolean flag = str.equals("Another String");
		System.out.println("Equals method Result Compared with \"Another String\" : " + flag);

		flag = str.equals("Original String");
		System.out.println("Equals method Result Compared with \"Original String\" : " + flag);

		boolean flag2 = str.equalsIgnoreCase("Another String");
		System.out.println("equalsIgnoreCase method Result Compared with \"Another String\" : " + flag2);

		flag2 = str.equals("Original String");
		System.out.println("equalsIgnoreCase method Result Compared with \"Original String\" : " + flag2);
		
		System.out.println("String Legth : "+str.length());
		
		System.out.println("After Replacing String length reduced by : "+(str.length()-(str.replace("i", "").length())));

		String[] strSplit = str.split(" ");
		System.out.println("Length after split : "+strSplit.length);
		
		
		char[] strToCharCovertion = str.toCharArray();
		System.out.println("Lenth of Char Array : "+strToCharCovertion);
		
		System.out.println("To Lower Case: "+str.toLowerCase());
		
		System.out.println("To Upper Case : "+str.toUpperCase());
		
		
		
	}

}
