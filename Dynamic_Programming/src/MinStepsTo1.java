import java.util.Scanner;

public class MinStepsTo1 {

	public static int countMinStepsToOne(int n,int dp[]) {

		if(n==1)
			return 0;

		//System.out.println(n);

		int sub1;
		if(dp[n-1]==-1) {
			sub1=countMinStepsToOne(n-1,dp);
			dp[n-1]=sub1;
		}
		else {
			sub1=dp[n-1];
		}
		int divBy2=Integer.MAX_VALUE;

		if((n%2)==0) {

			if(dp[n/2]==-1) {
				divBy2=countMinStepsToOne(n/2,dp);
				dp[n/2]=divBy2;			
			}
			else {
				divBy2=dp[n/2];
			}
		}
		int divBy3=Integer.MAX_VALUE;

		if(n%3==0) {
			if(dp[n/3]==-1) {
				divBy3=countMinStepsToOne(n/3,dp);
				dp[n/3]=divBy3;	
			}
			else {
				divBy3= dp[n/3];
			}
		}
		int ans=1+Math.min(sub1, Math.min(divBy2, divBy3));
		System.out.println(ans);
		return ans;


	}

	public static int countMinStepsIter(int n) {

		int dp[];
		if(n<=3)
			dp=new int[4];
		else
			dp=new int [n+1];

		dp[0]=0;
		dp[1]=0;
		dp[2]=1;
		dp[3]=1;
		for(int i=4;i<=n;i++) {
			int temp=i;
			int temp3=temp-1;
			int temp2=temp-1;
			int temp1=temp-1;
			if(temp%3==0)
				temp3=temp/3;
			
			else if(temp%2==0)
				temp2=temp/2;
			else
				temp1=temp-1;


			dp[i]=1+Math.min(dp[temp3], Math.min(dp[temp2],dp[temp1]));


		}
		/*
		 * for(int i:dp) System.out.print(i+" ");
		 */

		return dp[n];


	}


	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		int n=s.nextInt();
		int dp[]=new int[n+1];
		for(int i=0;i<=n;i++)
			dp[i]=-1;
		System.out.println(countMinStepsIter(n));

	}

}
