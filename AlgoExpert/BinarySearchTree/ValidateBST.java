class ValidateBST {

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

	static boolean validateBST(Node root, int min, int max) {
		if (root == null)
			return true;

		if (root.val <= min || root.val >= max)
			return false;

		return validateBST(root.left, min, root.val) && validateBST(root.right, root.val, max);
	}


	public static void main(String[] args) {
		Node root = new Node(1);
		insert(root, 2);
		insert(root, -1);
		insert(root, 3);
		System.out.println(validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
	}
}