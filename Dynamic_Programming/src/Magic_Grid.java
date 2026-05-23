
/*
 *You are given a magic grid A with R rows and C columns. In the cells of the grid, you will either get magic juice, which increases your strength by |A[i][j]| points, or poison, which takes away |A[i][j]| strength points. If at any point of the journey, the strength points become less than or equal to zero, then you will die.
You have to start from the top-left corner cell (1,1) and reach at the bottom-right corner cell (R,C). From a cell (i,j), you can only move either one cell down or right i.e., to cell (i+1,j) or cell (i,j+1) and you can not move outside the magic grid. You have to find the minimum number of strength points with which you will be able to reach the destination cell.
Input format:
The first line contains the number of test cases T. T cases follow. Each test case consists of R C in the first line followed by the description of the grid in R lines, each containing C integers. Rows are numbered 1 to R from top to bottom and columns are numbered 1 to C from left to right. Cells with A[i][j] < 0 contain poison, others contain magic juice.
Output format:
Output T lines, one for each case containing the minimum strength you should start with from the cell (1,1) to have a positive strength through out his journey to the cell (R,C).
Constraints:
1 ≤ T ≤ 5
2 ≤ R, C ≤ 500
-10^3 ≤ A[i][j] ≤ 10^3
A[1][1] = A[R][C] = 0
Time Limit: 1 second
Sample Input 1:
3
2 3
0 1 -3
1 -2 0
2 2
0 1
2 0
3 4
0 -2 -3 1
-1 4 0 -2
1 -2 -3 0
Sample Output 1:
2
1
2
 * 
 * 
 */
import java.util.Arrays;
public class Magic_Grid {

	public static int getMinimumStrength(int[][] grid,int i,int j,int visited[][]) {
		//		System.out.println(i +" "+j);
		if(i<0||j<0) {
			System.out.println(i +" "+j);
			//			return Integer.MAX_VALUE;
		}
		if(i==grid.length-1 && j==((grid[0].length)-1)) {
			//			System.out.println(i +" "+j);
			return 1;
		}
		if(i>=grid.length || j>=grid[0].length) {
			//			System.out.println(i +" "+j);
			return Integer.MAX_VALUE; 
		}
		if(visited[i][j]==1) {
			//			System.out.println(i +" "+j);
			return Integer.MAX_VALUE;
		}
		visited[i][j]=1;
		int bottom=getMinimumStrength(grid, i+1, j, visited);
		int right=getMinimumStrength(grid, i, j+1, visited);
		visited[i][j]=-1;

		int partialAns=Math.min(right, bottom)-grid[i][j];
		if(partialAns<=0)
			partialAns=1;

		return partialAns;

	}
	
	
	public static int getMinimumStrengthIterDP(int[][] grid) {
		int dp[][]=new int[grid.length+1][grid[0].length+1];
		for(int i[]:dp)
			Arrays.fill(i,Integer.MAX_VALUE);
		dp[grid.length-1][grid[0].length-1]=1;
		dp[grid.length-1][grid[0].length-2]=1;
		dp[grid.length-2][grid[0].length-1]=1;
		//System.out.println(dp[0][0]);


		for(int i=0;i<dp.length;i++) { for(int j=0;j<dp[0].length;j++)
			System.out.print(dp[i][j]+"				"); System.out.println(); }


		for(int i=grid.length-1;i>=0;i--)
			for(int j=grid[0].length-1;j>=0;j--){
				if(dp[i][j]==Integer.MAX_VALUE){
					int partialAns=Math.min(dp[i][j+1], dp[i+1][j])-grid[i][j];
					if(partialAns<=0)
						partialAns=1;
					dp[i][j]=partialAns;
				}

			}
		
	System.out.println("----------------------------------");
	
	for(int i=0;i<dp.length;i++) { for(int j=0;j<dp[0].length;j++)
		System.out.print(dp[i][j]+"				"); System.out.println(); }
		return dp[0][0];
	}

	public static void main(String[] args) {
		int grid[][]= {
				{0 ,1,-3},
				{1,-2,0}
		};
		int visited[][]=new int[grid.length][grid[0].length];
		for(int i=0;i<visited.length;i++)
			Arrays.fill(visited[i], -1);
		//		System.out.println(getMinimumStrength(grid, 0, 0,visited));
		System.out.println(getMinimumStrengthIterDP(grid));
	}

}
