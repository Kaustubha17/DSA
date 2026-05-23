package frazSheet.Arrays;

import java.util.Arrays;

public class Merge_Intervals {



	public static int[][] merge(int[][] intervals) {

		int start[]=new int[intervals.length];
		int end[]=new int[intervals.length];
		for(int i=0;i<intervals.length;i++) {
			start[i]=intervals[i][0];
		}
		for(int i=0;i<intervals.length;i++) {
			end[i]=intervals[i][1];
		}
		Arrays.sort(start);
		Arrays.sort(end);
		boolean included[]=new boolean[intervals.length];
		int ans[][]=new int[intervals.length][2];
		int k=0;
		for(int i=0;i<intervals.length;i++) {
			int startPoint=start[i];
			int endPoint=end[i];
			if(!included[i]) {

				for(int j=i+1;j<start.length;j++) {
					if(start[j]<endPoint) {
						endPoint=end[j];
						included[j]=true;
					}

				}
				int newPair[]={startPoint,endPoint};
				ans[k]= newPair;
				k++;
			}

		}
		int temp[][]=ans;
		ans=new int[k][2];
		for(int i=0;i<k;i++) {
			ans[i]=temp[i];
		}
		return ans;
	}

	public static void main(String[] args) {
		int arr[][]= {{1,3},{2,6},{8,10},{15,18}};

		int ans[][]=merge(arr);
		for(int a[]:ans) {
			for(int i:a) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
	}





}
