
public class TestProblem1 {
	public static void print(int input[][],int row,int rep) {
		int col=input[0].length;
		while(rep>0) {
			for(int j=0;j<col;j++) {
				System.out.print(input[row][j]+" ");
			}
			System.out.println();
			
			rep--;
		}
		
		
	}
	
	public static void print2DArray(int input[][]) {
		 int row=input.length;
		 if(row==0)
			 return;
		 
		 for(int i=0;i<row;i++) {
			 print(input,i,row-i);
		 }

	}
	
	
	public static void main(String[] args) {
int arr[][]= {
		{1,2,3},
		{4,5,6},
		{7,8,9}
		
};

		
	print2DArray(arr);	

	}

}
