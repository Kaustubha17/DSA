package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets_2 {
	public void recSubsetsWithDup(int nums[],List<Integer>temp,List<List<Integer>>ans,int index) {

		ans.add(new ArrayList<>(temp));

		if(index==nums.length)
			return;

		for(int i=index;i<nums.length;i++) {
			if(i > index && nums[i] == nums[i-1]) continue;
			temp.add(nums[i]);
			recSubsetsWithDup(nums, temp, ans, i+1);
			temp.remove(temp.size()-1);

		}

	}

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>>ans=new ArrayList<>();
		recSubsetsWithDup(nums, new ArrayList<>(), ans,0);

		return ans;
	}
	public static void main(String[] args) {
		int nums[]= {1,2,2};
		List<List<Integer>>ans=new Subsets_2().subsetsWithDup(nums);
		for(List<Integer>partialAns:ans) {
			for(int elem:partialAns) {
				System.out.print(elem);
			}
			System.out.println();
		}
	}

}
