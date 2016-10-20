package oops.corejava;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindingAndRemovingDuplicatesInCollection {

	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(233);
		
		list.add(245);
		
		list.add(233);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(233);
		
		list.add(245);
		
		list.add(233);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);			
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(233);
		
		list.add(245);
		
		list.add(233);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(233);
		
		list.add(245);
		
		list.add(233);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(233);
		
		list.add(245);
		
		list.add(233);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);			
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);
		
		list.add(1);
		
		list.add(233);
		
		list.add(245);
		
		list.add(233);
		
		list.add(23);
		
		list.add(34);
		
		list.add(23);

		Set<Integer> set2 = new HashSet<Integer>();
		
		int k = 0 ;
		
		System.out.println(list.get(0) + " List size : " + list.size());
		
		long startTime = new Date().getTime();
		
		// finding duplicates in list
		
		for ( int l = 0; l < list.size(); l++ ) {
			
			set2.add(list.get(l));
			
			if(set2.size() == (l+1-k) ) {
				
				System.out.println("Not a duplicate : " + list.get(l)); }
			
			else { 				
				
				k++;								
				
				System.out.println("Duplicate found : " + list.get(l));
			}
						
		}
		
		long endTime = new Date().getTime();
		
		long executionTime = endTime-startTime;
		
		System.out.println( executionTime);
		
		System.out.println(new Date().getTime());
		
		
		/*  // Removing duplicates from the list
		 
		  Set<Integer> set = new HashSet<Integer>();
		
		set.addAll(list);
		
		for (Integer b : set)
			
			System.out.println(b); 
		*/
		
	}

}
