
public class DynamicArrayUse {

	public static void main(String[] args) {
		DynamicArray a=new DynamicArray();
		for(int i=0;i<100;i++) {
			a.add(i);
		}
		System.out.println(a.size());
		System.out.println(a.get(99));

	}

}
