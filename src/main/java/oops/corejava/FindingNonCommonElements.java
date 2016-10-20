package oops.corejava;

public class FindingNonCommonElements {

	public static void main(String[] args) {
		
		int[] a = { 1 , 2,3,11, 4,5,6 , 7 , 9 }, b = { 1, 3, 2, 5, 6, 9, 15};
		
		boolean found = false;
		
		for( int i = 0 ; i < a.length; i++){
		
		k: for( int j = 0; j < b.length; j++){
		
		if(a[i]  == b[j]){
			
			found = true;
			
			  break k;
				}

			}
		
		if(found == false)
		
			System.out.println("Non common element " +a[i]);
		
		if(found == true)
		
			System.out.println("Common element  " +a[i]);
		
		
		found = false;
		
		}
		
		String t = "add";
		
		System.out.println(t.hashCode());
		
		

	}
}