package frazSheet.Arrays;

import java.util.Arrays;

public class ThreeSumClosest {
	public static int threeSumClosest(int[] nums, int target) {

		int minDiff=Integer.MAX_VALUE;
		int ans=0;
		Arrays.sort(nums);

for(int i=0;i<nums.length-2;i++) {
	int j=i+1;
	int k=nums.length-1;
	
	while(j<k) {
		int ptAns=nums[i]+nums[j]+nums[k]-target;
		if(minDiff>Math.abs(ptAns)) {
//			System.out.println(nums[i]+" "+nums[j]+" "+nums[k]);
			
			ans=ptAns+target;
			ptAns=Math.abs(ptAns);
			minDiff=ptAns;
		}	
		if(ptAns<0)
			j++;
		else
			k--;
		
			
			
	}
}
		
		return ans;
	}
	public static void main(String[] args) {
		int arr[]= {-1,2,1,-4};
		int target=1;
		System.out.println(threeSumClosest(arr, target));

	}

}
