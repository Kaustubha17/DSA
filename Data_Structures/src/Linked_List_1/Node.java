package Linked_List_1;

public class Node<T> {

public	T data;
public	Node<T> next;//had to make this public because of stacks which is in next package in non derived class
public Node(T data){
		this.data=data;
		next=null;
	}
}
