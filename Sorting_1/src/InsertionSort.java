
public class InsertionSort {
	public static void printArray(int [] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	public static void insertionSort(int []arr) {
		int n=arr.length;
		int i=1;
		while(i<n) {
			int j=i-1;
			int curr=arr[i];
			while(j>=0 && arr[j]>curr ) {
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=curr;
			printArray(arr);
			System.out.println();
			i++;
		}


	}


	public static void main(String[] args) {

		int arr[]= {1,22,3,5,6,7,-1};
		insertionSort(arr);
		printArray(arr);



	}}


