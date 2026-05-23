package test;

import java.util.Arrays;

public class RabbitsMeeting {
	 public static int minimumCost(int n,int []x)
	 {
		 
		 int even=0;
		 int odd=0;
		 for(int i=0;i<n;i++) {
			 if(x[i]%2==0)
				 even++;
			 else
				 odd++;
		 }
			 return Math.min(even, odd);
		 
		 
		
	 }
	public static void main(String[] args) {
		int []x= {74, -70, 78, -12, -58, 78, 88, 48, 68, 98  };
		int m=x.length;
		System.out.println(minimumCost(m, x));

	}
	/*
	 * 10
9
-76 39 -99 -34 63 -71 -11 -25 -85 
7
-8 20 73 39 -41 -46 65 
6
56 -7 -4 48 -56 -11 
10
-79 19 63 55 -42 -70 -29 -99 -96 -93 
5
61 73 77 5 8 
5
-91 54 -48 -100 28 
7
-32 -37 5 44 72 91 81 
10
74 -70 78 -12 -58 78 88 48 68 98 
7
42 -49 30 83 -39 -6 16 
8
-53 -6 -84 -68 82 -21 29 -44 

	 */

}
