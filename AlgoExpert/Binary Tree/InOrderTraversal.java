import java.util.Stack;

class InOrderTraversal {

	static class Node {
		Node left, right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	// O(n) time | O(d) space

	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	// O(n) time | O(n) space

	static void inOrderIterative(Node root) {

		Stack<Node> s = new Stack<>();
		Node curr = root;

		while (curr != null || s.size() > 0) {

			while (curr != null) {
				s.push(curr);
				curr = curr.left;
			}

			curr = s.pop();
			System.out.print(curr.val + " ");
			curr = curr.right;
		}
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(2);
		root.right.left = new Node(5);
		root.left.right = new Node(9);
		inOrderIterative(root);
	}
}