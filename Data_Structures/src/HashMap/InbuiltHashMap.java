package HashMap;

import java.util.HashMap;
import java.util.Set;

public class InbuiltHashMap {

	public static void main(String[] args) {

		HashMap<String, Integer>map=new HashMap<>();

		map.put("abc", 123);
		map.put("hello", 234);

		if(map.containsKey("abc")) {
			System.out.println("map has abc");
		}
		/*
		
		int v=map.get("abc");
		System.out.println(v);
		
	System.out.println(map.get("d"));

	map.remove("abc");
	System.out.println(map.get("abc"));
		 */
		
		
		//	iterate
		Set<String>keys=map.keySet();
		map.put("abc",123);

		for(String s:keys) {
			System.out.println(s);

		}

	}

}
