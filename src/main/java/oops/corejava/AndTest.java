package oops.corejava;

public class AndTest {

	public static void main(String[] args) {
		
		int a = 10, b = 0;
		
		// Observe here -- No error / No exception-- short circuit operators
		
		if(a==10 || 5/0==0)
			
			System.out.println("Inside if cond");
	
	if(a!=10 && 5/0==0)
		
		System.out.println("Inside if cond");

}

}
