
public class ReturnSubsetOfAnArray {

	public static int[][] subsets(int input[],int index) {
		if(input.length<=index) {
			int ans[][]= {{}};
			return ans;
		}

		int partialOutput[][]=subsets(input,index+1);
		//		System.out.println(partialOutput.length);



		int ans[][]=new int[2*partialOutput.length][];

		for(int i=0;i<partialOutput.length;i++)
			ans[i]= partialOutput[i];

		for(int i=0;i<partialOutput.length;i++) {

			int temp[]=new int[partialOutput[i].length+1];
			temp[0]=input[index];

			for(int j=1;j<=partialOutput[i].length;j++) {

				temp[j]=partialOutput[i][j-1];

			}
			ans[i+partialOutput.length]=temp;

		}
		return ans;
	}


	public static int[][] subsets(int input[]) {
		return subsets(input, 0);

	}


	public static void main(String[] args) {
		int arr[]= {1,2,3};
		int ans[][]=subsets(arr);

		for(int i=0;i<ans.length;i++) { int part[]=ans[i]; for(int
				j=0;j<part.length;j++) System.out.print(part[j]+" "); System.out.println(); }



	}

}
