
public class RotateArray {
	public static void printArray(int [] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}
	public static void rotate(int[]arr,int start,int end) {
		int i=start;
		int j=end-1;

		while(i<j) {
			int temp=arr[i];
			arr[i]=arr[j];
			arr[j]=temp;
			i++;
			j--;
		}

	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5,6,7};
		int n=arr.length;
		int d=3;
		rotate(arr,0,n);
		rotate(arr,0,n-d);
		rotate(arr,n-d,n);


		printArray(arr);



	}

}
