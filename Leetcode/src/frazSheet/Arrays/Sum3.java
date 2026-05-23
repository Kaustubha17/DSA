package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sum3 {





	public static List<List<Integer>> threeSum(int[] nums) {

		Set<List<Integer>> res  = new HashSet<>();
        if(nums.length==0) return new ArrayList<>(res);
        Arrays.sort(nums);
        for(int i=0; i<nums.length-2;i++){
            int j =i+1;
           int  k = nums.length-1;
            while(j<k){
                int sum = nums[i]+nums[j]+nums[k];
                if(sum==0)res.add(Arrays.asList(nums[i],nums[j++],nums[k--]));
                else if ( sum >0) k--;
                else if (sum<0) j++;
            }

        }
        return new ArrayList<>(res);
	}



	public static void main(String[] args) {
		//int nums[]= {-1,0,1,2,-1,-4};
		//int nums[]= {1,2,-2,-1};
//		int nums[]= {3,0,-2,-1,1,2};
		int nums[]= {1,1,-2};
		List<List<Integer>>ans=threeSum(nums);
		for(int i=0;i<ans.size();i++) {
			List<Integer>partialAns=ans.get(i);
			for(int j=0;j<partialAns.size();j++) {
				System.out.print(partialAns.get(j)+" ");

			}
			System.out.println();

		}

	}}
