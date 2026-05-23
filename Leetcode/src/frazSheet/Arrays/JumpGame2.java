package frazSheet.Arrays;

public class JumpGame2 {
	public int jump(int[] nums,int currIndex,String s) {
		if(currIndex>=nums.length)
			return Integer.MAX_VALUE;
		if(currIndex==nums.length-1) {
			System.out.println("currIndex: "+currIndex+" "+s+" "+nums[currIndex]);
			return 0;
		}
		if(currIndex<nums.length-1 &&nums[currIndex]==0)
			return Integer.MAX_VALUE;

		int ans=Integer.MAX_VALUE;
		for(int i=1;i<=nums[currIndex];i++) {
			ans=Math.min(1+jump(nums,currIndex+i,s+" "+i),1+jump(nums,currIndex+i,s+" "+i));
		}

		return ans;


	}

	public int minCost(int []nums,int currentIndex,int dp[]) {
		int i=currentIndex+1;
		int ans=Integer.MAX_VALUE;
		int k=0;
		while(i<nums.length&&k<nums[currentIndex]) {

			ans=Math.min(ans, dp[i]);
			k++;
			i++;
		}
		if(ans==Integer.MAX_VALUE)
			return ans;

		return 1+ans;
	}

	public int jumpIter(int[] nums) {

		int dp[]=new int[nums.length];

		for(int i=0;i<nums.length;i++) {
			if(nums[i]==0) {
				dp[i]=Integer.MAX_VALUE;
			}
		}
		
		if(nums[nums.length-2]!=0) {
			dp[nums.length-2]=1;	
		}
		
		dp[nums.length-1]=0;

		for(int i=nums.length-3;i>=0;i--) {

			if(nums[i]==0)
				continue;
			dp[i]=minCost(nums, i,dp);
	}
	
		for(int i:dp) System.out.print(i+" ");

		System.out.println();
		return dp[0];

	}
	public int jump(int[] nums) {
		return jump(nums,0,"");   


	}
	public static void main(String[] args) {
		int arr[]= {3,2,1,0,4};
		System.out.println(new JumpGame2().jumpIter(arr));

		/*
		 *
			[2,3,1,1,4]
			[2,3,1,1,0]
			[5]
			[1,4,65,78,4,2,6,7,2,43,61,43,5,32,6,87,14]		
		 */

	}

}
