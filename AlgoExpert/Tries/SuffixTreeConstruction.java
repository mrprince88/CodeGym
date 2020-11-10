import java.util.*;

class SuffixTreeConstruction {

	static class TrieNode {
		HashMap<Character, TrieNode> children;
		boolean isLeaf;

		TrieNode() {
			children = new HashMap<>();
			isLeaf = false;
		}

	}

	static TrieNode root = new TrieNode();

	// O(n^2) time | O(n^2) space

	static void suffixTreePopulate(String str) {

		for (int i = 0; i < str.length(); i++)
			insertSubstringFrom(i, str);

	}

	static void insertSubstringFrom(int i, String str) {

		TrieNode node = root;

		for (int j = i; j < str.length(); j++) {

			char letter = str.charAt(j);

			if (!node.children.containsKey(letter))
				node.children.put(letter, new TrieNode());

			node = node.children.get(letter);
		}

		node.isLeaf = true;
	}

	// O(m) time | O(1) space

	static boolean contains(String str) {

		TrieNode node = root;

		for (int i = 0; i < str.length(); i++) {
			char letter = str.charAt(i);
			if (!node.children.containsKey(letter))
				return false;
			node = node.children.get(letter);
		}

		return node.isLeaf == true;
	}

	public static void main(String[] args) {
		String str = "babac";
		suffixTreePopulate(str);
		System.out.println(contains("bac"));
	}
}