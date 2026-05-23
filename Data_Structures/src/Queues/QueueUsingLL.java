package Queues;

import Linked_List_1.Node;

public class QueueUsingLL<T> {
private Node<T> front;
private Node<T>rear;
private int size;

public QueueUsingLL() {
	front=null;
	rear=null;
	size=0;
}
public int size() {
	return size;
}

public boolean isEmpty() {
	return size==0;
}

public void enqueue(T elem) {
	Node<T>newNode=new Node(elem);
	if(front==null) {
		front=newNode;
	}else {
		rear.next=newNode;
	}
	rear=newNode;
	size++;
}

public T front() throws QueueEmptyException {
	if(front==null) {
		throw new QueueEmptyException();
	}
	
	return front.data;
}

public T dequeue() throws QueueEmptyException{
	if(front==null) {
		throw new QueueEmptyException();
	}
	else {
		T ans=front.data;
		front=front.next;
		if(front==null)
			rear=null;
		size--;
		return ans;
	}
}





}
