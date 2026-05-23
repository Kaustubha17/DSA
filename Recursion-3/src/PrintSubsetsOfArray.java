
public class PrintSubsetsOfArray {

	public static void printSubsets(int input[],int[] resultSoFar,int index) {
		if(input.length<=index) {
			for(int i:resultSoFar)
				System.out.print(i+" ");
			System.out.println();
			
			return;
		}
		printSubsets(input, resultSoFar,index+1);
		int temp[]=resultSoFar;
		resultSoFar=new int[temp.length+1];
		
		for(int i=0;i<temp.length;i++)
			resultSoFar[i]=temp[i];
		resultSoFar[temp.length]=input[index];
		
		printSubsets(input, resultSoFar, index+1);

	}


	public static void main(String[] args) {
		int a[]= {1,2};
		int b[]= {};
		printSubsets(a,b,0);
	}

}
