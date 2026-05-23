
public class SplitArray {
public static boolean helper(int arr[],int start,int sumofthree,int sumoffive) {
	if(start==arr.length)
		return sumofthree==sumoffive;
	
	if(arr[start]%5==0)
	sumoffive+=arr[start];
	else if(arr[start]%3==0)
		sumofthree+=arr[start];
	else {
		return helper(arr,start+1,sumofthree+arr[start],sumoffive)||
				helper(arr,start+1,sumofthree,sumoffive+arr[start]);
	}
	
	return helper(arr, start+1, sumofthree, sumoffive);
	
}
	
	
	public static boolean splitArray(int input[]) {
		
		
        return(helper(input,0,0,0));
	
	}
	
	
	
	public static void main(String[] args) {

		int arr[]= {1,2,4};
		System.out.println(splitArray(arr));
	}

}
