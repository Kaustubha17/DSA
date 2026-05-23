package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combination_Sum {

	public void recSum(int candidates[],int target,List<List<Integer>>ans,List<Integer>temp,int currIndex) {
		if(target<0||candidates.length<currIndex)
			return;
		if(target==0) {
			ans.add(new ArrayList<>(temp));
			return;
		}

		for(int i=currIndex;i<candidates.length;i++) {
			if(i>currIndex &&(candidates[i]==candidates[i-1])) {
				continue;
			}
			temp.add(candidates[i]);
			target=target-candidates[i];
			recSum(candidates, target, ans, temp, i+1);
			target=target+candidates[i];
			temp.remove(temp.size()-1);
		}


	}
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		Arrays.sort(candidates);
		
		List<List<Integer>>ans=new ArrayList<>();
		boolean visited[]=new boolean[candidates.length];
		recSum(candidates, target, ans, new ArrayList<>(), 0);
//		System.out.println();
		return ans;
	}
	public static void main(String[] args) {
//		int candidates[]= {2,2,2};
		int candidates[]= {3,1,3,5,1,1};
				
		int target=8;
		List<List<Integer>>ans=new Combination_Sum().combinationSum(candidates,target);

		for(List<Integer>partialAns:ans) {
			for(int elem:partialAns) {
				System.out.print(elem);
			}
			System.out.println();
		}

	}

}
