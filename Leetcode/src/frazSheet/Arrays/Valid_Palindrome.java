package frazSheet.Arrays;

import java.util.HashMap;

public class Valid_Palindrome {
	public HashMap<String, Integer>map=new HashMap<>();
	public boolean isPalindrome(String s) {
		s=  s.toLowerCase();
		for(int i=0;i<26;i++) {
			char mapFr=(char)(i+97);
			map.put(mapFr+"", 1);
		}
		for(int i=0;i<10;i++) {
			String num=i+"";
			map.put(num, 1);
		}

		int i=0;
		int j=s.length()-1;
		while(i<j) {
			String iThChar=s.charAt(i)+"";
			String jThChar=s.charAt(j)+"";
			if(map.containsKey(jThChar)&&map.containsKey(iThChar)) {
				if(iThChar.equals(jThChar)) {
					i++;
					j--;
					continue;
				}
				return false;
			}

			if(!map.containsKey(iThChar)) {
				i++;
			}
			if(!map.containsKey(jThChar)) {
				j--;
			}



		}


		return true;
	}

	public static void main(String[] args) {
		String s=" la";
		System.out.println(new Valid_Palindrome().isPalindrome(s));
	}

}
