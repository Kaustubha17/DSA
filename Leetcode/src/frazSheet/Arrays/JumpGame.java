package frazSheet.Arrays;

public class JumpGame {
	public boolean canJump(int[] nums) {

		//	    Greedy approach --O(n)

		int flagPost=nums.length-1;

		for(int i=nums.length-1;i>=0;i--) {
//			System.out.println(i+" "+flagPost);
			if(nums[i]+i>=flagPost) {
				flagPost=i;
			}
			
		}

		return flagPost==0;

	}
	public static void main(String[] args) {

		int nums[]= {3,2,1,0,4};
		System.out.println(new JumpGame().canJump(nums));


	}}
