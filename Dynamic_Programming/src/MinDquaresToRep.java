import java.util.Scanner;

public class MinDquaresToRep {

	public static int minSquares(int n,int[]dp) {
		if(n==0)
			return 0;
	
		int minAns=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int currAns;
			if(dp[n-(i*i)]==-1) {
			 currAns=minSquares(n-(i*i),dp);
			dp[n-(i*i)]=currAns; 
			}
			else {
				currAns=dp[n-(i*i)];
			}
			
			minAns=Math.min(minAns, currAns);
			
		}
		
		return 1+minAns;
	}
	
	public static int minSquaresIter(int n) {
		int dp[]=new int[n+1];
		for(int i=0;i<=n;i++)
		{
			dp[i]=-1;
		}
		dp[0]=0;
		for(int i=1;i<=n;i++) {
			int temp;
			int min=Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++)
			{
				temp=dp[i-j*j];
				min=Math.min(min, temp);
			}
			dp[i]=1+min;
		}
		
		
		
		return dp[n];
		
	}
	
	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int dp[]=new int[n+1];
		
		for(int i=0;i<dp.length;i++)
			dp[i]=-1;
		
//		System.out.println(minSquares(n,dp));
		System.out.println(minSquaresIter(n));

	}

}
