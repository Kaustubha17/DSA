package PriorityQueues;

import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class BuyTheTicket {
	public static int buyTicket(int input[], int k) {
		int t=0;
		Queue<Integer>q=new LinkedList<>();
		PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());

		for(int i=0;i<input.length;i++) {
			q.add(i);
			pq.add(input[i]);			
		}
		
		
		while(true) {
		if(input[q.peek()]<pq.peek()) {
			int temp=q.poll();
			q.add(temp);
		}
		
		else if(input[q.peek()]==pq.peek()) {
			t++;
			if(q.peek()==k)
				break;
			else {
				q.poll();
				pq.poll();
			}
		}
		
			
		}
		
		
		return t;
	}
	public static void main(String[] args) {
		int arr[]= {2,3,2,2,4};
		int k=3;
//		System.out.println(buyTicket(arr, k));
		

	}

}
