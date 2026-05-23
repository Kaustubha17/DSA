package PriorityQueues;
import java.util.Collections;
import java.util.PriorityQueue;
public class KthLargest {

	public static int kthLargest( int[] input, int k) {

		//        PriorityQueue<Integer>pq=new PriorityQueue<>();
		PriorityQueue<Integer>pq=new PriorityQueue<>();

		for(int i=0;i<k;i++) {
			pq.add(input[i]);
		}
		for(int i=k;i<input.length;i++) {
			if(pq.peek()>input[i]) {
				pq.poll();
				pq.add(input[i]);
			}
		}
		for(int i:pq)
			System.out.print(i+" ");
		int ans=pq.peek();
		while(k!=1){
			ans=pq.poll();
			k--;
		}

		return ans;
	}

	public static void main(String[] args) {
		int arr[]= {87 ,79 ,67 ,15 ,68 ,68 ,58 ,89 ,85 ,30};
		int k=10;
		System.out.println(kthLargest(arr, k));
	}

}
