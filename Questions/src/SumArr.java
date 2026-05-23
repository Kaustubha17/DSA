
public class SumArr {
	 public static void rotate(int arr[]){
	        int i=0;
	        int j=arr.length-1;
	        while(i<j){
	            int temp=arr[j];
	            arr[j]=arr[i];
	            arr[i]=temp;
	            i++;
	            j--;
	        }
	        }
	 public static void print(int arr[]) {
		 for(int i:arr) {
			 System.out.print(i+" ");
		 }
		 System.out.println();
	 }

public static void sumOfTwoArrays(int arr1[], int arr2[], int output[]) {
    	rotate(arr1);
    	rotate(arr2);

    	
    	
    	int n1=arr1.length;
    	int n2=arr2.length;
    	
    	int i=0;
    	int j=0;
    	int k=0;
    	int carry=0;
    	while((i<n1)&&(j<n2)) {
    		int sum=arr1[i]+arr2[j]+carry;
    		int res=sum%10;
    		 carry=sum/10;
    		 output[k]=res;
    		 i++;
    		 j++;
    		 k++;

    	}
    	while(i<n1) {
    		int sum=arr1[i]+carry;
    		int res=sum%10;
    		 carry=sum/10;
    		 output[k]=res;
    		 i++;
    		 k++;	
    	}
    	while(j<n2) {
    		int sum=arr2[j]+carry;
    		int res=sum%10;
    		 carry=sum/10;
    		 output[k]=res;
    		 j++;
    		 k++;	
    	}
    	
    output[k]=carry;
    	
    	rotate(output);
    	print(output);
    
    }
	public static void main(String[] args) {
	int arr1[]= {8,5,2};
	int arr2[]= {1,3};
	int result[]=new int[5];
		sumOfTwoArrays(arr1, arr2, result);

	}

}
