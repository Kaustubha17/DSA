package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Partition_To_K_Equal_Sum_Subsets {

	public static boolean canPartitionHelper(int nums[],int i,int buckets[],int target) {

		if(i==-1)
			return true;

		for(int j=0;j<buckets.length;j++) {
			if(buckets[j]+nums[i]<=target) {
				buckets[j]+=nums[i];

			if(canPartitionHelper(nums, i-1, buckets, target))
				return true;
			
				
				buckets[j]-=nums[i];
			}
			
			  if(buckets[j]==0)
	                break;
}


		return false;
	}


	public static boolean canPartitionKSubsets(int[] nums, int k) {

		int totalSum=0;
		for(int i:nums)
			totalSum+=i;

		if(nums.length<k||totalSum%k!=0)
			return false;

		Arrays.sort(nums);

		return canPartitionHelper(nums, nums.length-1, new int[k],totalSum/k);
	}
	public static void main(String[] args) {
		int a[]= {10,1,10,9,6,1,9,5,9,10,7,8,5,2,10,8};
		System.out.println(canPartitionKSubsets(a,11));

	}


}
