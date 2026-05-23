package PriorityQueues;

public class HeapSort {

	public static void inplaceHeapSort(int arr[]) {
		/*		building heap using upHeapify Time Complexity:- nlogn

		for(int i=0;i<arr.length;i++)
		{
			int childIndex=i;
			int parentIndex=(childIndex-1)/2;
			while(childIndex>0&&childIndex<arr.length) {

				if(arr[parentIndex]>arr[childIndex])
					break;

				int temp=arr[parentIndex];
				arr[parentIndex]=arr[childIndex];
				arr[childIndex]=temp;
				childIndex=parentIndex;
				parentIndex=(childIndex-1)/2;
			}
		}
		 */


		//		building heap using downHeapify for non-leaf nodes Time Complexity:- n

		int nonLeafIndex=(arr.length/2)-1;
		for(int i=nonLeafIndex;i>=0;i--) {
			int parentIndex=i;
			int leftChildIndex=2*parentIndex+1;
			int rightChildIndex=2*parentIndex+2;

			while(leftChildIndex<arr.length) {
				int maxIndex=parentIndex;
				if(arr[maxIndex]<arr[leftChildIndex])
					maxIndex=leftChildIndex;
				if(rightChildIndex<arr.length && arr[maxIndex]<arr[rightChildIndex])
					maxIndex=rightChildIndex;
				if(maxIndex==parentIndex)
					break;

				int temp2=arr[parentIndex];
				arr[parentIndex]=arr[maxIndex];
				arr[maxIndex]=temp2;

				parentIndex=maxIndex;
				leftChildIndex=2*parentIndex+1;
				rightChildIndex=2*parentIndex+2;


			}
		}


		//		removing max elems and swapping with last elem and down heapifying

		for(int i=arr.length-1;i>0;i--) {
			int temp=arr[0];
			arr[0]=arr[i];
			arr[i]=temp;

			int parentIndex=0;
			int leftChildIndex=2*parentIndex+1;
			int rightChildIndex=2*parentIndex+2;

			while(leftChildIndex<i) {
				int maxIndex=parentIndex;
				if(arr[maxIndex]<arr[leftChildIndex])
					maxIndex=leftChildIndex;
				if(rightChildIndex<i && arr[maxIndex]<arr[rightChildIndex])
					maxIndex=rightChildIndex;
				if(maxIndex==parentIndex)
					break;

				int temp2=arr[parentIndex];
				arr[parentIndex]=arr[maxIndex];
				arr[maxIndex]=temp2;

				parentIndex=maxIndex;
				leftChildIndex=2*parentIndex+1;
				rightChildIndex=2*parentIndex+2;


			}
		}

		return ;
	}

	public static void main(String[] args) {
		int arr[]= {3,8,1,45,76,23,34,12};
		inplaceHeapSort(arr);
		for(int i:arr) {
			System.out.println(i+" ");
		}

	}

}
