package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

	 public void findAllPermute(List<List<Integer>>result,int nums[],List<Integer>temp){
		    
	        if(temp.size()==nums.length){
	        result.add(new ArrayList<Integer>(temp));
	    }
	        for(int i=0;i<nums.length;i++)
	        {
	            if(temp.contains(nums[i]))
	               continue;
	            
	               temp.add(nums[i]);
	               findAllPermute(result,nums,temp);
	               temp.remove(temp.size()-1);
	        }
	               }
	               

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>>ans=new ArrayList<>();
		findAllPermute(ans, nums, new ArrayList<Integer>());
		return ans;
	}

	public static void main(String[] args) {
		int nums[]= {1,2,3};
		List<List<Integer>>ans=new Permutation().permute(nums);
		for(List<Integer>a:ans) {
			
			for(int b:a) {
				System.out.print(b+" ");
			}
			System.out.println();
		}
		
		
	}

}
