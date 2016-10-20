package oops.corejava;

public class FindingSecondBiggestInArray {

	public static void main(String[] args) {
		
		int[] a = { 1 , 4 ,7, 23 ,45 ,2, 11, 34 , 85, 10, 5, 6 };
		
		int temp ;
		
		// bubble sort
		
		for ( int k = 0 ; k < 2 ; k++){
			
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
				
		System.out.println(a[a.length-2]);
	}

}
