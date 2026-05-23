package frazSheet.Arrays;

public class GameOfLife {
	public static int countTotalNeighbours(int board[][],int i,int j) {
		int ans=0;
		int prevCol=j-1;
		int prevRow=i-1;
		int nextRow=i+1;
		int nextCol=j+1;

		if(prevRow>=0) {
			if(board[prevRow][j]==1) {
				ans++;
			}
		}
		if(nextRow<board.length) {
			if(board[nextRow][j]==1) {
				ans++;
			}
		}
		if(prevCol>=0) {
			if(board[i][prevCol]==1) {
				ans++;
			}
		}
		if(nextCol<board[0].length) {
			if(board[i][nextCol]==1) {
				ans++;
			}
		}

		if(prevCol>=0 && prevRow>=0) {
			if(board[prevRow][prevCol]==1)
				ans++;
		}
		if(nextCol<board[0].length && prevRow>=0) {
			if(board[prevRow][nextCol]==1)
				ans++;
		}
		if(nextCol<board[0].length && nextRow<board.length) {
			if(board[nextRow][nextCol]==1)
				ans++;
		}
		if(prevCol>=0 && nextRow<board.length) {
			if(board[nextRow][prevCol]==1)
				ans++;
		}


		return ans;

	}
	public static void gameOfLife(int[][] board) {
		int prevBoard[][]=new int[board.length][board[0].length];

		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				prevBoard[i][j]=board[i][j];
			}
		}


		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				int numberOfNeighbours=countTotalNeighbours(prevBoard,i,j);

				if(board[i][j]==1) {
					if(numberOfNeighbours<2) {
						board[i][j]=0;
					}
					else if(numberOfNeighbours>3)
						board[i][j]=0;
				}
				else {
					if(numberOfNeighbours==3)
						board[i][j]=1;
				}

			}
		}




	}
	public static void main(String[] args) {
		int board[][]={{0,1,0},{0,0,1},{1,1,1},{0,0,0}};
		gameOfLife(board);

		for(int i[]:board) {
			for(int j:i) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}

}
