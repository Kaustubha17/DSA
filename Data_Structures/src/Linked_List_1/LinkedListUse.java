package Linked_List_1;

import java.util.Scanner;

public class LinkedListUse {

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

	public static Node<Integer> createLinkedList(){
		Node<Integer>n1=new Node<>(10);

		Node<Integer>n2=new Node<>(20);
		Node<Integer>n3=new Node<>(30);
		Node<Integer>n4=new Node<>(40);

		n1.next=n2;
		n2.next=n3;
		n3.next=n4;

		return n1;


	}
	public static <T>void print(Node<T> head) {
		Node<T> temp = head;

		while(temp != null){
			System.out.print(temp.data +" ");
			temp = temp.next;
		}
		System.out.println();
	}
	public static void increment(Node<Integer> head){
		Node<Integer> temp = head;
		while(temp != null){
			temp.data++;
			temp = temp.next;
		}
	}
	public static void printRecursive(Node<Integer>head) {
		if(head==null)
			return;

		System.out.print(head.data+" ");
		printRecursive(head.next);
	}
	public static Node<Integer> addNodeRec(Node<Integer>head,int val,int pos){
		if(pos==0) {
			Node<Integer> newHead=new Node<Integer>(val);
			newHead.next=head;
			head=newHead;
			return head;
		}
		else if(head==null && pos>0)
		{
			return null;
		}

		head.next= addNodeRec(head.next, val, pos-1);
		return head;
	}
	public static Node<Integer> delNodeRec(Node<Integer>head,int pos){
		if(head==null) {
			return head;
		}
		if(pos==0) {
			return head.next;
		}
		head.next=delNodeRec(head.next, pos-1);
		return head;
	}
	public static Node<Integer> reverseLinkedListRec(Node<Integer>head){
		if(head==null||head.next==null)
			return head;


		Node<Integer>newHead=reverseLinkedListRec(head.next);

		head.next.next = head;
		head.next = null;

		// send back new head node in every recursion
		return newHead;

	}
	public static Node<Integer> reverseLinkedListIterative(Node<Integer>head){
		Node<Integer>temp=head;
		Node<Integer>prevNode=null;
		while(temp.next!=null) {
			Node<Integer>nextNode=temp.next;
			temp.next=prevNode;
			prevNode=temp;
			temp=nextNode;

		}
		temp.next=prevNode;
		return temp;
	}
	public static Node<Integer> midPoint(Node<Integer> head) {
		Node<Integer>slow=head;
		Node<Integer>fast=head;
		while(fast.next!=null &&fast.next.next!=null) {

			fast=fast.next.next;
			slow=slow.next;
		}

		return slow;

	}
	public static Node<Integer> mergeTwoSortedLinkedLists(Node<Integer> head1, Node<Integer> head2) {
		Node<Integer> head=null;
		Node<Integer> tail=null;
		if(head1==null && head2!=null)
			return head2;
		if(head2==null && head1!=null)
			return head1;
		if(head2==null && head1==null)
			return null;

		Node<Integer>tail1=head1;
		Node<Integer>tail2=head2;
		if(head1.data<head2.data) {
			head=head1;
			tail1=head1.next;
		}

		else {
			head=head2;
			tail2=head2.next;
		}


		tail=head;



		while(tail1!=null &&tail2!=null) {
			if(tail1.data<tail2.data) {
				tail.next=tail1;
				tail=tail1;
				tail1=tail1.next;
			}
			else {
				tail.next=tail2;
				tail=tail2;
				tail2=tail2.next;
			}
		}
		while(tail1!=null)
		{
			tail.next=tail1;
			tail=tail1;
			tail1=tail1.next;
		}
		while(tail2!=null) {
			tail.next=tail2;
			tail=tail2;
			tail2=tail2.next;
		}

		return head;
	}
	public static Node<Integer> mergeSort(Node<Integer> head) {

		if(head.next==null)
			return head;
		if(head==null)
			return head;

		Node<Integer> midPointer=midPoint(head);
		Node<Integer>headOfSecondPart=midPointer.next;
		midPointer.next=null;

		Node<Integer> h1Sorted=mergeSort(head);
		Node<Integer> h2Sorted=mergeSort(headOfSecondPart);
		return mergeTwoSortedLinkedLists(h1Sorted, h2Sorted);



	}
	public static Node<Integer> evenAfterOdd(Node<Integer> head) {

		if(head==null)
			return head;

		Node<Integer> d=new Node<>(head.data);

		Node<Integer>h1=null,t1=null;
		Node<Integer>h2=null,t2=null;
		if(head.data%2==0)
		{
			h2=d;
			t2=h2;
		}
		else {
			h1=d;
			t1=h1;
		}

		Node<Integer>temp=head.next;
		while(temp!=null) {
			d=new Node<>(temp.data);
			if(temp.data%2==0) {

				if(t2!=null) {
					t2.next=d;
					t2=t2.next;

				}
				else {
					h2=d;
					t2=h2;
				}
			}
			else {
				if(t1!=null) {
					t1.next=d;
					t1=t1.next;
				}
				else {
					h1=d;
					t1=h1;
				}
			}
			temp=temp.next;
		}
		t1.next=h2;




		return h1;
	}
	public static Node<Integer> skipMdeleteN(Node<Integer> head, int M, int N) {
		Node<Integer>temp=head;

		int deleteNodes=N;
		int keepNodes=M;


		while(temp!=null) {
			deleteNodes=N;
			keepNodes=M;
			//			System.out.print("before "+temp.data+" ");
			while(keepNodes>1){
				keepNodes--;
				if(temp==null)
					break;
				temp=temp.next;
			}
			//			System.out.println("after "+temp.data);
			Node<Integer>t2=temp;

			while(deleteNodes>0) {
				if(t2==null)
					break;
				deleteNodes--;
				t2=t2.next;

			}

			if(t2!=null)
				t2=t2.next;
			//			System.out.println(t2.data);
			if(temp!=null) {
				temp.next=t2;
				temp=temp.next;
			}

		}


		return head;

	}
	public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {
		if(head==null)
			return head;

		Node<Integer>temp1=head,temp2=head;
		if(j<i) {
			int temp=j;
			j=i;
			i=temp;
		}


		for(int k=0;k<j-1;k++) {

			if(temp1==null||temp1.next==null)
				break;

			temp1=temp1.next;
		}
		if(temp1==null||temp1.next==null)
			return head;


		for(int k=0;k<i-1;k++) {
			temp2=temp2.next;
		}
		System.out.println(temp2.data);
		Node<Integer>temp3=temp1.next.next,temp4=temp2.next.next;
		Node<Integer>firstNode=temp1.next,secNode=temp2.next;

		if(j-i==1 && i!=0) {
			temp2.next=temp4;
			temp1.next=temp3;
			temp4.next=temp1;
			return head;


		}
		if(i==0 &&j==1) {

			firstNode=temp1;
			secNode=temp1.next;
			temp3=secNode.next;
			firstNode.next=temp3;
			secNode.next=firstNode;
			head=secNode;
			return head;
		}
		else if(i==0 && j!=1) {
			//	System.out.println(temp2.data);
			temp4=temp2.next;
			secNode=temp2;
			temp1.next=secNode;
			temp2.next=temp3;
			firstNode.next=temp4;
			head=firstNode;
			return head;


		}
		temp1.next=temp2.next;
		temp1.next.next=temp3;
		temp2.next=firstNode;
		firstNode.next=temp4;

		return head;
	}
	public static Node<Integer> kReverse(Node<Integer> head, int k) {
		if(head==null)
			return null;
		int i=1;
		Node<Integer> tail=head,temp=head;
		while(i<k) {
			if(tail.next==null)
				break;
			tail=tail.next;
			i++;
		}
//		System.out.println(tail.data);
		Node<Integer> nextHead=tail.next;
		tail.next=null;
		head=reverseLinkedListRec(head);
		
		Node<Integer>nextHead2=kReverse(nextHead, k);
		temp.next=nextHead2;
		return head;
		
		
		 
		
		


	}


