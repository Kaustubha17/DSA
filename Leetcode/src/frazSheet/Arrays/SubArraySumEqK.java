package frazSheet.Arrays;
//referred neetcode video for explaination
import java.util.HashMap;

public class SubArraySumEqK {

	public static int subarraySum(int[] nums, int k) {
		HashMap<Integer, Integer>map=new HashMap<>();
		int ans=0;
		int runningSum=0;
		map.put(0,1);
		for(int i=0;i<nums.length;i++) {
			runningSum+=nums[i];
			if(map.containsKey(runningSum-k))
			{
				ans+=map.get(runningSum-k);
			}
			map.put(runningSum, map.getOrDefault(runningSum, 0)+1);
		}
		
		
		return ans;
		
	}

	public static void main(String[] args) {
		int nums[]= {1,-1,0};
		System.out.println(subarraySum(nums,0));
		
		
	}

}
