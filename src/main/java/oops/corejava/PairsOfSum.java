package oops.corejava;

import java.util.LinkedHashMap;
import java.util.Map;

public class PairsOfSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int givenNumber = 40;
		
		int[] a = { 1, 4, 45, 5, 39, 36 , 35 , 12 , 28};
		
		Map<Integer,Integer> map = new LinkedHashMap<Integer,Integer>();
		
		for (int i = 0; i < a.length; i++){
			
			for ( int k = 0; k < a.length; k ++){
				
				if( ( i!=j && a[i]+a[k]) == givenNumber){
					
					map.put(a[i], a[k]);
				}
				
				
			}
			
		}
		
		for( Map.Entry<Integer,Integer> entry : map.entrySet())
			
			System.out.println(entry.getKey() + " : " + entry.getValue());
		
		
	}

}
