package frazSheet.Arrays;

import java.lang.reflect.WildcardType;

public class MaximumPointsFromCards {

	public int maxScore(int[] cardPoints, int k,int i,int j) {
		if(k<=0)
		{
			return 0;
		}
		if(i>j) {
			return 0;
		}
		int sum1=cardPoints[i]+ maxScore(cardPoints, k-1, i+1, j);
		int sum2=cardPoints[j]+maxScore(cardPoints, k-1,i,j-1);
		
		

		return Math.max(sum1, sum2);
	}
	
	public int maxScore(int[] cardPoints, int k) {
//		return maxScore(cardPoints, k,0,cardPoints.length-1);
		
		int ans=Integer.MIN_VALUE;
		
	
		int n=cardPoints.length;
		int windowSize=n-k;

		int sum[]=new int[n];
		sum[0]=cardPoints[0];
		
		
		for(int i=1;i<n;i++) {
			sum[i]=sum[i-1]+cardPoints[i];
		}
		
		if(k>=n)
			return sum[n-1];
		
		int i=0;
		int j=i+windowSize-1;
//		System.out.println(j);
		while(j<n) {
			int startSum;
			if(i==0) {
				startSum=0;
			}
			else {
				startSum=sum[i-1];
			}
			int endSum;
			if(j==n-1) {
				endSum=0;
			}
			else {
				
				endSum=sum[n-1]-sum[j];

			}
			
			
			ans=Math.max(ans ,startSum+ endSum);
			
			i++;
			j++;
		}
		
		
		
		
		return ans;
		
	}

	public static void main(String[] args) {
		MaximumPointsFromCards maxPoint=new MaximumPointsFromCards();
//		int arr[]= {53,14,91,35,51,9,80,27,6,15,77,86,34,62,55,45,91,45,23,75,66,42,62,13,34,18,89,67,93,83,100,14,92,73,48,2,47,93,99,100,88,84,48};
		int arr[]= {11,49,100,20,86,29,72};
				
		int k=4;
		System.out.println(maxPoint.maxScore(arr, k));

		/*
		 * 
[53,14,91,35,51,9,80,27,6,15,77,86,34,62,55,45,91,45,23,75,66,42,62,13,34,18,89,67,93,83,100,14,92,73,48,2,47,93,99,100,88,84,48]
43
		 */
	}

}
