package Queues;

import javax.swing.DebugGraphics;

public class Dequeue {
	int arr[];
	int size;
	int front;
	int rear;
	public Dequeue(int capacity){
		size=0;
		arr=new int[capacity];
		front=-1;
		rear=-1;
	}
	public void insertFront(int data){

		if(size==arr.length){
			System.out.println(-1);
			return ;
		}
		else {
			if(front==-1) {
				arr[0]=data;
				front=0;
				rear++;
				size++;
				
			}
			else if(front==0) {
				for(int i=rear;i>=front;i--) {
					arr[i+1]=arr[i];
				}
			
			front=0;
			arr[front]=data;
			rear++;
			size++;
			}
			else {
				front--;
				arr[front]=data;
				size++;
			}
		}
		
		
}
	
	public void insertRear(int data) {
		if(size==arr.length){
			System.out.println(-1);
			return ;
		}
		else {
			if(rear==arr.length-1) {
				for(int i=front;i<arr.length;i++) {
					arr[i-1]=arr[i];
				}
				front--;
				arr[rear]=data;
				size++;
				
			}
			else {
				rear++;
				size++;
				arr[rear]=data;
			}
		}
	}
	
	public int getFront() {
		if(size==0) {
//			System.out.println(-1);
			return -1;
		}
		else 
			return arr[front];
	}
 
	public int getRear() {
		if(size==0) {
//			System.out.println(-1);
			return -1;
		}
		else 
			return arr[rear];
	}

	public void deleteFront() {
		if(size==0) {
			System.out.println(-1);
			return;
		}
		else {
			front=front+1;
			if(front>rear)
			{
				front=-1;
				rear=-1;
			}
		}
	}

	public void deleteRear() {
		if(size==0) {
			System.out.println(-1);
			return;
		}
		else {
			rear=rear-1;
			
			if(front>rear)
			{
				front=-1;
				rear=-1;
			}
		}
	}
	
	
	public static void main(String[] args) {
		Dequeue dq=new Dequeue(10);
		dq.insertFront(10);
		dq.insertFront(20);
		System.out.println(dq.getFront());
	}
	

}
