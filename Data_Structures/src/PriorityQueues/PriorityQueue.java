package PriorityQueues;

public class PriorityQueue {

	public static void main(String[] args) throws PriorityQueueException {

		Priority_Queue<String>pq=new Priority_Queue<>();
		pq.insert("abc", 0);
		pq.insert("d", 1);
		pq.insert("e", 2);
		pq.insert("f", 3);
		pq.insert("v", 4);
		pq.insert("sdf", 7);
		System.out.println(pq.getMin());
		
		
		
		
	}

}
