package Queues;

public class QueueUse {

	public static void main(String[] args) throws QueueEmptyException,QueueOverflowException {
		QueueUsingArray q=new QueueUsingArray(1);
		StackUsingQueues s=new StackUsingQueues();
		s.push(12);
		s.push(13);
		System.out.println(s.pop());
		System.out.println(s.top());
		System.out.println(s.isEmpty());
		System.out.println(s.getSize());
		System.out.println(s.pop());
		
		
//		for(int i=0;i<5;i++) {
//			q.enqueue(2*i);
//		}
//		while(!q.isEmpty()) {
//			System.out.println(q.dequeue());
//		}
//System.out.println(q.front());

	}

}
