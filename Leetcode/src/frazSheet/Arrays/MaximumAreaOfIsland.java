package frazSheet.Arrays;

public class MaximumAreaOfIsland {

	public int maxAreaOfIslandDFS(int[][] grid,boolean visited[][],int i,int j) {

		if(i<0||j<0||i>=grid.length||j>=grid[0].length)
			return 0;
		
		if(grid[i][j]==0)
			return 0;
		if(visited[i][j])
			return 0;
		
//		System.out.println("i: "+i+" j: "+j);
		
		visited[i][j]=true;
		int top=maxAreaOfIslandDFS(grid, visited, i-1, j);
		int right=maxAreaOfIslandDFS(grid, visited, i, j+1);
		int left=maxAreaOfIslandDFS(grid, visited, i, j-1);
		int down=maxAreaOfIslandDFS(grid, visited, i+1, j);
		
		return 1+top+right+left+down;
	
	}
	
	public int maxAreaOfIsland(int[][] grid) {

		boolean visited[][]=new boolean [grid.length][grid[0].length];
		int ans=0;
		
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[0].length;j++) {
				if(visited[i][j]||grid[i][j]==0)
					continue;
				
				int temp= maxAreaOfIslandDFS(grid, visited, i, j);
				
				ans=Math.max(ans,temp);
					
				
			}
		}
		

	
	return ans;
	}

	public static void main(String[] args) {
		int grid[][]= {
				{0,0,1,0,0,0,0,1,0,0,0,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},
				{0,1,1,0,1,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,0,0,1,0,1,0,0},{0,1,0,0,1,1,0,0,1,1,1,0,0}
				,{0,0,0,0,0,0,0,0,0,0,1,0,0},{0,0,0,0,0,0,0,1,1,1,0,0,0},{0,0,0,0,0,0,0,1,1,0,0,0,0}
		};

		System.out.println(new MaximumAreaOfIsland().maxAreaOfIsland(grid));


	}}
