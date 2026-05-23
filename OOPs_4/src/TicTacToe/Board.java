package TicTacToe;

public class Board {
	
private char board[][];
private int boardSize=3;
private char plSymbol,p2Symbol;
private int count;
private static final char EMPTY=' ';
public static final int PLAYER1WON=1;
public static final int PLAYER2WON=2;
public static final int DRAW=3;
public static final int INCOMPLETE=4;
public static final int INVALID=5;

public Board(char p1Symbol,char p2Symbol) {
	board=new char[boardSize][boardSize];
	for(int i=0;i<boardSize;i++) {
		for(int j=0;j<boardSize;j++) {
			board[i][j]=EMPTY;
		}
	}
	this.plSymbol=p1Symbol;
	this.p2Symbol=p2Symbol;
	
}

public int getCount() {
	return count;
}

public void setCount(int count) {
	this.count = count;
}
	
	public  int move(char symbol,int x,int y) {
		/* 
		 * 1->Player 1 won
		 * 2->Player 2 won
		 * 3->Draw
		 * 4->Incomplete
		 * 5->Invalid
		 */
		if(x<0||y<0||x>=boardSize||y>=boardSize||board[x][y]!=EMPTY)
			return INVALID;
		
		board[x][y]=symbol;
		count++;
		
//		Row
		if(board[x][0]==board[x][1] && board[x][0]==board[x][2])
		{
			return symbol==plSymbol?PLAYER1WON:PLAYER2WON;
		}
//		Column
		if(board[0][y]==board[1][y] && board[0][y]==board[2][y])
		{
			return symbol==plSymbol?PLAYER1WON:PLAYER2WON;
		}
//		Diagonals
		if( board[0][0]!=EMPTY &&board[0][0]==board[1][1] && board[0][0]==board[2][2])
		{
			return symbol==plSymbol?PLAYER1WON:PLAYER2WON;
		}
		if( board[0][2]!=EMPTY &&board[0][2]==board[1][1] && board[1][1]==board[2][0])
		{
			return symbol==plSymbol?PLAYER1WON:PLAYER2WON;
		}
		
		
		if(count==boardSize*boardSize)
			return DRAW;
		
		
		return INCOMPLETE;
	}
	public void print() {
		System.out.println("-------------New Board---------------");
		System.out.println();
		for(int i=0;i<boardSize;i++) {
			for(int j=0;j<boardSize;j++)
			{
				System.out.print(board[i][j]+" |");
			}
			System.out.println();
		System.out.println("-----------------");
		}
		System.out.println();
		System.out.println("------------- End---------------");
			
		
	}
	

}
