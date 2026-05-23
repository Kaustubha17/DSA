package Tries_And_Huffman_Coding;

import java.util.ArrayList;

public class PatternMatching {

public static boolean patternMatching(ArrayList<String> vect, String pattern) {
    Trie t=new Trie();
    for(int i=0;i<vect.size();i++) {
    	int j=0;
    	while(j<vect.get(i).length()) {
    		t.add(vect.get(i).substring(j));
    		j++;
    	}
    	return t.search(pattern);
    }
	
	return false;
	}
	
	public static void main(String[] args) {
		ArrayList<String>s=new ArrayList<>();
		s.add("ABC");
		s.add("DEF");
		s.add("GHI");
		s.add("CBA");
		System.out.println(patternMatching(s,"BC"));

	}

}
