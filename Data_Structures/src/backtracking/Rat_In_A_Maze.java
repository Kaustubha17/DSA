package backtracking;

public class Rat_In_A_Maze {

	public static int findTotalWays(int [][]maze,int row,int col) {

		//		System.out.println(row+" "+col);
		if(row<0)
			return 0;
		if(col<0)
			return 0;
		if(row>=maze.length)
			return 0;
		if(col>=maze[row].length)
			return 0;
		if(maze[row][col]==0)
			return 0;
		if(maze[row][col]==-1)
			return 0;
		int temp=maze[row][col];

		maze[row][col]=-1;

		if(row==maze.length-1 && col==maze[row].length-1) {
			maze[row][col]=temp;
			return 1;
		}

		int upWays=findTotalWays(maze,row-1,col);

		int downWays=findTotalWays(maze,row+1,col);
		int rightWays=findTotalWays(maze,row,col+1);
		int leftWays=findTotalWays(maze,row,col-1);
		maze[row][col]=temp;

		return upWays+downWays+rightWays+leftWays;
	}


	public static int findTotalWays(int [][]maze) {
		return findTotalWays(maze,0,0);

	}

	public static void main(String[] args) {
		int maze[][]= {
				{1, 1, 0},
				{1, 1,0},
				{1, 1, 1}};


		int answer=findTotalWays(maze);
		for(int i=0;i<maze.length;i++)
		{
			for(int j=0;j<maze[i].length;j++)
				System.out.print(maze[i][j]+" ");

			System.out.println();
		}
		System.out.println(answer);
	}
}
