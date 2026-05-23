package Strings;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

	public static boolean queenCanBePlaced(char board[][],int row,int col) {
		if(row>=board.length||col>board[0].length||row<0||col<0)
			return false;
		int cr=row;
		int cc=col;
		//checking rows above
		while(cr>=0) {
			if(board[cr][cc]=='Q') {
				return false;
			}
			cr--;
		}
		cr=row;

		//checking columns left
		while(cc>=0) {
			if(board[cr][cc]=='Q') {
				return false;
			}
			cc--;
		}
		cc=col;

		//checking diagonally
		while(cr>=0&&cc>=0) {
			if(board[cr][cc]=='Q') {
				return false;
			}
			cc--;
			cr--;
		}
		cr=row;
		cc=col;
		while(cc<board[0].length&&cr>=0) {
			if(board[cr][cc]=='Q') {
				return false;
			}
			cc++;
			cr--;
		}

		return true;
	}
	
	static List<List<String>> answer=new ArrayList<>();
	
	public static void helper(char board[][],int row,int col,int n) {
		
		if(n==0) {
//			System.out.println("here");
			addInAnswer(board);
			return;
		}
		if(row>=board.length||col>=board[0].length||row<0||col<0)
			return;
		for(int i=0;i<board[0].length;i++) {
			
			
			if(queenCanBePlaced(board, row, i)) {
				board[row][i]='Q';
				
				
//				 printBoard(board); System.out.println();
				
				helper(board, row+1, 0,n-1);
				board[row][i]='.';
			}
			
		}



	}

	private static void printBoard(char[][] board) {
for(char rows[]:board) {
	for(char val:rows) {
		System.out.print(val+" ");
	}
	System.out.println();
}
		
	}

	private static void addInAnswer(char[][] board) {
		List<String>newSolution=new ArrayList<>();
		for(char[]rows:board)
		{			String 	newrow="";
			for(char val:rows) {
			if(val!='Q')
				newrow+=".";
			else {
				newrow+="Q";
			}
		}
			newSolution.add(newrow);

		}
		answer.add(newSolution);
//		System.out.println("here");
//		printAnswer(answer);
	}

	public static List<List<String>> solveNQueens(int n) {
		
		char board[][]=new char[n][n];
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++)
			{
				board[i][j]='.';
			}
		}
helper(board, 0, 0,n);
		return answer;

	}

	public static void main(String[] args) {
		solveNQueens(4);
		printAnswer(answer);

	}

	private static void printAnswer(List<List<String>> answer) {
		for(List<String>row:answer) {
			for(String val:row)
				System.out.print(val+" ");
			System.out.println();
		}
	}

}
