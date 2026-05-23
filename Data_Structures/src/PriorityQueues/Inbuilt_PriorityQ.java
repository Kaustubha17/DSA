package PriorityQueues;

import java.util.PriorityQueue;

public class Inbuilt_PriorityQ {

	public static void main(String[] args) {

		PriorityQueue<Integer>pq=new PriorityQueue<>();
		pq.add(12);
		pq.add(23);
		pq.add(1);
		pq.add(45);
		System.out.println(pq.peek());
	}

}
