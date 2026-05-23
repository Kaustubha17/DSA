package Strings;

public class Flood_Fill {

	public static void helper(int image[][],int sr,int sc,int color,int startColor,boolean visited[][]) {
	if(sr>=image.length||sr<0||sc>=image[0].length||sc<0||visited[sr][sc])
		return;
	if(image[sr][sc]!=startColor)
		return;
	visited[sr][sc]=true;
	image[sr][sc]=color;
	helper(image, sr+1, sc, color, startColor, visited);
	helper(image, sr, sc+1, color, startColor, visited);
	helper(image, sr-1, sc, color, startColor, visited);
	helper(image, sr, sc-1, color, startColor, visited);
		
	}
	
	 public static int[][] floodFill(int[][] image, int sr, int sc, int color) {
	    boolean visited[][]=new boolean[image.length][image[0].length];
	    for(int i=0;i<sr;i++)
	    	for(int j=0;j<sc;j++)
	    		visited[i][j]=false;
		 helper(image,sr,sc,color,image[sr][sc],visited);   
	    
		return image;
	    }
	
	public static void main(String[] args) {
int image[][]= {{1,1,1},{1,1,0},{1,0,1}};
int sr=1;
int sc=1;
int color=2;
int result[][]=floodFill(image, sr, sc, color);
for(int row[]:result) {
	for(int i:row)
		System.out.print(i+" ");
	
	System.out.println();
}	
	}

}
