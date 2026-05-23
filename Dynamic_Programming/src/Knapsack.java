
public class Knapsack {

public static int knapsack(int[] weights, int[] values, int n, int maxWeight,int index) {
	if(index>=weights.length)
		return 0;
	
	if(weights[index]>maxWeight)
		return knapsack(weights, values, n, maxWeight, index+1);
	else {
		int ans1=values[index]+ knapsack(weights, values, n, maxWeight-weights[index], index+1);
		int ans2=knapsack(weights, values, n, maxWeight, index+1);
		return  Math.max(ans1, ans2);
	}
	
	}
	
public static int knapsackIterDP(int[] weights, int[] values, int n, int maxWeight) {
//	int n=values.length;
	int [][]dp=new int[n+1][maxWeight+1];
	for(int i=n-1;i>=0;i--)
		for(int w=0;w<=maxWeight;w++) {
			int ans;
			if(weights[i]<=w) {
				int ans1=values[i]+dp[i+1][maxWeight-weights[i]];
				int ans2=dp[i+1][w];
				ans=Math.max(ans1, ans2);
			}
			else {
				ans=dp[i+1][w];
			}
			dp[i][w]=ans;
		}
	
	return dp[0][maxWeight];
	
	
}

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		return knapsack(weights, values, n, maxWeight, 0);
	}
	
	
	public static void main(String[] args) {
		int weights[]= {1,2,4,5};
		int values[]= {5,4,8,6};
		System.out.println(knapsackIterDP(weights, values, 4, 5));
		

	}

}
