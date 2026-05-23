package graphs;

import java.util.Arrays;

public class LargestPiece {


	public static int dfs(int[][] edge, int i,int j,boolean visited[][],int partialSum[][]) {
		if(i<0||j<0||i>=edge.length||j>=edge.length)
			return 0;
		if(visited[i][j])
			return 0;
		if(edge[i][j]==0) {
			partialSum[i][j]=0;
			return 0;
		}
		if(partialSum[i][j]!=-1)
			return partialSum[i][j];

		visited[i][j]=true;

		int top=dfs(edge,i-1,j,visited,partialSum);
		int bottom=dfs(edge,i+1,j,visited,partialSum);
		int right=dfs(edge,i,j+1,visited,partialSum);
		int left=dfs(edge,i,j-1,visited,partialSum);
//		visited[i][j]=false;
		int ans=1+bottom+right+left+top;
		partialSum[i][j]=ans;
		return ans;

	}

	public static int dfs(String[] edge, int n) {
		int cake[][]=new int[n][n];
		for(int i=0;i<n;i++) {
			int k=0;
			for(int j=0;k<n;j++)
			{
				if(edge[i].charAt(j)!=' ')
				{
					cake[i][k]=(int)(edge[i].charAt(j)-'0');
					k++;
				}
			}
		}


		boolean visited[][]=new boolean [n][n];
		for(int i=0;i<n;i++)
			Arrays.fill(visited[i], false);
		int ans=Integer.MIN_VALUE;

		int partialSum[][]=new int [n][n];

		for(int i=0;i<n;i++)
			Arrays.fill(partialSum[i], -1);

		for(int i=0;i<n;i++) {
			for(int j=0;j<n;j++) {
				int temp=0;
				if(cake[i][j]==1) {
					temp= dfs(cake,i,j,visited,partialSum);
				}
				if(temp>ans)
					ans=temp;
			}
		}
		return ans;
	}


	public static void main(String[] args) {
		String arr[]= {	"1 0 0",
				"0 1 0",
				"0 1 0"
		};
		System.out.println(dfs(arr,arr.length));


	}}
