package Tries_And_Huffman_Coding;



public class Trie {
	private TrieNode root;
	private int totalWords;
	public Trie() {
		root=new TrieNode('\0');
		totalWords=0;
	}

	private void addHelper(String word,TrieNode root) {

		if(word.length()==0) {
			root.isTerminal=true;

			return;
		}
		int childIndex=word.charAt(0)-'A';

		TrieNode child=root.children[childIndex];
		if(child==null) {
			child=new TrieNode(word.charAt(0));
			root.children[childIndex]=child;
			root.childCount++;
		}
		addHelper(word.substring(1),child);
	}

	public void add(String word) {

		addHelper(word, root);
		totalWords++;
		return;
	}

	private boolean searchHelper(String word,TrieNode root) {
		if(word.length()==0)
			return root.isTerminal;

		int childIndex=word.charAt(0)-'A';
		TrieNode child=root.children[childIndex];

		if(child==null)
			return false;

		return searchHelper(word.substring(1),child);

	}

	public boolean search(String word) {

		return searchHelper(word, root);
	}

	private void removeHelper(TrieNode root, String word) {

		if(word.length()==0)
		{
			root.isTerminal=false;

			return;
		}

		int childIndex=word.charAt(0)-'A';

		TrieNode child=root.children[childIndex];
		if(child==null)
			return;

		removeHelper(child, word.substring(1));

		if(!child.isTerminal && child.childCount==0)
		{
			root.children[childIndex]=null;
			root.childCount--;
		}

	}

	public void remove(String word) {
		removeHelper(root, word);
		totalWords--;
		return;
	}

	public int countWords() {
		return totalWords;
	}

}
