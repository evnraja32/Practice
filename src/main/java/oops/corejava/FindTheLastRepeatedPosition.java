package oops.corejava;

public class FindTheLastRepeatedPosition {

	public static void main(String[] args) {

		int a[] = { 1, 3, 4 , 2, 1, 4, 5, 3, 2, 1, 6, 7, 2, 8, 1, 2 , 3,9 ,1, 10, 11};				
		
	c:	for (int k = (a.length -1) ; k >= 0; k --){
			
			for (int l =0; l < a.length; l++){
			
			if( k != l && a[k] == a[l] ) {				
			
			System.out.println(a.length + " " +(k+1));
			
			break c;
			}
						
			}
		}		
		
		/* 
			int[] numberArray = { 1 , 2, 3, 4 };
		
		int max = 0, index =0;
		
		int[] repeatedHighestIndex = new int[numberArray.length];
		
		
		for (int k = 0; k < numberArray.length; k++){
			
			for (int l =0; l < a.length; l++){
			
			if( numberArray[k] == a[l] )				
			
			repeatedHighestIndex[k] = l;
						
			}
		}
		
		for(int j : repeatedHighestIndex)
			
			System.out.println(j);
		
	
		for( int m : repeatedHighestIndex)
			
		{	if( max < m)
				
				max = m;

		}
		
		System.out.println(max);
*/		
	}
	

}
