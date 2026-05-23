package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_2 {

	public void RecPermute(List<List<Integer>>ans,List<Integer>temp,int nums[],boolean[]visited) {
		if(temp.size()==nums.length) {
			ans.add(new ArrayList<>(temp));
			return;
		}

		for(int i=0;i<nums.length;i++) {
			if(visited[i]||(i>0 &&nums[i]==nums[i-1]&&!visited[i-1]))
				continue;

			visited[i]=true;
			temp.add(nums[i]);

		


			RecPermute(ans, temp, nums,visited);
			visited[i]=false;
			temp.remove(temp.size()-1);


		}


	}

	public List<List<Integer>> permuteUnique(int[] nums) {

		Arrays.sort(nums);
		List<List<Integer>>ans=new ArrayList<>();
		RecPermute(ans, new ArrayList<>(), nums,new boolean[nums.length]);

		return ans;

	}

	public static void main(String[] args) {

		int nums[]= {1,1,2};
		List<List<Integer>>ans=new Permutations_2().permuteUnique(nums);
		for(List<Integer>a:ans) {
			for(int index:a)
				System.out.print(index+" ");
			System.out.println();
		}

	}

}
