import java.util.Scanner;

public class InputAndPrinting {

	
	public static void main(String args[]) {
		Scanner s=new Scanner(System.in);
		System.out.println("Enter number of rows");
		int rows=s.nextInt();
		System.out.println("Enter number of columns");
		int columns=s.nextInt();
		int arr[][]=new int[rows][columns];
		for(int i=0;i<rows;i++)
			for(int j=0;j<columns;j++) {
				System.out.println("Enter "+i+1+" row and "+j+1+"column value" );
				arr[i][j]=s.nextInt();
	}
		for(int i=0;i<rows;i++) {
			for(int j=0;j<columns;j++) {
				System.out.print(arr[i][j]);
			}
			System.out.println();
		}
		
		
	 arr = new int [2][2]; 
	    for (int i = 0; i < 2; i++) { 
	        for (int j = 0; j < 2; j++) { 
	            System.out.print(arr[i][j] + " "); 
	        } 
	    } 
		
		
		
		
		
	}
}
