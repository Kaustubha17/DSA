
public class BubbleSort {
	public static void printArray(int [] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	public static void bubbleSort(int [] arr) {
	int n=arr.length;
	int i=0;
	while(i<n-1) {
		int j=0;
		while(j<(n-i-1)) {
			if(arr[j]>arr[j+1]) {
				int temp=arr[j];
				arr[j]=arr[j+1];
				arr[j+1]=temp;
			}
			j++;
		}
		printArray(arr);
		System.out.println();
	i++;
	}
}
	
	public static void main(String[] args) {
		int arr[]= {1,22,3,5,6,7,-1};
		bubbleSort(arr);


	}

}
