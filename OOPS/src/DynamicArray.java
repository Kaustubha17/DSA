
public class DynamicArray {

	private	int data[];
	private int nextElementIndex;
	public DynamicArray() {

		data=new int[5]; 
		nextElementIndex=0;
	}
	public int size() {
		return nextElementIndex;
	}
public boolean isEmpty() {
	return nextElementIndex==0;
}
public int get(int i) {
	if(i>=nextElementIndex)
	{
//		throw error
		return -1;
	}
	
	return data[i];
}

public void add(int elem) {
	if(nextElementIndex<data.length) {
	data[nextElementIndex]=elem;
	nextElementIndex++;
	}
	else {
		int temp[]=new int[2*nextElementIndex];
		
		for(int i=0;i<nextElementIndex;i++) {
			temp[i]=data[i];
		}
		temp[nextElementIndex]=elem;
		nextElementIndex++;
		data=temp;	
	}
}

public void set(int i,int elem) {
	if(i>=nextElementIndex || i<0) {
	return;	
	}
	data[i]=elem;
}
public int removeLast() {
	
	if(nextElementIndex==0)
		return -1;
	
	int i=data[nextElementIndex-1];
	nextElementIndex--;
	data[nextElementIndex-1]=0;
	return i;
	
}

}
