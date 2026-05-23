package frazSheet.Arrays;

public class SpiralMatrix {

	
	public static void printSpiralMatrix(int[][]matrix) {
		
		//column
		int rs=0;
		int re=matrix[0].length-1;
		//row
		int ds=0;
		int de=matrix.length-1;
		
		while(rs<=re && ds<=de) {
			for(int i=rs;i<=re;i++) {
				System.out.print("Left to Right "+matrix[ds][i]+" ,");
			}
			ds++;
			System.out.println();
			for(int i=ds;i<=de;i++) {
				System.out.print("Top to down "+matrix[i][re]+", ");
			}
			re--;
			System.out.println();
			if(!(ds>de)&&!(rs>re)) {
			for(int i=re;i>=rs;i--) {
				System.out.print("Right to Left "+matrix[de][i]+", ");
			}
			de--;
			System.out.println();
			for(int i=de;i>=ds;i--) {
				System.out.print("Down to Top "+ matrix[i][rs]+", ");
			}
			
			rs++;
			}
			System.out.println();
			System.out.println("rs: "+rs+" re: "+re+" ds: "+ds+" de: "+de);
			
		}
		
		
	
	}
	public static void main(String[] args) {
		int matrix[][]= {
				{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		printSpiralMatrix(matrix);

	}

}
