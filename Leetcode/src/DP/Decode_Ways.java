package DP;

import java.util.HashMap;


public class Decode_Ways {

	public static int helper(String s,String resultSoFar) {
		if(s.length()==0) {

			return 1;
		}

		String firstDigit=s.substring(0,1);
		String secondDigits="";
		if(s.length()>=2)
			secondDigits=s.substring(0, 2);

		int a=0;
		int b=0;
		if(map.containsKey(firstDigit))
			 a=helper(s.substring(1),resultSoFar+firstDigit);
		if(map.containsKey(secondDigits)) {
			if(s.length()>2)
				b=helper(s.substring(2),resultSoFar+secondDigits);
			else if(s.length()==2)
				b=1;
				
		}
			return a+b;
		 
	}

	public static int numDecodings(String s) {
		return helper(s,"");
	}

	public static HashMap<String, Character>map=new HashMap<>();

	public static void main(String[] args) {

		for(int i=1;i<=26;i++) {
			map.put(i+"", (char)(64+i));
		}
//System.out.println("111".length());


	}}
