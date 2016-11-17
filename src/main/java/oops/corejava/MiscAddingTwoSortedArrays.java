package oops.corejava;

public class MiscAddingTwoSortedArrays {

	public static void main(String[] args) {
		
		int[] a = { 1, 4, 11, 13, 14, 15, 16, 17, 18, 19, 20, 21, 27, 28, 30 , 67 ,100};
		
		int b[] = { 2, 4, 7, 15, 16, 18, 20, 25, 32, 34, 36, 38, 39, 55, 56, 57, 67,
				     0, 0 , 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 , 0 , 0 , 0};
		
		/*System.out.println(a.length);
		System.out.println(b.length);*/
		for( int m = (a.length-1); m >= 0 ; m--){
			
			if( a[m]> b[m] && a[m] > b[m*2+1] && b[m*2] > b[m]) {
			
			b[m*2+1] = a[m];
			
			b[m*2] = b[m]; 
			
			}
			
			else if (a[m] < b[m] && b[m] < b[m*2+1]){
				
				b[m*2+1] = b[m];
				
				b[m*2] = a[m];
				
			}							
			
		}
		
		System.out.println(b.length);
		
		for(int n : b)
			
			System.out.print( n +" :");
		

	}

}
