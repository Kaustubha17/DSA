package Linked_List_1;

import java.util.Scanner;

public class AppendLastNToFirst {
	public static Node<Integer> appendLastNToFirst(Node<Integer> head, int n) {

		if(head==null)
			return head;

		Node<Integer> temp=head;
		Node<Integer>  tail=head;

		int totalLength=0;
		while(tail.next!=null){
			totalLength++;

			tail=tail.next;
		}
		totalLength++;

		int numberOfElementsToBeShifted=totalLength-n;
		System.out.println(numberOfElementsToBeShifted);
		if(numberOfElementsToBeShifted==0)
			return head;
		else{
			if(numberOfElementsToBeShifted==1) {
				tail.next=head;
				head=head.next;
				temp.next=null;
				//				head=temp.next;
			}
			else {
				while(numberOfElementsToBeShifted>1){
					tail.next=temp;
					tail=tail.next;
					temp=temp.next;
					numberOfElementsToBeShifted--;
				}
				System.out.println(temp.data);
				head=temp.next;
				temp.next=null;
			}
		}


		return head;

	}

	public static Node<Integer> takeInput(){
		Scanner s=new Scanner(System.in);
		int data=s.nextInt();
		Node<Integer>head=null;
		Node<Integer>tail=head;
		while(data!=-1) {
			Node<Integer> currentNode=new Node<>(data);
			if(head==null) {
				head=currentNode;
				tail=head;
			}
			else {
				tail.next=currentNode;
				tail=tail.next;

			}
			data=s.nextInt();
		}
		return head;
	}
	public static <T>void print(Node<T> head) {
		Node<T> temp = head;

		while(temp != null){
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Node<Integer>s=takeInput();
		s=appendLastNToFirst(s, 5);
		print(s);

	}

}
