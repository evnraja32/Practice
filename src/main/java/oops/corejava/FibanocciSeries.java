package oops.corejava;


/**
 * 
 * @author Sunil Nalluru Date 22-09-2016 10:27 PM
 *
 */
public class FibanocciSeries {

	public static void main(String[] args) {
		
		
		int a[]  = new int[10];
		
			a[0] =0 ; a[1] = 1;
		
		for( int k =2; k < a.length; k++) 
			
		a[k] = a[k-1] + a [k-2];
		
		
		for( int l : a)
			
		System.out.print(" " + l);
	}
}