package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class QueueCollections {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//Queue is an interface but LinkedList implments it in collection
		Queue<Integer>q=new LinkedList<>();
		q.add(10);
		q.add(2);
		q.peek();
		System.out.println(q.peek());
		System.out.println(q.size());
		System.out.println(q.poll());
		 q=new LinkedList<Integer>();
	        for(int i=1;i<5;i++)
	        {
	            q.add(10+i);
	        }
	        System.out.print(q.poll()+" "+q.size());
	}

}
