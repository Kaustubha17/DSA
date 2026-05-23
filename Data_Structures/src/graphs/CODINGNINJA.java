package graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

public class CODINGNINJA {
	public static boolean searchString(String[][]matrix,String[] toBeSearched,int row,int column,int strIndex,int N,int M,boolean[][]visited){

//		System.out.println("row: "+row+" column: "+column);
		if(row<0||row>=N||column<0||column>=M) {

			return false;
		}

		if(strIndex==toBeSearched.length) {

			return true;
		}
		if(visited[row][column]==true) {

			return false;
		}



		if(!matrix[row][column].equals(toBeSearched[strIndex])) {

			return false;			
		}

		visited[row][column]=true;
		boolean top=searchString(matrix,toBeSearched,row-1,column,strIndex+1,N,M,visited);

		boolean down= searchString(matrix,toBeSearched,row+1,column,strIndex+1,N,M,visited);

		boolean right=searchString(matrix,toBeSearched,row,column+1,strIndex+1,N,M,visited);


		boolean left=searchString(matrix,toBeSearched,row,column-1,strIndex+1,N,M,visited);


		boolean bottomRight=searchString(matrix,toBeSearched,row+1,column+1,strIndex+1,N,M,visited);

		boolean bottomLeft= searchString(matrix,toBeSearched,row+1,column-1,strIndex+1,N,M,visited);

		boolean topLeft=searchString(matrix,toBeSearched,row-1,column-1,strIndex+1,N,M,visited);
		boolean topRight=searchString(matrix,toBeSearched,row-1,column+1,strIndex+1,N,M,visited);
		visited[row][column]=false;
		return top||down||right||left||bottomLeft||bottomRight||topLeft||topRight;		


	}



	static	int solve(String[] Graph , int N, int M)
	{
		String [][]matrix=new String[N][M];
	
		boolean visited[][]=new boolean[N][M];
		int cPosition[][]=new int [N][M];

		for(int i=0;i<N;i++)
			Arrays.fill(cPosition[i], 0);

		for(int i=0;i<N;i++)
			Arrays.fill(visited[i], false);
		
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
			{
				matrix[i][j]=Graph[i].charAt(j)+"";
				if(Graph[i].charAt(j)=='C')
					cPosition[i][j]=1;
			}
		

		String codingNinja[]= {"C","O","D","I","N","G","N","I","N","J","A"};
		for(int i=0;i<N;i++)
			for(int j=0;j<M;j++)
				if(cPosition[i][j]==1) {
System.out.println("i: "+i+" j: "+j);					
					if(searchString(matrix,codingNinja,i,j,0,N,M,visited))
						return 1;
					}

		return 0;


	}
	public static void main(String[] args) {
		String[]arr= {
				"CXNAXC",
				"OIJNOD",
				"DXNGIX",

		};



		//				String arr[]= {"ACNINGNIDOC"};
		int n=arr.length;
		int m=arr[0].length();

		System.out.println(solve(arr,n,m));
	}

}
