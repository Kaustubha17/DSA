
public class WavePrint {
public static void wavePrint(int mat[][]){
        
        int rows=mat.length;
        if(rows==0)
            return;
        
        int cols=mat[0].length;
        if(cols==0)
            return;
        
        for(int i=0;i<cols;i++){
            for(int j=0;j<rows;j++){
                System.out.print(mat[j][i]+" ");
            }
            if(i+1<cols){
                i=i+1;
                int j=rows-1;
                while(j>=0){
                     System.out.print(mat[j][i]+" ");
                    j--;
                }
                    
                }
            else{
                break;
            }
        }
    
        
	}
	public static void main(String[] args) {
		int arr[][]= {	{1},
						{5},
						{9}};
		
		wavePrint(arr);

	}

}
