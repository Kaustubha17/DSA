import java.util.ArrayList;

public class MinMaxSum {

	static long[] solve(int N, int[] A){
		// Write your code here
		long[] result = {0};
		ArrayList<Long>max=new ArrayList<>();
		ArrayList<Long>min=new ArrayList<>();
		ArrayList<Long>ans=new ArrayList<>();
		long runningMinSum=0;
		long runningMaxSum=0; 
		for(int i:A) {
			if(i<0) {
				runningMinSum+=i;
			}
			else {
				runningMaxSum+=i;
			}
			max.add((long)runningMaxSum);
			min.add((long)runningMinSum);
		}

		for(int i=0;i<N;i++) {

			ans.add(max.get(i)+min.get(i));	

		}

		result=new long[N];
		for(int i=0;i<N;i++)
			result[i]=ans.get(i);

		return result;

	}

	public static void main(String[] args) {
		int a[]= {};
		long ans[]=solve(a.length,a);
		for(long pAns:ans) {
			System.out.print(pAns+" ");
		}



	}

}
