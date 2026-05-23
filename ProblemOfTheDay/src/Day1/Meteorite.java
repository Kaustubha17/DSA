package Day1;

public class Meteorite {

	public static int add(int pos[],int start,int end,int size){
		int maxHeight=0;
		int start2=start;
		while(start2<end) {
			if(pos[start2]>maxHeight) {
				maxHeight=pos[start2];
			}
			
			start2++;
		}
	int newHeight=maxHeight+size;
		while(start!=end) {
			pos[start]=newHeight;
			start++;
		}
		int max=0;
		int i=0;
		while(i<pos.length) {
			if(pos[i]>max)
				max=pos[i];
			
			
			i++;
		}
		
		return max;
	}

	public static int[] ninjaAndMeteorites(int n, int[][] meteorites) {
		int pos[]=new int[20];
		int currMax[]=new int[n];
		int i=0;
		while(n!=0){
			int xCordStart=meteorites[i][0];
			int size=meteorites[i][1];
			int xCordEnd=xCordStart+size;
			currMax[i]=add(pos,xCordStart,xCordEnd,size);
			
			i++;
			n--;
//			System.out.println("Pos");
//			for(int x:pos) {
//				System.out.print(x+" ");
//			}
//			System.out.println();
		}
		return currMax;

	}
	public static void main(String[] args) {
int arr[][]= {
		{100, 100},
		{200, 100},
		
				};
int result[]=ninjaAndMeteorites(2,arr);
for(int i:result) {
	System.out.print(i+" ");
}
		
	}

}
