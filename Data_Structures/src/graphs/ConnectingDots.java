package graphs;

import java.util.Arrays;

public class ConnectingDots {

	public static boolean checkIfSolutionExists(
			String[][] board , int row, 
			int col,boolean visited[][],int startRow,
			int startCol,String firstChar,
			int elementsCurrentlyCircular,int N,int M) {
		
		
		if(row<0||row>=N||col<0||col>=M)
			return false;
		if(!board[row][col].equals(firstChar))
			return false;
		if(visited[row][col]) {
			if(elementsCurrentlyCircular>=4 && row==startRow && col==startCol)
				return true;
			else
			return false;
		}
		visited[row][col]=true;
		boolean down=checkIfSolutionExists(board,row+1,col,visited,startRow,startCol,firstChar,elementsCurrentlyCircular+1,N,M);
		boolean right=checkIfSolutionExists(board,row,col+1,visited,startRow,startCol,firstChar,elementsCurrentlyCircular+1,N,M);
		boolean top=checkIfSolutionExists(board,row-1,col,visited,startRow,startCol,firstChar,elementsCurrentlyCircular+1,N,M);
		boolean left=checkIfSolutionExists(board,row,col-1,visited,startRow,startCol,firstChar,elementsCurrentlyCircular+1,N,M);
		visited[row][col]=false;
		return down||right||top||left;
	}
	
	
	public static int solve(String[] board , int n, int m)
	{
		String matrix[][]=new String[n][m];
		for(int i=0;i<n;i++) {
			for(int j=0;j<m;j++) {
				matrix[i][j]=board[i].charAt(j)+"";
			}
		}
		
		boolean visited[][]=new boolean[n][m];
		
		for(int i=0;i<n;i++)
			Arrays.fill(visited[i], false);
		
		for(int i=0;i<n;i++)
			for(int j=0;j<m;j++)
		if(checkIfSolutionExists(matrix,i,j,visited,i,j,matrix[i][j],0,n,m)) {
			System.out.println(true);
		
//		return 0;
		}
		
		return 0;
	}
	
	
	public static void main(String[] args) {
		String[] board= {
				"AAAA",
				"ABCA",
				"AAAA"
				};

		int n=board.length;
		int m=board[0].length();
		solve(board,n,m);
	}

}
