/*You are given a set of N integers. You have to return true if there exists a subset 
 * that sum up to K, otherwise return false.*/

public class SubSet_Sum {

    static boolean isSubsetPresent(int[] arr, int n, int sum) {

    	if(sum==0)
    		return true;
    	if(n<=0)
    		return false;
    	
    	return isSubsetPresent(arr, n-1, sum-arr[n-1])||isSubsetPresent(arr, n-1, sum);
    	
        

    }
	
	
	public static void main(String[] args) {
	int arr[]= {4,2,5,6,7};
	int n=arr.length;
	int sum=2;
	System.out.println(isSubsetPresent(arr, n, sum));

	}

}
