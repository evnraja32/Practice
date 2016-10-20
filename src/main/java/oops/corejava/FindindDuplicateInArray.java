package oops.corejava;

import java.util.Date;

public class FindindDuplicateInArray {

	public static void main(String[] args) {
		
		int[] a = { 1 ,5 , 10 , 11, 13, 14, 15, 16, 10 , 1 ,5 , 10 , 11, 13, 14, 15, 16, 10 , 
				
				1 ,5 , 10 , 11, 13, 14, 15, 16, 10 , 1 ,5 , 10 , 11, 13, 14, 15, 16, 10, 
				
				1 ,5 , 10 , 11, 13, 14, 15, 16, 10, 1 ,5 , 10 , 11, 13, 14, 15, 16, 10 };
						
/*		long startTime = new Date().getTime();
		
		// Exactly only one duplicate
				
		a: for ( int k = 0; k < a.length; k++){
			
			for ( int l=0; l < a.length; l++){
				
				if( k!=l && a[k] == a[l]){					
					
					System.out.println(a[k]);
					
					break a;
				}
				
			}
			
			}
		
		long endTime = new Date().getTime();
		
		System.out.println("Time elapsed :" + (endTime- startTime));		
*/		

		
		long startTime = new Date().getTime();  
		
		 for ( int k = 0; k < a.length; k++){
			
			for ( int l=0; l < a.length; l++){
				
				if( k!=l && a[k] == a[l]){					
					
					System.out.println(a[k]);
								
				}				
			 }
		}
		 
		 long endTime = new Date().getTime();
		 
		 long timeElapsed = endTime - startTime;

		System.out.println("Time elapsed " + timeElapsed);
	}

}
