package Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {
	public static void reverseQueue(Queue<Integer> input) {
		if(input.peek()==null)
			return;

		int newRear=input.poll();
		reverseQueue(input);
		input.add(newRear);
	}

	public static void main(String[] args) {
		Queue<Integer>q=new LinkedList<>();
		
		q.add(12);
		q.add(13);
		reverseQueue(q);
		while(q.peek()!=null) {
			System.out.print(q.poll()+" ");
		}
	}

}
