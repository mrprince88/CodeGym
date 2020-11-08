class FindClosestValueInBST {

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

		if (root == null) {
			root = n;
			return;
		}

		Node curr = root, parent = null;

		while (curr != null) {
			parent = curr;
			if (val < curr.val)
				curr = curr.left;
			else
				curr = curr.right;
		}

		if (parent == null)
			parent = n;

		else if (parent.val > val)
			parent.left = n;

		else if (parent.val < val)
			parent.right = n;
	}

	static int findClosest(Node root, int val) {
		Node curr = root;
		int closest = root.val;
		while (curr != null) {
			if (Math.abs(val - curr.val) < Math.abs(closest - val))
				closest = curr.val;
			if (val < curr.val)
				curr = curr.left;
			else
				curr = curr.right;
		}
		return closest;
	}

	public static void main(String[] args) {
		Node root = new Node(1);
		insert(root, 2);
		insert(root, -1);
		insert(root, 3);
		System.out.println(findClosest(root, -2));
	}
}
