package oops.corejava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 
 * @author Sunil Nalluru Date 22-09-2016 10:27 PM
 *
 */
public class MapKeyOverriding {

	public static void main(String[] args) {
	
		List<Integer> list = new ArrayList<Integer>();
		
		list.add(2);		
		list.add(3);
		list.add(4);		
		list.add(5);
		
		List<Integer> list2 = list;
		
		List<Integer> list3 = new ArrayList<Integer>();
		
		list3.addAll(list);
		
		list.remove(1);
		
		list3.add(45);
		
		// list3.remove(1);
		
		System.out.println("List 3");
		
		for(Integer i : list3)
			System.out.println(i);
		
		
		System.out.println("List 1");
		
		for(Integer i: list)
			
			System.out.println(i);

		System.out.println("List 2");
		
		for(Integer i: list2)
			
			System.out.println(i);
	

		
		
		/*Map<String, String> map = new HashMap<String, String>();

		map.put("a", "Hello");

		map.put("a", "Override");
		
		map.put(null, "Using null key");
		
		map.put("b" , null);

		System.out.println(map.get("a") +" : "+ map.get(null) + " : " + map.get("b"));

		Properties properties = new Properties();

		properties.put("a", "Hello");

		properties.put("a", "Overide");

		System.out.println(properties.getProperty("a"));

*/	}

}
