import java.util.Scanner;

public class Fibonacci {

	public static int fibonacciIterative(int n) {
		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		int i=2;
		while(i<=n) {
			dp[i]=dp[i-1]+dp[i-2];
			i++;
		}
		return dp[n];
		
	}
	
	public static int fibonacci(int n,int dp[]) {
		if(n==0||n==1)
			return n;
		int ans1,ans2;
		if(dp[n-1]==-1)
		{
			ans1=fibonacci(n-1,dp);
			dp[n-1]=ans1;
		}
		else {
			ans1=dp[n-1];
		}

		if(dp[n-2]==-1) {
			ans2=fibonacci(n-2,dp);
			dp[n-2]=ans2;
		}
		else {
			ans2=dp[n-2];
		}

		int myAns=ans1+ans2;
		return myAns;

	}

	public static void main(String[] args) {

		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int dp[]=new int[n+1];
		for(int i=0;i<n;i++)
			dp[i]=-1;

//		System.out.println(fibonacci(n,dp));
		System.out.println(fibonacciIterative(n));

	}

}
