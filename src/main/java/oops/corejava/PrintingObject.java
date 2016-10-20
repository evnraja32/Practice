package oops.corejava;

public class PrintingObject {

	int a, b;

	PrintingObject() {

		a = 10;
		b = 100;
	}

	public static void main(String[] args) {

		PrintingObject p1 = new PrintingObject();

		// PrintingObject printObject;

		System.out.println(p1);

		// output of object, object.toString() method is same in Sysout
		
		Object o = p1;
		
		System.out.println(o.getClass().getName());
		
		System.out.println(o.getClass());

		System.out.println(p1.toString());
		
		System.out.println(p1.getClass().getName()+ "@" +  Integer.toHexString(p1.hashCode()));
		
		// Hash code is different for every object

		System.out.println(p1.hashCode());

		PrintingObject p2 = new PrintingObject();

		// PrintingObject p2 = p1;
		
		System.out.println(p2);

		System.out.println(p2.hashCode());				

		if (p2.equals(p1)) 

			System.out.println("equal"); 

		if (p2 == p1) 

			System.out.println("=="); 

		if (p1.a == p2.a && p1.b == p2.b) 

			System.out.println("Content is same"); 

		// 
		
		p1 = p2;
		
		System.out.println( p1.hashCode() + " " + p2.hashCode());		
		
		if (p2.equals(p1))

			System.out.println("equal");

		if (p2 == p1)

			System.out.println("=");
		

		// String s = String.valueOf("31168322");

		// System.out.println(s);

	}

}
