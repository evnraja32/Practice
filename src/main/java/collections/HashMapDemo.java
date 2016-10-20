package collections;

import java.util.HashMap;

public class HashMapDemo {

	public static void main(String[] args) {
		HashMap<Character, Integer> hmDemo = new HashMap<Character, Integer>();
		String str = "Naga";
		
		for(char c : str.toCharArray()){
			if(hmDemo.containsKey(c)){
				hmDemo.put(c, hmDemo.get(c)+1);
			}else{
				hmDemo.put(c, 1);
			}
		}
		
		System.out.println(hmDemo.size());
		for(char c : str.toCharArray()){
			System.out.println(hmDemo.get(c));
		}
		
		
	}

}
