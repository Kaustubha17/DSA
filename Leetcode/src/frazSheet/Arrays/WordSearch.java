package frazSheet.Arrays;

public class WordSearch {

public static boolean exist(char[][] board, String word,boolean [][]visited,int row,int col,int index) {
    System.out.println("row: "+row+" col: "+col+" index: "+index);   
    
	if(row>=board.length||row<0||col>=board[0].length||col<0)
        	return false;
        if(visited[row][col])
        	return false;
        if(index==word.length()-1)
        	return word.charAt(index)==board[row][col];
        if(board[row][col]!=word.charAt(index))
        	return false;
        
        visited[row][col]=true;
        boolean bottom=exist(board, word, visited, row+1, col, index+1);
        boolean top=exist(board, word, visited, row-1, col, index+1);
        
        boolean right=exist(board, word, visited, row, col+1, index+1);
        boolean left=exist(board, word, visited, row, col-1, index+1);
        visited[row][col]=false;
        return top||bottom||right||left;
        
        
    }
	
public static boolean exist(char[][] board, String word) {
        
	boolean visited[][]=new boolean[board.length][board[0].length];
	for(int i=0;i<board.length;i++) {
		for(int j=0;j<board[0].length;j++)
			visited[i][j]=false;
	}
	
	
	for(int i=0;i<board.length;i++) {
		for(int j=0;j<board[0].length;j++)
			if(exist(board,word,visited,i,j,0))
				return true;
	}
	
	return false;
    }
	public static void main(String[] args) {
		
		char board[][]= {{'A'}};
		String word="A";
		System.out.println(exist(board,word));
	}

}
