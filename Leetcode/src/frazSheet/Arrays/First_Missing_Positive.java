package frazSheet.Arrays;

public class First_Missing_Positive {

	public int firstMissingPositive(int[] nums) {

		for(int i=0;i<nums.length;i++) {
			if(nums[i]<=0||nums[i]>nums.length) {
				nums[i]=nums.length+2;
			}
			}
		
		for(int i=0;i<nums.length;i++) {
			int temp=Math.abs(nums[i]);
			temp=temp-1;
			if(temp==nums.length+1||nums[temp]<0) {
				continue;
			}
			nums[temp]=-1*nums[temp];
			
		}
		for(int i=0;i<nums.length;i++) {
			if(nums[i]>0) {
				return i+1;
			}
		}
		

		return nums.length+1;
	}

	public static void main(String[] args) {

		int nums[]= {0,1,2};
		System.out.println(new First_Missing_Positive().firstMissingPositive(nums));
	}

}
