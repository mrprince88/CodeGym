class BranchSums {

	static class Node {
		Node left, right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	// O(n) time | O(d) space

	static void BranchSum(Node root, int sum) {

		if (root == null)
			return;

		if (root.left == null && root.right == null) {
			System.out.print(sum + root.val + " ");
			return;
		}

		BranchSum(root.left, sum + root.val);
		BranchSum(root.right, sum + root.val);
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(2);
		root.right.left = new Node(5);
		root.left.right = new Node(9);
		BranchSum(root, 0);
	}
}