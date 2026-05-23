package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {
	private Queue<Integer>q1;
	private Queue<Integer>q2;
	int size;

	public StackUsingQueues() {
		q1=new LinkedList<>();
		q2=new LinkedList<>();
		size=0;

	}



	/*----------------- Public Functions of Stack -----------------*/


	public int getSize() { 
		return size;
	}

	public boolean isEmpty() {
		//Implement the isEmpty() function
		return size==0;
	}

	public void push(int element) {
		//Implement the push(element) function
		q1.add(element);
		size++;
	}

	public int pop() {
		if(size==0)
			return -1;
		int size2=size;
		System.out.println("size2 "+size2+"peek "+q1.peek());
		while(size2>1) {
			q2.add(q1.poll());
			size2--;
		}
		int ans=q1.poll();
		size2=--size;
		while(size2!=0) {
			q1.add(q2.poll());
			size2--;
		}
return ans;
	}

	public int top() {
		if(size==0)
			return -1;
		int size2=size;
		while(size2>1) {
			q2.add(q1.poll());
			size2--;
		}
		int ans=q1.poll();
		size2=size-1;
		while(size2!=0) {
			q1.add(q2.poll());
			size2--;
		}
		q1.add(ans);
		System.out.println("top ans "+ans+" q1 peek "+q1.peek());
return ans;
	}

}
