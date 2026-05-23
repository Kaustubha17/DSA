package HashMap;

import java.util.HashMap;

public class ArrayIntersection {

	public static void intersection(int arr1[],int arr2[]) {
		HashMap<Integer, Integer>a=new HashMap<>();
		for(int i=0;i<arr1.length;i++) {
			if(a.containsKey(arr1[i])) {
				a.put(arr1[i], a.get(arr1[i])+1);
			}
			else {
				a.put(arr1[i], 1);
			}
		}
		for(int i=0;i<arr2.length;i++) {
			if(a.containsKey(arr2[i])) {
				int freq=a.get(arr2[i]);
				if(freq>0) {
					System.out.println(arr2[i]+" ");
					a.put(arr2[i], freq-1);
				}
			}
		}
	}
	
	public static void main(String[] args) {
int arr1[]= {1,2,3,4,5,6,7,2};
int arr2[]= {1,2,2,5,9};
intersection(arr1, arr2);
		
	}

}
