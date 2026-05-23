package Stacks;

import Linked_List_1.Node;

//implemented in 					headNode-->nodeN-->node(N-1)--------->node1 for ease in pop and top 
public class StackUsingLL<T> {

	private Node<T> head;
	private int size;
	
	public StackUsingLL() {
		this.head=null;
		this.size=0;
	}
	
	public int size() {
		return this.size;
	}
	public boolean isEmpty() {
		return this.size==0;
	}
	public void push(T elem) {
		Node<T> newNode=new Node<>(elem);
		
		if(head==null) {
			head=newNode;
			
		}
		else {
			newNode.next=head;
			head=newNode;
			
		}
		this.size++;
	}
	public T pop() throws StackEmptyException {
		if(head==null)
		{
			throw new StackEmptyException();
		}
		else {
			T deletedNode=head.data;
			head=head.next;
			this.size--;
			return deletedNode;
			
		}
	}
	public T top() throws StackEmptyException{
		if(head==null)
		{
			throw new StackEmptyException();
		}
		else {
			return head.data;
		}
	}
	
	
	
}
