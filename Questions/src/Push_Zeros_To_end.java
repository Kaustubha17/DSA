
public class Push_Zeros_To_end {

	public static void print(int [] arr) {
		for(int i:arr) {
			System.out.print(i+" ");
		}
		System.out.println();
	}

	public static void pushZerosAtEnd(int[] arr) {
		int n=arr.length;
		int i=0;
		int k=0;//Pointer for 
		while(i<n && k<n){

			if(arr[k]!=0){
				if(k==n-1)
					break;
				
				
				k++;
			}
			if( arr[k]==0 && arr[i]!=0){
				int temp=arr[i];
				arr[i]=0;
				arr[k]=temp;
				k++;
			}
			i++;
		}


	}
	public static void main(String[] args) {
		int arr[]= {1,2,3,4,5};
		pushZerosAtEnd(arr);

	}

}
