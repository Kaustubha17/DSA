import java.util.*;
public class MaximumProfit {

	public static int maximumProfit(int budget[]) {
		Arrays.sort(budget);
		int arr[]=new int [budget[budget.length-1]+1];
		int k=1;
		for(int i=budget.length-1;i>=0;i--){
			arr[budget[i]]=k;
			k++;
		}


		int maxProfit=0;
		for(int i=0;i<budget.length;i++) {
			int indexVal=budget[i];
			int temp=arr[indexVal]*indexVal;
			if(temp>maxProfit)
				maxProfit=temp;
		}


		return maxProfit;
	}


	public static void main(String[] args) {
		int arr[]= {30 ,20 ,53 ,14};
		System.out.println(maximumProfit(arr));
	}

}
