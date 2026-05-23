package Weekly_Contest_318;

public class Apply_Operations_to_an_Array {

    public int[] applyOperations(int[] nums) {
        for(int i=0;i<nums.length-1;i++) {
        	if(nums[i]==nums[i+1]) {
        		nums[i]=2*nums[i];
        		nums[i+1]=0;
        	}
        }
        
        
        int snowBallSize=0;
       for(int i=0;i<nums.length;i++) {
    	   if(nums[i]==0) {
    		   snowBallSize++;
    	   }
    	   else {
    		   if(snowBallSize>0) {
    		  nums[i-snowBallSize]=nums[i];
    		  nums[i]=0;
    		   }
    	   }
       }
        
    	
    	return nums;
    }
	
	public static void main(String[] args) {
	int arr[]= {847,847,0,0,0,399,416,416,879,879,206,206,206,272};
//	[847,847,0,0,0,399,416,416,879,879,206,206,206,272]
	Apply_Operations_to_an_Array classAns=new Apply_Operations_to_an_Array();
	int ans[]=classAns.applyOperations(arr);
	for(int i:ans) {
		System.out.print(i+" ");
	}

	}

}
