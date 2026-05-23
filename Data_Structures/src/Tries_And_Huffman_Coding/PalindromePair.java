package Tries_And_Huffman_Coding;

import java.util.ArrayList;

public class PalindromePair {

	static class PalindromeTrieNode{
		char data;
		boolean isPalindrome;
		boolean isTerminal;
		PalindromeTrieNode children[];
		int childCount=0;
		public PalindromeTrieNode(char data) {
			// TODO Auto-generated constructor stub
			this.data=data;
			children=new PalindromeTrieNode[26];
			childCount=0;
			isPalindrome=false;
			isTerminal=false;
		}
	}


	public static String reverseWord(String word) {
		String s="";
		for(int i=word.length()-1;i>=0;i--) {
			s+=word.charAt(i);
		}
		return s;


	}
	public static boolean palindromeCheck(String word) {
		int i=0;
		int j=word.length()-1;
		while(i<j) {
			if(word.charAt(i)!=word.charAt(j))
				return false;

			i++;
			j--;
		}
		return true;
	}

	public static void add(PalindromeTrieNode root,String word) {
		if(word.length()==0) {
			root.isTerminal=true;
			root.isPalindrome=true;
			return;
		}
		int childIndex=word.charAt(0)-'a';
		PalindromeTrieNode child=root.children[childIndex];
		if(child==null) {
			child=new PalindromeTrieNode(word.charAt(0));
			root.children[childIndex]=child;
			root.childCount++;
			child.isPalindrome=palindromeCheck(word);
		}
		if(child!=null && palindromeCheck(word)) {
			child.isPalindrome=true;
		}


		add(child,word.substring(1));


	}

	public static boolean isPalindromePair2(PalindromeTrieNode root,String word) {
		if(word.length()==0) {
			boolean childIsPalindrome=false;
			for(int i=0;i<26;i++)
				if(root.children[i]!=null)
				childIsPalindrome=root.children[i].isPalindrome;
			
			return childIsPalindrome||root.isTerminal;
		}

		int childIndex=word.charAt(0)-'a';
		PalindromeTrieNode child=root.children[childIndex];
		if(child==null)
			return false;

		return isPalindromePair2(child,word.substring(1));

	}

	public static boolean isPalindromePair(ArrayList<String> words) {
		PalindromeTrieNode root=new PalindromeTrieNode('\0');
		PalindromeTrieNode root2=new PalindromeTrieNode('\0');
		for(String word:words) {

			String reversedWord=reverseWord(word);
			add(root,reversedWord);
			add(root2,word);
		}
		for(int i=0;i<26;i++) {
			if(root.children[i]!=null && root.children[i].isPalindrome)
			{
				return true;
			}
		}

		for(String word:words) {

			if(isPalindromePair2(root, word)||isPalindromePair2(root2,reverseWord(word)))
				return true;
		}

		return false;
	}

	public static void main(String[] args) {
		String s[]= {"abcxyx","def","ghi","cba"};
		ArrayList<String>as=new ArrayList<>();
		for(String a:s) {
			as.add(a);
		}
		System.out.println(isPalindromePair(as));


	}

}
