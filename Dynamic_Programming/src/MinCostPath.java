
public class MinCostPath {

    public static int minCostPath(int[][] input,int i,int j) {
	if(i<0||j<0||i>=input.length||j>=input[i].length)
        return Integer.MAX_VALUE;
     if(i==input.length-1 && j==input[i].length-1)
         return input[i][j];
        
        
       int downCost=minCostPath(input,i+1,j);
        int rightCost=minCostPath(input,i,j+1);
        int diagCost=minCostPath(input,i+1,j+1);
        
        return input[i][j]+Math.min(downCost,Math.min(rightCost,diagCost));
        
	}
    
    public static int minCostPathRec(int [][]input,int i,int j,int dp[][]) {
    	
    	if(i<0||j<0||i>=input.length||j>=input[i].length)
            return Integer.MAX_VALUE;
         if(i==input.length-1 && j==input[i].length-1)
         {
        	 dp[i][j]=input[i][j];
        	 return input[i][j];
         }
            
         if(dp[i][j]!=-Integer.MIN_VALUE)
        	 return dp[i][j];
            
           int downCost=minCostPathRec(input,i+1,j,dp);
            int rightCost=minCostPathRec(input,i,j+1,dp);
            int diagCost=minCostPathRec(input,i+1,j+1,dp);
            int ans=input[i][j]+Math.min(downCost,Math.min(rightCost,diagCost));
            dp[i][j]=ans;
            return ans;
    	
    	
    }
    
	public static int minCostPath(int[][] input) {
		int dp[][]=new int [input.length][input[0].length];
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[0].length;j++)
				dp[i][j]=Integer.MIN_VALUE;
		
		
	int a= minCostPathRec(input,0,0,dp);
	for(int i=0;i<dp.length;i++) {
		for(int j=0;j<dp[0].length;j++) {
			System.out.print(dp[i][j]+" ");
		}
	System.out.println();	
	}
	return a;
	}
	
	public static int minCostPAthIter(int input[][]) {
		int m=input.length;
		int n=input[0].length;
		
		int [][]dp=new int[m+1][n+1];
		
		for(int i=0;i<dp.length;i++)
			for(int j=0;j<dp[0].length;j++)
				dp[i][j]=Integer.MAX_VALUE;
		
		for(int i=m-1;i>=0;i--)
			for(int j=n-1;j>=0;j--) {
				if(i==m-1&&j==n-1)
				{
					dp[i][j]=input[i][j];
					continue;
				}
				int ans1=dp[i][j+1];
				int ans2=dp[i+1][j];
				int ans3=dp[i+1][j+1];
				
				dp[i][j]=input[i][j]+Math.min(ans1, Math.min(ans2, ans3));
			}
		
		return dp[0][0];
		
		
	}
	
	public static void main(String[] args) {
	int arr[][]= {
			{3,4,1,2},
			{2,9,8,9},
			{4,7,8,1}
	};
	
//System.out.println(minCostPAthIter(arr));
	int var1=42;
	int var2=~var1;
	System.out.println(var1+" "+var2);
	}

}