	public static void main(String[]args) {
		//		Node<Integer>n=createLinkedList();
		//		print(n);
		//
		//
		//		Node<Integer> n1; //-->creates reference
		//		n1=new Node<>(10);//creates object and assign the address of object to reference
		//		System.out.println(n1);
		//
		//		System.out.println("Quiz");
		//
		//		Node<Integer> node1 = new Node<Integer>(10);
		//		Node<Integer> node2 = new Node<Integer>(20);
		//		node2.next = node1;
		//		increment(node2);
		//		print(node2);


		//		System.out.println(n1.data);
		//		System.out.println(n1.next);
		//		
		//		Node<String> n2=new Node<>("hello");
		//	
		//		n2.next=n1;
		//		System.out.println(n2.data);
		//		System.out.println(n2.next.data);


		Node<Integer>head=takeInput();
		//		Node<Integer>head2=takeInput();
		//		Node<Integer>head=mergeSort(head1);
		//		Node<Integer>head=mergeTwoSortedLinkedLists(head1, head2);

		//		Node<Integer>head=evenAfterOdd(head1);
//				Node<Integer>head=skipMdeleteN(head1, 1, 10);
		Node<Integer>head1=kReverse(head,3);
		//		head=addNodeRec(head,20, 3);
		//		delNodeRec(head, 1);
		//		head=reverseLinkedListIterative(head);
		//		Node<Integer>midPoint=	midPoint(head);
		//		System.out.println(midPoint.data);
		//		System.out.println();
		print(head1);

	}



}
