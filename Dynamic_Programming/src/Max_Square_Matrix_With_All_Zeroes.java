/*
 *	Given an NxM matrix that contains only 0s and 1s,
 *  find out the size of the maximum square sub-matrix with all 0s.
 *  You need to return the size of the square matrix with all 0s.
 *  */

public class Max_Square_Matrix_With_All_Zeroes {

	public static int findMaxSquareWithAllZeros(int[][] input){
		int rows=input.length;
		int columns=input[0].length;
		int maxZeroFreq[][]=new int [rows][columns];
		/*
		 * 		1 			1 -->Based on values in input array because at max only one square can be formed
		 * 		
		 * 		1 		maxZeroFreq[i,j]=Max(maxZeroFreq[i-1,j-1],maxZeroFreq[i-1,j],maxZeroFreq[i,j-1])+1 --> if input[i][j]=0 else 0
		 * 		
		 * 		|
		 * 		|
		 * 		V
		 * 	Based on values in input array
		 * 
		 */

		//Filling first column  and first row
		int maxAns=0;
		for(int i=0;i<rows;i++)
			if(input[i][0]==0) {
				maxZeroFreq[i][0]=1;
			maxAns=1;	
			}
			else
				maxZeroFreq[i][0]=0;


		for(int j=0;j<columns;j++)
			if(input[0][j]==0) {
				maxZeroFreq[0][j]=1;
			maxAns=1;
			}
			else
				maxZeroFreq[0][j]=0;

		//		Filling rest of matrix
		
		for(int i=1;i<rows;i++)
			for(int j=1;j<columns;j++) {
				if(input[i][j]==1)
					maxZeroFreq[i][j]=0;
				else {
					maxZeroFreq[i][j]=Math.min(maxZeroFreq[i-1][j-1], Math.min(maxZeroFreq[i-1][j], maxZeroFreq[i][j-1]))+1;
					maxAns=Math.max(maxAns, maxZeroFreq[i][j]);
				}
			}


		return maxAns;
	}


	public static void main(String[] args) {
		int arr[][]= {
				{1, 0, 0},
				
				{1, 0, 0},
				{1 ,1 ,1}
		};
System.out.println(findMaxSquareWithAllZeros(arr));
	}

}
