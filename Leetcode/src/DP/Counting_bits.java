package DP;

public class Counting_bits {

	public static int findNumberOf1(int n) {
		int numberOf1=0;
		while(n>0) {
			int a=n&1;
			n=n>>1;
			//			System.out.println(a);
			if(a==1)
				numberOf1++;
		}


		return numberOf1;

	}

	public static int[] countBits(int n) {

		int arr[]=new int[n+1];
		int i=1;
		while(i<=n) {

			arr[i]=findNumberOf1(i);
			i++;

		}
		return arr;
	}

	public static void main(String[] args) {
				int ans[]=countBits(5);

				for(int i:ans)
					System.out.print(i+" ");

	}

}
