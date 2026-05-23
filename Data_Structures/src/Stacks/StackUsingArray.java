package Stacks;

public class StackUsingArray {
	private int data[];
	private int topIndex;
	public StackUsingArray() {
		data=new int[10];
		topIndex=-1;
	}
	public StackUsingArray(int size) {
		data=new int[size];
		topIndex=-1;
	}
	
	public void push(int elem)throws StackFullException {
		topIndex++;
		if(data.length<=topIndex) {
			throw new StackFullException();
		}
		else {
			data[topIndex]=elem;
		}
	}
	public int size()  {
		return topIndex+1;
	}

	public int top() throws StackEmptyException{
		if(topIndex!=-1)
			return data[topIndex];

		else
		{
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
	}

	public int pop() throws StackEmptyException {
		if(topIndex!=-1) {
			int temp=data[topIndex];
			data[topIndex]=0;
			--topIndex;
			return temp;}
		else
		{
			StackEmptyException e=new StackEmptyException();
			throw e;
		}
	}
	public boolean isEmpty() {
		return topIndex==-1;
	}
}
