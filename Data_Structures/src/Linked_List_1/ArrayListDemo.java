package Linked_List_1;
import java.util.ArrayList;
public class ArrayListDemo {

	public static ArrayList<Integer> removeConsecutiveDuplicates(int arr[]){
		ArrayList<Integer>s=new ArrayList<>();
	s.add(arr[0]);
	for(int i=1;i<arr.length;i++) {
		if(arr[i]!=arr[i-1])
			s.add(arr[i]);
	}
	
	
		return s;
	}
	
	public static void main(String[] args) {

		ArrayList<Integer> arr=new ArrayList<>();
		arr.add(1);
		arr.add(10);
		arr.add(1, 20);
		System.out.println(arr.size());
		System.out.println(arr.get(1));
		System.out.println(arr.get(2));
		System.out.println(arr.size());
		System.out.println(arr.set(1,30));
		System.out.println(arr.get(1));
		System.out.println("Testing remove");
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		arr.remove(0);
		System.out.println(arr.get(0));
		System.out.println(arr.get(1));
		System.out.println("iterate over array list");
		for(int i=0;i<arr.size();i++)
			System.out.println(arr.get(i));
		System.out.println("Enhanced for loop");
		for(int i:arr)
			System.out.println(i);
		
//		Remove duplicates from Array
		int duplicates[]= {10,10,20,20,20,30,10};
		ArrayList<Integer>result=removeConsecutiveDuplicates(duplicates);
		for(int i:result) {
			System.out.print(i+" ");
		}
		
		
	}

}
