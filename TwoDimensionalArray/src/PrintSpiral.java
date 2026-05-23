
public class PrintSpiral {

	
	public static void spiralPrint(int matrix[][]){
		int rows=matrix.length;
		int cols=matrix[0].length;
		int elements=0;
		int rs=0;			//row start
		int re=rows-1;		//row end
		int cs=0;			//column start
		int ce=cols-1;		//col end
	
		while(elements<=(rows*cols)) {
			if(rs>re)
				break;
			if(cs>ce)
				break;
			
//		for left to right direction ----->
			for(int j=cs;j<=ce;j++) {
			System.out.println(matrix[rs][j]+" ");
			elements++;
		}
		rs++;
//			for downward direction 
		for(int i=rs;i<=re;i++) {
			System.out.println(matrix[i][ce]);
			elements++;
		}
		ce--;
//		for right to left direction <-----
		if(cs<=ce) {
		for(int j=ce;j>=cs;j--) {
			System.out.println(matrix[re][j]);
			elements++;
		}
		re--;
		}
//		for bottom to top direction
		if(rs<=re) {
		for(int i=re;i>=rs;i--) {
			System.out.println(matrix[i][cs]);
			elements++;
		}
		cs++;
		}
		
			
			
		}
		
	}
	
	public static void main(String[] args) {
		int arr[][]= {
						{1,2,3,4},
						{5,6,7,8},
						{9,10,11,12},
						{13,14,15,16}
					};
		spiralPrint(arr);

	

}}
