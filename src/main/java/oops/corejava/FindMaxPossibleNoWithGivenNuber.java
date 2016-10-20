package oops.corejava;

public class FindMaxPossibleNoWithGivenNuber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int a = 1238941787;
		
		String str = String.valueOf(a);
		
		System.out.println(str);
		
		char[] ch =  str.toCharArray();
		
		char min = ch[0];
		
		for (int i = 0; i < ch.length ; i++){
			
			for (int j = 0; j < (ch.length - 1 - i); j++){
				
				if(ch[j] < ch [j+1]){
					
					min = ch [j];
						
				ch[j] = ch[j+1];
				
				ch[j+1] = min;
					
				}
			}										
			
		} 
		
		System.out.println("Max possible no");
		
		for ( int k = 0 ; k < ch.length ; k++ )
			
			System.out.print(ch[k]);
		
	
/*			max = ch[0];
 
 			for (int i = 0; i < ch.length ; i++){
			
			for (int j = 0; j < (ch.length - 1 - i); j++){
				
				if(ch[j] > ch [j+1]){
					
					max = ch [j];
						
				ch[j] = ch[j+1];
				
				ch[j+1] = max;
					
				}
			}										
			
		} 
		
		for ( int k = 0 ; k < ch.length ; k++ )
			
			System.out.print(ch[ch.length -1 - k]);*/
		
		
		
		/*int maxIndex = 0;
		
		char[] maxArray = new char[str.length()];
		
		for (int i = 0; i < ch.length ; i++){
			
			for (int j = 0; j < ch.length; j++){
				
				if(max < ch [j]){
					
					max = ch [j];
					
					maxIndex = j;
					
					
				}
			}			
			
			System.out.println("Max : " + max + " Max Index :  " + maxIndex);
			
			maxArray[i]= max;
			
			ch[maxIndex] = 0;
			
			max =0;
		} 
		
		for ( int k = 0 ; k < maxArray.length ; k++ ){
			System.out.print(maxArray[k]);
		}
			
*/
		
		/*  int a = 123894;
		
			String str = String.valueOf(a);
		
			System.out.println(str);
		
		int[] ch =  { 1 , 9,2,1, 6, 8, 2, 4 ,7 , 6,2 };
		
		int max =0;
		
		int maxIndex = 0;
		
		int[] maxArray = new int[ch.length];
		
		for (int i = 0; i < ch.length ; i++){
			
			for (int j = 0; j < ch.length; j++){
				
				if(max < ch [j]){
					
					max = ch [j];
					
					maxIndex = j;
					
					System.out.println("Max = :" + max +  " Max Index : "+ maxIndex);
					
				}
			}			
			
			System.out.println("============== ");
			
			System.out.println("Max = :" + max +  " Max Index : "+ maxIndex);			
			
			maxArray[i]= max;
			
			ch[maxIndex] = 0;
			
			max = 0;
			
			System.out.println("------------------- ");
		} 
		
		for ( int k = 0 ; k < maxArray.length ; k++ ){
			System.out.print(maxArray[k]);
		}
	*/		
	
	}
	
}


