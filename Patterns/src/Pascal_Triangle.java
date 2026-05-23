
import java.util.ArrayList;

import java.util.List;

public class Pascal_Triangle {
	 public static List<List<Integer>> generate(int numRows) {
		 List<List<Integer>>ans=new ArrayList<>();
	        for(int i=0;i<numRows;i++){
	            List<Integer>partialAns=new ArrayList<>();
	            for(int j=0;j<=i;j++){
	                if(j==0||i==j) {
	                	partialAns.add(1);
	                }else {
	                	partialAns.add(j, ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
	                }
	            }
	            ans.add(partialAns);
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		 List<List<Integer>>ans=generate(5);
		 for(int i=0;i<ans.size();i++) {
			 for(int j=0;j<ans.get(i).size();j++) {
				 System.out.print(ans.get(i).get(j)); 
			 }
		 
		System.out.println();
	}

}}
