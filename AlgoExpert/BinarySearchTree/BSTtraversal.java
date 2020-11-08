class BSTtraversal {

	static class Node {

		Node left, right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	static void insert(Node root, int val) {

		Node n = new Node(val);

		Node curr = root, parent = null;

		while (curr != null) {
			parent = curr;
			if (val < curr.val)
				curr = curr.left;
			else
				curr = curr.right;
		}

		if (parent == null)
			root = n;

		else if (parent.val > val)
			parent.left = n;

		else if (parent.val < val)
			parent.right = n;
	}

	static void preOrder(Node root) {
		if (root == null)
			return;
		System.out.print(root.val + " ");
		preOrder(root.left);
		preOrder(root.right);
	}

	static void postOrder(Node root) {
		if (root == null)
			return;
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.val + " ");
	}

	static void inOrder(Node root) {
		if (root == null)
			return;
		inOrder(root.left);
		System.out.print(root.val + " ");
		inOrder(root.right);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		insert(root, 2);
		insert(root, -1);
		insert(root, 3);
		System.out.println("Inorder Traversal: ");
		inOrder(root);
		System.out.println("\nPreorder Traversal: ");
		preOrder(root);
		System.out.println("\nPostoder Traversal: ");
		postOrder(root);
	}
}