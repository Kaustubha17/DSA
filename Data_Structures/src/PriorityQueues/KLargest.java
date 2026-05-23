package PriorityQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargest {

	public static void downHeapify(ArrayList<Integer>arr){


		int leafIndex=(arr.size()/2 )-1;
		for(int i=leafIndex;i>=0;i--) {
			int parentIndex=i;
			int lChildIndex=2*parentIndex+1;
			int rChildIndex=2*parentIndex+2;
			while(lChildIndex<arr.size()){
				int minIndex=parentIndex;
				if(arr.get(minIndex)>arr.get(lChildIndex))
					minIndex=lChildIndex;
				if(rChildIndex<arr.size() && arr.get(minIndex)>arr.get(rChildIndex))
					minIndex=rChildIndex;
				if(minIndex==parentIndex)
					break;

				int temp=arr.get(parentIndex);
				arr.set(parentIndex,arr.get(minIndex));
				arr.set(minIndex,temp);

				parentIndex=minIndex;
				lChildIndex=2*parentIndex+1;
				rChildIndex=2*parentIndex+2;

			}
		}
		return;
	}

	public static ArrayList<Integer> kLargest(int input[], int k) {

		ArrayList<Integer>ans=new ArrayList<>();

		for(int i=0;i<k;i++){
			ans.add(input[i]);
		}

		downHeapify(ans);

		for(int i=k;i<input.length;i++){
			if(ans.get(0)<input[i])
			{
				ans.set(0,input[i]);
				downHeapify(ans);
			}
		}

		return ans;
	}

	public static ArrayList<Integer> kSmallest(int input[], int k){
		ArrayList<Integer>ans=new ArrayList<>();
		PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
		
		
		for(int i=0;i<k;i++) {
			pq.add(input[i]);
		}
		for(int i=k;i<input.length;i++) {
			if(pq.peek()>input[i]) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		while(!pq.isEmpty()) {
			ans.add(pq.poll());
		}
		
		return ans;
		
	}
	public static void main(String[] args) {
		ArrayList<Integer>arr= new ArrayList<>();
		arr.add(910687 );
		/*
-566801 515816 477303 -347664 138793 
-444484 914032 -569756 52382 53985 -927030 
803021 62817 -723090 -964706 -351117 
-93842 -678124 624263 
		 */

		arr.add(-566801);
		arr.add(515816);
		arr.add(477303);
		arr.add(-347664);
		arr.add(138793);
		arr.add(-444484);
		arr.add(914032);

		/*downHeapify(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		*/
		int arr2[]= {-566801 ,515816, 477303 ,-347664, 138793, 
				-444484, 914032, -569756, 52382, 53985, -927030 ,
				803021, 62817, -723090 ,-964706, -351117, 
				-93842 ,-678124, 624263};
		int k=5;
	ArrayList<Integer>ans=	kSmallest(arr2, k);
		for(int i:ans) {
			System.out.println(i+" ");
		}
		
	}

}
