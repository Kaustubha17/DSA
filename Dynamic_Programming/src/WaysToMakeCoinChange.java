/*For the given infinite supply of 
 *coins of each of denominations, 
 *D = {D0, D1, D2, D3, ...... Dn-1}. 
 *You need to figure out the total number of ways W, in which you can 
 *make the change for Value V using coins of denominations D.
Return 0 if the change isn't possible.
 */



public class WaysToMakeCoinChange {


	public static int countWaysToMakeChange(int denominations[], int value,int index,int dp[][]){
		if(value==0) {

			return 1;
		}
		if(value<0)
			return 0;
		if(index==denominations.length)
			return 0;
		if(dp[value][denominations[index]]!=-1)
			return dp[value][denominations[index]];

		int ans=0;

		int ans1=countWaysToMakeChange(denominations, value-denominations[index],index,dp);
		int ans2=countWaysToMakeChange(denominations, value,index+1,dp);
		ans=ans1+ans2;
		dp[value][denominations[index]]=ans;
		return ans;

	}

	public static void main(String[] args) {
		int change[]= {1,2,3,4,5,6};
		int value=250;
		int n=change.length;
		int m=value;
		int dp[][]=new int[m+1][n+1];
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[0].length;j++)
				dp[i][j]=-1;

		System.out.println(countWaysToMakeChange(change, value,0,dp));

	}

}
