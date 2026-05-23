package backtracking;

public class PrintRatInAMazePath {

	public static void printPathForRat(int[][]maze) {
		int n=maze.length;
		int path[][]=new int [n][n];
		
		findPath(maze,0,0,path);
		
		
	}
	
	public static boolean findPath(int maze[][],int row,int col,int path[][]) {
		if(row<0||row>=maze.length||col<0||col>=maze.length||path[row][col]==1||maze[row][col]==0)
			return false;
		
	
		path[row][col]=1;
		
		if(row==maze.length-1 && col==maze.length-1)
		{
			
			for(int i=0;i<path.length;i++) {
				for(int j=0;j<path.length;j++) {
			System.out.print(path[i][j]+" ");	
				}
				System.out.println();
			}
			System.out.println();
			path[row][col]=0;
			return true;
		}
		boolean top=findPath(maze, row-1, col, path);
		boolean bottom=findPath(maze, row+1, col, path);
		boolean right=findPath(maze, row, col+1, path);
		boolean left=findPath(maze, row, col-1, path);
		path[row][col]=0;
		return top||bottom||right||left;
		
		
	}
	
	public static void main(String[] args) {

		int maze[][]= {
				{1,1,1},
				{1,1,0},
				{0,1,1}
			};
		
				
		printPathForRat(maze);
	}

}
