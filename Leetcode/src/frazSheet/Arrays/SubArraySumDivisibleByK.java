package frazSheet.Arrays;

import java.util.HashMap;

public class SubArraySumDivisibleByK {

	  public int subarraysDivByK(int[] arr, int k) {
	    int runningsum=0;
	    int ans=0;
	    HashMap<Integer, Integer>map=new HashMap<>();
	    map.put(0, 1);
	    for(int i=0;i<arr.length;i++) {
	    	runningsum+=arr[i];
	    	int a=runningsum%k;
	    	if(a<0)
	    		a+=k;
	    
	    	if(map.containsKey((a))) {
	    		ans+=map.get(a);
	    		System.out.println(i);
	    	}
	    	
	    	map.put(a, map.getOrDefault(a, 0)+1);
//	    	map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
	    }
	    
	    
	    return ans;
		  
		  
	    }
	public static void main(String[] args) {
		int arr[]= {2,-2,2,-4};
		int k = 6;
//		System.out.println(-1%2);
		System.out.println(new SubArraySumDivisibleByK().subarraysDivByK(arr, k));
//		
		/*[2,-2,2,-4]
				6
				
				[-1,2,9]
2
		*/
	}

}
