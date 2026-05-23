package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Combination_Sum_3 {

	public void recCombo(List<List<Integer>>ans,List<Integer>temp,int k,int n,int index,int originalN) {

		if(k==0 && n==0) {
			ans.add(new ArrayList<>(temp));
		}
		if((k<0||n<0)||(k==0&&n!=0)||(n==0&&k!=0)) {
			return;
		}
		for(int i=index;i<originalN&&i<10;i++) {
			temp.add(i);
			recCombo(ans, temp, k-1, n-i, i+1, originalN);
			temp.remove(temp.size()-1);
		}
		
	}

	public List<List<Integer>> combinationSum3(int k, int n) {

		List<List<Integer>>ans=new ArrayList<>();
		recCombo(ans, new ArrayList<>(), k, n,1,n);
		return ans;
	}

	public static void main(String[] args) {
		int k=2;
		int n=18;
		List<List<Integer>>ans=new Combination_Sum_3().combinationSum3(k, n);

		for(List<Integer>partialAns:ans) {
			for(int elem:partialAns) {
				System.out.print(elem);
			}
			System.out.println();
		}
	}

}
