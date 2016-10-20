package oops.corejava;
/**
 * 
 * @author Sunil Nalluru Date 25-09-2016 10:37 PM
 *
 */


public class SortingArray {

	public static void main(String[] args) {
		
	
		int[] a = { 1 , 4 ,7, 23 ,45 ,2, 11, 34 , 85, 10, 5, 6 };
		
		int temp ;
		
		// bubble sort
		
		for ( int k = 0 ; k < (a.length - 1) ; k++){
			
			for( int l = 0; l < (a.length -k -1 ) ; l++ ){
				
				if( a[l]> a[l+1]){
					
					temp = a [l];
					
					a[l] =  a [l+1];
					
					a[l+1] = temp;
				}
				
				System.out.print( " " +a[l+1]);
			}			
			
			System.out.println(" ");
			
		}
		
		for (int b : a)
			
			System.out.print( " " + b);
	
	}

}
