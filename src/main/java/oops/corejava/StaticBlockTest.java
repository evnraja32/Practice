package oops.corejava;

public class StaticBlockTest {

	static{
		System.out.println("Static Block in StaticBlockTest");
	}
	
	public static void block(){
		System.out.println("Inside another class");
	}
	
}
