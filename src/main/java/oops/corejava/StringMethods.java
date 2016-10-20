package oops.corejava;

public class StringMethods {

	public static void main(String[] args) {
	
		
		int[] a = { 1,2,5,6,7, 8,9, 10}, b = { 4, 5,6,7,10,11,23,13}, intersection = new int [a.length];
		
		int intersectionIndex = 0;
				
		for ( int i = 0; i < a.length ;  i++){
			
			for (int j = 0; j < b.length; j++){
			
				if( a[i] == b [j])
				{
					intersection[intersectionIndex] = a [i];
					
					intersectionIndex++;
				}
			
			}
		}
		
		for (int k = 0 ; k <(intersectionIndex); k++ ){
			
			System.out.println(intersection[k]);
		}

	}
}
