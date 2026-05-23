package LinkedListCollection;

import java.util.LinkedList;

public class Introduction {

	public static void main(String[] args) {

		LinkedList<Integer>a=new LinkedList<>();
		a.add(2);
		a.add(3);
		a.add(0, 1);
		System.out.println(a.get(0));
		System.out.println(a.size());
	}

}
