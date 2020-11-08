class MaxPathSum {

	static class Node {
		Node left, right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	// O(n) time | O(log n) space

	static int ans;

	static int maxPathSum(Node root) {

		if (root == null)
			return 0;

		int left = Math.max(0, maxPathSum(root.left));
		int right = Math.max(0, maxPathSum(root.right));

		ans = Math.max(ans, left + right + root.val);

		return Math.max(left, right) + root.val;
	}

	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
		root.right.left = new Node(5);
		root.right.right = new Node(7);
		root.left.right = new Node(6);

		ans = Integer.MIN_VALUE;
		maxPathSum(root);
		System.out.println(ans);
	}
}
