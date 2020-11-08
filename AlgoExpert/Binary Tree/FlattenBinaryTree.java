import java.util.List;
import java.util.ArrayList;

class FlattenBinaryTree {

	static class Node {
		Node left, right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	static List<Node> list;

	static void inOrder(Node root) {

		if (root == null)
			return;

		inOrder(root.left);
		list.add(root);
		inOrder(root.right);
	}

	// O(n) time | O(n) space

	static void flattenBinaryTree(Node root) {

		list = new ArrayList<>();
		inOrder(root);

		for (int i = 0; i < list.size() - 1; i++) {
			Node left = list.get(i);
			Node right = list.get(i + 1);
			left.right = right;
			right.left = left;
		}
	}

	// O(n) time | O(d) space

	static Node prev = null;

	static void flattenBinaryTreeRecursive(Node root) {

		if (root == null)
			return;

		flattenBinaryTreeRecursive(root.left);

		if (prev != null) {
			root.left = prev;
			prev.right = root;
		}

		prev = root;

		flattenBinaryTreeRecursive(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(2);
		root.right.left = new Node(5);
		root.left.right = new Node(9);

		flattenBinaryTreeRecursive(root);
		Node curr = root;

		while (curr.left != null) {
			curr = curr.left;
		}

		while (curr != null) {
			System.out.print(curr.val + " ");
			curr = curr.right;
		}

	}
}

/*

i/p:
          1
        /   \
       3     4
     /  \   /
    2    9 5


o/p: 2 3 9 1 5 4

*/


