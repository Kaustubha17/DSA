
public class TestProblem3 {

	public static void leaders(int[] arr) {
	
		int n=arr.length;
		int leader;

		for(int i=0;i<n;i++) {
			leader=arr[i];
			boolean isLeader=true;
			int j=n-1;
			while(i<j) {
				if(arr[j]>leader)
				{
					isLeader=false;
					break;
				}
				j--;
			}
			if(isLeader) {
				System.out.print(leader+" ");
			}
			
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		int arr[]= {3 ,12 ,34 ,2 ,0 ,-1};
		leaders(arr);

	}

}
