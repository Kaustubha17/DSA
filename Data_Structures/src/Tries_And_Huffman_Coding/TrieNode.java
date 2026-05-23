package Tries_And_Huffman_Coding;

public class TrieNode {
	char data;
	boolean isTerminal;
	TrieNode children[];
int childCount;
	public TrieNode(char data) {
		// TODO Auto-generated constructor stub
		this.data=data;
		this.isTerminal=false;
		this.children=new TrieNode[26];
		this.childCount=0;
	}
}
