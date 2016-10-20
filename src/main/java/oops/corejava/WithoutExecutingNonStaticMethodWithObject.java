package oops.corejava;

/**
 * @author Sunil Nalluru Date 10-09-2016 
 * 
 */

//  Desctption  

public class WithoutExecutingNonStaticMethodWithObject {
	
	void ajay(){
		System.out.println("hello Ajay");
	}

	static{
		System.out.println("adad");
	}
	
	public WithoutExecutingNonStaticMethodWithObject() {
	 
		System.out.println("Iside contructor");
	}
	
    {
    	ajay();
	}
	
	public static void main(String[] args) {		
	
	WithoutExecutingNonStaticMethodWithObject w = new WithoutExecutingNonStaticMethodWithObject();		

	}

}
