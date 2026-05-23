package Stacks;

import java.util.Stack;

public class StockPlan {

	public static int[] stockSpan(int[] price) {
		int res[]=new int[price.length];
		Stack<Integer>s=new Stack<>();
		for(int i=0;i<price.length;i++) {
			if(s.size()==0) {
				s.push(i);
				res[i]=1;
			}
			else {
				if(price[s.peek()]<price[i]) {
					s.pop();
					s.push(i);
					res[i]=i+1;
				}
				else {
					
					int counter=1;
					int startIdx=i;
					int startIdx1=i-1;
					while(price[startIdx]>price[startIdx1]) {
						counter++;
						startIdx1--;
					}
					res[i]=counter;
				}
			}
		}
		


		return res;

	}

	public static void main(String[] args) {

		int arr[]= {60, 70, 80, 100, 90, 75, 80, 120};
		int res[]=stockSpan(arr);
		for(int i:res) {
			System.out.print(i+" ");
		}
	}

}
