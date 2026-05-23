package Weekly_Contest_318;

import java.util.HashMap;

public class Maximum_Sum_of_Distinct_Subarrays_With_Length_K {

	public static long maximumSubarraySum(int[] arr, int k) {
		long ans=0;
		long tempSum=0;
		HashMap<Integer, Integer>map=new HashMap<>();
		for(int i=0;i<k;i++) {
			map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
			tempSum+=arr[i];
		}
		for(int i=k;i<arr.length;i++) {
//			System.out.println(map+" "+arr[i]);
			if(map.size()==k) {
				ans=Math.max(ans, tempSum);
			}
			tempSum=tempSum-arr[i-k];
			tempSum=tempSum+arr[i];
			map.put(arr[i-k],map.get(arr[i-k])-1);
			if(map.get(arr[i-k])!=null && map.get(arr[i-k])==0) {
				map.remove(arr[i-k]);
			}

			map.put(arr[i],map.getOrDefault(arr[i], 0)+1);
		}

		if(map.size()==k) {
			ans=Math.max(ans, tempSum);
		}
		
		return ans;
	}
	public static void main(String[] args) {
		int arr[]= {1,5,4,2,9,9,9};
		int k=3;
		System.out.println(maximumSubarraySum(arr, k));
	}
	/*
	 * [1,1,1,7,8,9]
		3
		
		[1,5,4,2,9,9,9]
3
	 */

}
