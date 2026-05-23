package Strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Max_Length_of_concatenated_String_with_unique_characters {
	public static boolean hasUniqueChars(String str) {
		HashMap<Character, Integer>map=new HashMap<>();
		for(int i=0;i<str.length();i++) {
			if(map.containsKey(str.charAt(i)))
				return false;
			else {
				map.put(str.charAt(i), 1);
			}

		}
		return true;

	}

	public static int helper(List<String> arr,int currIndex,int currMaxLength,String stringSoFar) {
if(currIndex>=arr.size())
	return stringSoFar.length();
		String temp=stringSoFar;
		stringSoFar+=arr.get(currIndex);
		if(hasUniqueChars(stringSoFar))
		{ int curr=currMaxLength;
			currMaxLength=Math.max(currMaxLength, stringSoFar.length());
			int a=helper(arr, currIndex+1, currMaxLength, stringSoFar);
			int b=helper(arr, currIndex+1, curr, temp);
			return Math.max(Math.max(a, b), currMaxLength);
		}
		else {
			return Math.max(currMaxLength, helper(arr, currIndex+1, currMaxLength, temp));
		}
		
	}
	public static int maxLength(List<String> arr) {
		int ans=0;
		for(int i=0;i<arr.size();i++)
		ans=Math.max(ans, helper(arr,i,ans,""));
		
		return ans;		 
	}

	public static void main(String[] args) {
		ArrayList<String>arr=new ArrayList<>();
	
		arr.add("q");
		arr.add("w");
		arr.add("e");
		arr.add("r");
		arr.add("t");
		arr.add("y");
		arr.add("u");
		arr.add("i");
		arr.add("o");
		arr.add("p");
		arr.add("a");
		arr.add("s");
		arr.add("d");
		arr.add("f");
		arr.add("g");
		arr.add("h");
		arr.add("j");
		arr.add("k");
		arr.add("l");
		arr.add("z");
		arr.add("x");
		arr.add("c");
		arr.add("vv");
		
		
		System.out.println(maxLength(arr));
	}

}
