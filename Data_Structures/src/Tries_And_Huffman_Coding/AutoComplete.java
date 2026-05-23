package Tries_And_Huffman_Coding;

import java.util.ArrayList;

public class AutoComplete {

	public static Trie t=new Trie();
	public static TrieNode root=new TrieNode('\0');

	public static void add(TrieNode root,String word) {
		if(word.length()==0) {
			root.isTerminal=true;
			return;
		}
		int childIndex=word.charAt(0)-'a';
		TrieNode child=root.children[childIndex];
		if(child==null) {
			child=new TrieNode(word.charAt(0));
			root.children[childIndex]=child;
			root.childCount++;
		}
		add(child,word.substring(1));

	}
	public static ArrayList<String>ans=new ArrayList<>();
	public static void dfs(TrieNode root,String s) {
		if(root.isTerminal)
		{
			ans.add(s);
//		System.out.println(root.data+" :"+root.childCount);
		if(root.childCount==0 && !ans.contains(s)) {
			ans.add(s);
			return;
		}
		}

		for(int childIndex=0;childIndex<26;childIndex++) {
			TrieNode t=root.children[childIndex];
			if(t!=null) {
				String temp=s;
				s+=t.data;
				dfs(t,s);
				s=temp;
			}
		}

	}

	public static TrieNode search(TrieNode root,String word) {
		if(word.length()==0) {

			return root;
		}

		int childIndex=word.charAt(0)-'a';
		TrieNode child=root.children[childIndex];
		if(child==null) {
			return null;
		}
		return search(child, word.substring(1));
	}

	public static void autoComplete(ArrayList<String> input, String word) {

		for(String words:input) {
			add(root,words);
		}
		TrieNode childNode=search(root, word);
		if(childNode!=null)
			dfs(childNode,word);

	}
	public static void main(String[] args) {

		String words[]= {"do", "dont", "no","not", "note","notes","den"};
		ArrayList<String>s=new ArrayList<>();
		for(String word:words) {
			s.add(word);
		}
		autoComplete(s,"no");
		for(String auto:ans) {
			System.out.println(auto);
		}

	}

}
