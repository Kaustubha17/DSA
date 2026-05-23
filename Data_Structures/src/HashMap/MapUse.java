package HashMap;

public class MapUse {

	public static void main(String[] args) {

		Map<String, Integer>a=new Map<>();
		a.insert("abc", 123);
		System.out.println(a.getValue("abc"));
		for(int i=0;i<10;i++)
		{a.insert("abc"+i, i);
		System.out.println(a.loadFactor());
		}
	}

}
