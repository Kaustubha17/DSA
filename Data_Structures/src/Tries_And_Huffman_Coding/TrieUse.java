package Tries_And_Huffman_Coding;

public class TrieUse {

	public static void main(String[] args) {
		Trie t=new Trie();
		t.add("T");
		t.add("TO");
		System.out.println(t.search("TO"));
		System.out.println(t.countWords());
		t.remove("TO");
		System.out.println(t.search("TO"));
		
		System.out.println(t.countWords());
	}

}
