
public class Binary {
	
	public static int binarySearch(int a[],int target,int start,int end) {
		
		
		if(start>end)
			return -1;
		
		int mid=(start+end)/2;
		if(a[mid]==target) {
			
			return mid;
		
	
		}
		else if(a[mid]<target) {
			return binarySearch(a, target, mid+1, end);
		}
		else {
			return binarySearch(a, target, start, mid-1);
		}
		
		
		
	}

	public static void main(String[] args) {

		int[]a= {1,2,3,4,5};
		System.out.println(binarySearch(a,2,0,a.length-1));
		
		
	}

}
