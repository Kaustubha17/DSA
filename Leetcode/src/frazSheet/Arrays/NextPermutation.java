package frazSheet.Arrays;

public class NextPermutation {

	public static void swap(int arr[],int i,int j) {
		int temp=arr[i];
		arr[i]=arr[j];
		arr[j]=temp;
	}
	public static void rotate(int arr[],int start,int end) {
		while(start<end) {
			swap(arr,start,end);
			start++;
			end--;
		}
		
	}
	
	 public static void nextPermutation(int[] arr) {
	     int n=arr.length;
	     int i=n-2;
	     
	     while(i>=0 && arr[i]>=arr[i+1]) {
	    	 i--;
	     }
	  
	     if(i<0) {
	    	 rotate(arr,0,n-1);
	     }
		 if(i>=0) {
			 int j=n-1;
			 while(j>=0&&arr[j]<=arr[i]) {
				 j--;
			 }
			 swap(arr,i,j);
			 rotate(arr,i+1,j+1);
		 }
	    }
	
	public static void main(String[] args) {

		int []arr= {3,5,4,1};
		nextPermutation(arr);
		for(int i:arr) {
			System.out.print(i+" ");
		}
		
		
	}

}
