import java.util.List;
import java.util.ArrayList;

class InvertBinaryTree {

	static class Node {
		Node left, right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	// O(n) time | O(n) space

	static void invertBinaryTreeIterative(Node root) {

		List<Node> list = new ArrayList<>();
		list.add(root);

		for (int i = 0; i < list.size(); i++) {
			Node node = list.get(i);
			if (node == null)
				continue;

			Node temp = node.left;
			node.left = node.right;
			node.right = temp;

			list.add(node.left);
			list.add(node.right);
		}
	}


	//O(n) time | O(d) space

	static void invertBinaryTree(Node root) {
		if (root == null)
			return;

		Node temp = root.left;
		root.left = root.right;
		root.right = temp;

		invertBinaryTree(root.left);
		invertBinaryTree(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(2);
		root.right.left = new Node(5);
		root.left.right = new Node(9);
		invertBinaryTreeIterative(root);
	}
}