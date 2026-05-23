
public class PrintSubsetsSumToK {
public static void printSubsetsSumTok(int input[],int currentIndex,int []resulSoFar, int k) {
		
	if(k<0)
		return;
	if(k==0)	
	{
			for(int i:resulSoFar)
				System.out.print(i);
			
			System.out.println();
			return;
		}
	if(input.length<currentIndex)
		return;
		
		printSubsetsSumTok(input, currentIndex+1, resulSoFar, k);
		int tem[]=resulSoFar;
		resulSoFar=new int[tem.length+1];
		for(int i=0;i<tem.length;i++)
			resulSoFar[i]=tem[i];
		
		resulSoFar[tem.length]=input[currentIndex];
		k=k-input[currentIndex];
		printSubsetsSumTok(input, currentIndex+1, resulSoFar, k);
		
		
		
	}
	
	
	public static void printSubsetsSumTok(int input[], int k) {
		int a[]= {};
		printSubsetsSumTok(input, 0,a , k);
		
	}
	public static void main(String[] args) {
		int a[]= {5,12,3,17,1,18,15,3,17};
		int k=6;
		
	}

}
