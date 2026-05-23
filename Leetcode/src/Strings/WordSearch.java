package Strings;

public class WordSearch {

	public static boolean helper(char[][] board, String word,boolean[][]visited,int cr,int cc) {
		if(word.length()==0)
			return true;
		if(cr>=board.length||cr<0||cc>=board[0].length||cc<0||visited[cr][cc]) {
		
			return false;
		}
		if(board[cr][cc]!=word.charAt(0))
			return false;

		System.out.println(cr+" "+cc);
		
		visited[cr][cc]=true;
		boolean right=helper(board, word.substring(1), visited, cr, cc+1);
		boolean left=helper(board, word.substring(1), visited, cr, cc-1);
		boolean top=helper(board, word.substring(1), visited, cr-1, cc);
		boolean bottom=helper(board, word.substring(1), visited, cr+1, cc);
		visited[cr][cc]=false;
		return  right||left||top||bottom;



	}
	public static boolean exist(char[][] board, String word) {
		boolean visited[][]=new boolean[board.length][board[0].length];
		makeVisitedFalse(visited);

		for(int i=0;i<board.length;i++)
			for(int j=0;j<board[0].length;j++) {
				if(helper(board, word, visited, i, j))
					return true;
				makeVisitedFalse(visited);

			}
		return false;


	}
	private static void makeVisitedFalse(boolean[][] visited) {
		for(int i=0;i<visited.length;i++)
		{
			for(int j=0;j<visited[0].length;j++)
				visited[i][j]=false;
		}
	}
	public static void main(String[] args) {
		/*
		 * char board[][]={ {'A','B','C','E'}, {'S','F','E','S'}, {'A','D','E','E'}
		 * 
		 * };
		 */	
		char board[][]={
				{'A'}

		};
		String word = "A";

		System.out.println(exist(board, word));
	}

}
