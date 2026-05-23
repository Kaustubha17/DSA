package Strings;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsPhoneNumber {

	String constKeyPad[]= {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

	public List<String> helper(String digits,List<String>pAns) {
		if(digits.length()==0) {
			return pAns;
		}

		
		int firstDigit=Integer.parseInt(digits.substring(0, 1));
		
		List<String>ppAns=new ArrayList<>();
		
		String prefix=constKeyPad[firstDigit];
		
		for(int i=0;i<constKeyPad[firstDigit].length();i++) {
			for(String perc:pAns) {
				ppAns.add(perc+prefix.charAt(i));		
			}
}
		return helper(digits.substring(1), ppAns);


	}

	public List<String> letterCombinations(String digits) {
		List<String>pAns=new ArrayList<>();
		pAns.add("");
		return helper(digits,pAns);		
	}
	public static void main(String[] args) {

		List<String>ans=new LetterCombinationsPhoneNumber().letterCombinations("2347");

		for(String s:ans) {
			System.out.println(s);
		}

	}

}
