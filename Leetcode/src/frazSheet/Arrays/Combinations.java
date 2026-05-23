package frazSheet.Arrays;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public void rec(List<List<Integer>> ans,int n,int k,List<Integer>temp,int startValue) {
		if(k==0) {
			ans.add(new ArrayList<>(temp));
			return;
		}
		
		for(int i=startValue;i<=n;i++) {
			temp.add(i);
			k=k-1;
			rec(ans,n,k,temp,i+1);
			temp.remove(temp.size()-1);
			k=k+1;
		}
		
	}
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>>ans=new ArrayList<>();
		rec(ans,n,k,new ArrayList<Integer>(),1);
		return ans;
	}

	public static void main(String[] args) {
		int n=4;
		int k=1;
		List<List<Integer>>ans=new Combinations().combine(n,k);
		for(List<Integer>partialAns:ans) {
			for(int elem:partialAns) {
				System.out.print(elem);
			}
			System.out.println();
		}
	}

}
