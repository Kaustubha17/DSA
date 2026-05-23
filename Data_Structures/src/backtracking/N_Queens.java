package backtracking;

public class N_Queens {


	public static boolean queenCanBePlaced(int row,int col,int board[][],int queenPlaced[][]) {
		if(row<0||col<0)
			return false;
		if(row>=board.length)
			return false;
		if(col>=board[0].length)
			return false;

		/*
		 * for(int i=0;i<board.length;i++) { for(int j=0;j<board.length;j++) {
		 * System.out.print(queenPlaced[i][j]+" "); } System.out.println(); }
		 * System.out.println();
		 */

		//		checking if any queen is in top direction
		int i=row-1;
		int j=col;
		while(i>=0) {

			if(queenPlaced[i][col]==1)
				return false;
			i=i-1;
		}

		//		checking if any queen is in bottom direction
		/*
		i=row+1;
		while(i<board.length) {

			if(queenPlaced[i][col]==1)
				return false;
			i=i+1;
		}
		*/
		//		checking if any queen is in left direction
		j=j-1;
		while(j>=0) {

			if(queenPlaced[row][j]==1)
				return false;
			j=j-1;
		}
		//		checking if any queen is in right direction
/*
		j=col+1;
		while(j<board[row].length) {

			if(queenPlaced[row][j]==1)
				return false;
			j=j+1;
		}
*/
		//		checking if any queen is in top-left diagonal direction
		i=row-1;
		j=col-1;
		while(i>=0&&j>=0) {

			if(queenPlaced[i][j]==1)
				return false;

			i=i-1;
			j=j-1;
		}
		//		checking if any queen is in top-right diagonal direction
	
		i=row-1;
		j=col+1;
		while(i>=0&&j<board[row].length) {

			if(queenPlaced[i][j]==1)
				return false;
			i=i-1;
			j=j+1;
		}
		
		
		//		checking if any queen is in bottom-left diagonal direction
	
		/*
		i=row+1;
		j=col-1;
		while(i<board.length&&j>=0) {

			if(queenPlaced[i][j]==1)
				return false;

			i=i+1;
			j=j-1;
		}
		*/
		
		//		checking if any queen is in bottom-right diagonal direction
		
		/*
		i=row+1;
		j=col+1;
		while(i<board.length&&j<board[row].length) {

			if(queenPlaced[i][j]==1)
				return false;
			i=i+1;
			j=j+1;
		}
*/


		return true;
	}

	public static void nQueens(int[][]board,int row,int queenPlaced[][]) {

		if(row==board.length) {
			for(int i=0;i<board.length;i++)
			{
				for(int j=0;j<board.length;j++) {
					System.out.print(queenPlaced[i][j]+" ");
				}
				System.out.println();
			}
System.out.println();

			return;
		}

		int ans=0;
		for(int i=0;i<board.length;i++) {

			if(queenCanBePlaced(row, i, board,queenPlaced))
			{
				queenPlaced[row][i]=1;
			nQueens(board, row+1,queenPlaced);

				queenPlaced[row][i]=0;
			}


		}

		
	}

	public static void nQueenSolution(int n) {

		int queenPlaced[][]=new int [n][n];
		int board[][]= new int [n][n];

		for(int i=0;i<n;i++)
			for(int j=0;j<n;j++) {
				queenPlaced[i][j]=0;
				board[i][j]=0;
			}

		nQueens(board, 0,queenPlaced);
	}

	public static void main(String[] args) {
nQueenSolution(4);
	}

}
