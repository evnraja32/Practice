package oops.corejava;

public class BinarySearch {

	public static void main(String[] args) {
		
		 float f = 3.2f;
		 
		 int a = (int) f;
		 
		 int value = 11;
		 
		 System.out.println(a);
		
		 int[] b = { 1,2,3,5,6,7,8,9,11,56,67,785,890, 891, 892};
		 
		 int start=0, end = b.length-1, middle = (start + end)/2 , position =-1;
		 
		 System.out.println(" start = " + start + " Middel = " + middle + "end = " + end);
		 
		 while ( start <= end){
			 
			 if ( value == b[middle]){
				 
				 position = middle;
				 
				 break;
		
			 }
			 
			 else if (value < b[middle]){
				 
				 end = middle-1;
			
			 }
			 
			 else start = middle+1;
			 
			 middle = (start + end)/2;
			 
			 System.out.println(" start = " + start + " Middel = " + middle + "end = " + end);	 
			 
		 }
		 
		 System.out.println("Foind at position + " + position);

	}

}
