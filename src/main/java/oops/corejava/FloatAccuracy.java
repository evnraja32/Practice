package oops.corejava;

public class FloatAccuracy {

	public static void main(String[] args) {
		
		double a[ ] = {  7  , 7 , 7 , 7,7 ,7,7,7 };
		
		double sum = 0;
		
		for ( int  k = 0; k < a.length; k ++)
			sum = sum + a[k];
		
		double b= sum/6;
		
		System.out.println(b);

	}

}
