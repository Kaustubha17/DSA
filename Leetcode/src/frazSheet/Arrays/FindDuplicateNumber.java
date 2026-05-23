package frazSheet.Arrays;

public class FindDuplicateNumber {

	public static int findDuplicate(int[] nums) {
		
		if(nums.length>1) {
		int slow=nums[0];
		int fast=nums[nums[0]];
		while(fast!=slow) {
			slow=nums[slow];
			fast=nums[nums[fast]];
		}
		
		
		fast = 0;
		while (fast != slow)
		{
			fast = nums[fast];
			slow = nums[slow];
			
			System.out.println(fast+" "+slow);
//			System.out.println();
		}
		return slow;	

		
		}
		
		return -1;
	}
public static int findDuplicate2(int[] nums) {
		
	for(int i=0;i<nums.length;i++) {
	int num=nums[i];
 if(num<0)
	 num=-1*num;
 
 num--;
 int t=nums[num];
 if(t<0) {
	 return nums[i];
 }
 else {
	 nums[num]=-t;
 }
	
		}
	return -1;	
	}
	public static void main(String[] args) {
		int arr[]= {1,3,4,2,2};
//		System.out.println(2^3^2);
		System.out.println(findDuplicate2(arr));
	}

}
