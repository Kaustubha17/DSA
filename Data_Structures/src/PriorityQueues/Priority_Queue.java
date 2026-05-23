package PriorityQueues;

import java.util.ArrayList;

/*
 *  Code for min priority queue
 */

public class Priority_Queue<T> {

	private ArrayList<Element<T>>heap;

	public Priority_Queue() {
		heap=new ArrayList<>();
		
	}

	public void insert(T value,int priority) {
		heap.add(new Element<T>(value,priority));

		int childIndex=heap.size()-1;
		int parentIndex=(childIndex-1)/2;
		while(childIndex>0 && heap.get(childIndex).priority<=heap.get(parentIndex).priority) {

			Element<T> temp=heap.get(childIndex);
			heap.set(childIndex,heap.get(parentIndex));
			heap.set(parentIndex, temp);
			childIndex=parentIndex;
			parentIndex=(childIndex-1)/2;

		}



	}

	public T getMin() throws PriorityQueueException{
		if(heap.size()!=0)
			return heap.get(0).value;
		else 
			throw new PriorityQueueException();

	}

	public T removeMin() throws PriorityQueueException{
		if(heap.size()!=0)
		{
			Element<T>ans=heap.get(0);
			
			
			heap.set(0, heap.get(heap.size()-1));
			heap.remove(heap.size()-1);
			
			int parentIndex=0;
			int leftChildIndex=2*parentIndex+1;
			int rightChildIndex=2*parentIndex+2;
			
			
			while(leftChildIndex<heap.size()) {
			int minIndex=parentIndex;
			
			if(heap.get(leftChildIndex).priority<heap.get(minIndex).priority) {
				minIndex=leftChildIndex;
			}
			if(rightChildIndex<heap.size()&& heap.get(rightChildIndex).priority<heap.get(minIndex).priority) {
				minIndex=rightChildIndex;
			}
			if(parentIndex==minIndex)
				break;
			
			Element<T>temp=heap.get(minIndex);
			heap.set(minIndex, heap.get(parentIndex));
			heap.set(parentIndex, temp);
			parentIndex=minIndex;
			 leftChildIndex=2*parentIndex+1;
			 rightChildIndex=2*parentIndex+2;
			}
			
			
			return ans.value;
		}

		else
			throw new PriorityQueueException();

	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return heap.size()==0;
	}


}
