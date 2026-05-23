package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FourSum {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		Set<List<Long>>set=new HashSet<>();
		List<List<Integer>>ans=new ArrayList<>();
		Arrays.sort(nums);

		long numsLong[]=new long[nums.length];
		for(int i=0;i<nums.length;i++)
			numsLong[i]=nums[i];
		
		for(int i=0;i<numsLong.length-3;i++) {
			for(int j=i+1;j<numsLong.length-2;j++) {
				int k=j+1;
				int l=numsLong.length-1;
				while(l>k) {
					if(numsLong[i]+numsLong[j]+numsLong[k]+numsLong[l]==target) {
						List<Long>pAns=new LinkedList<>();
						pAns.add(numsLong[i]);
						pAns.add(numsLong[j]);
						pAns.add(numsLong[k]);
						pAns.add(numsLong[l]);
						set.add(pAns);
					}
					if(numsLong[i]+numsLong[j]+numsLong[k]+numsLong[l]>target)
						l--;
					else
						k++;
				}
			}
		}
		for(List<Long>i:set) {
			List<Integer>pAns=new ArrayList<>();
			for(long j:i) {
				pAns.add((int)j);
			}
			ans.add(pAns);
		}
		return ans;
	}
	public static void main(String[] args) {
		int nums[]= {1000000000,1000000000,1000000000,1000000000};
		int target=-294967296;
		List<List<Integer>>ans=fourSum(nums, target);
		for(List<Integer>i:ans) {
			for(int j:i)
				System.out.print(j+" ");
		
			System.out.println();
		}
		

	}

}
