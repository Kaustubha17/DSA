
public class Remove_Duplicates_from_Sorted_Array {
	public static int removeDuplicates(int[] nums) {
		int uniqueValues=1;
		int startIdx=0;
		
		int n=nums.length;
		for(int i=1;i<n;i++) {
			if(nums[i]!=nums[startIdx]) {
				nums[uniqueValues]=nums[i];
				uniqueValues++;
				startIdx=i;
			}
			
		}

		return uniqueValues; 
	}
	public static void main(String[] args) {

		int arr[]= {0,0,1,1,1,2,2,3,3,4};
		System.out.println(removeDuplicates(arr));
		for(int i:arr) {
			System.out.print(i+" ");
		}
	}

}
