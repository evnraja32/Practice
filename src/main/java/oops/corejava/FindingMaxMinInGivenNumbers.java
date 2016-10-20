package oops.corejava;

public class FindingMaxMinInGivenNumbers {

	public static void main(String[] args) {
	
		int[] a = { 12, 14, 5, 6, 3, 4, 2, 38,1,0, 25, 8, 9 , 99, 101, 100, -1};
		
		int max = a[0], min = a[0];
		
		// Way one
		
		for(int k = 1; k < (a.length); k++){
			
			if(max < a[k] )
				
				max = a[k];	
			
			 if (a[k] < min)
				
				min = a[k];
			
		}

		System.out.println("Max : " + max + " Min: " + min);
		
		
	}

}
