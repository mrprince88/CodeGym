// Left Child Right Sibling Tree

class RightSiblingTree {

	static class Node {
		Node left, right;
		int val;

		Node(int val) {
			this.val = val;
			left = right = null;
		}
	}

	static void preorder(Node root) {
		if (root == null) {
			return;
		}

		System.out.print(root.val + " ");
		preorder(root.left);
		preorder(root.right);
	}

	// O(n) time | O(d) space

	static void RightSiblingTree(Node root) {
		if (root == null)
			return;

		RightSiblingTree(root.left);
		RightSiblingTree(root.right);

		if (root.left == null) {
			root.left = root.right;
			root.right = null;
		}

		else {
			root.left.right = root.right;
			root.right = null;
		}
	}


	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(4);
		root.left.left = new Node(2);
		root.right.left = new Node(5);
		root.left.right = new Node(9);
		RightSiblingTree(root);
		preorder(root);

	}
}

/*

i/p:
          1
        /   \
       3     4
     /  \   /
    2    9 5

o/p:
		1
	  /
	 3 - 4
   /	/
  2    5
  \
   9

*/

