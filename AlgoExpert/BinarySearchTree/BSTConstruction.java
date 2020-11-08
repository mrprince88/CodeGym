class BSTConstruction {

	static class BST {

		static class Node {

			Node left, right;
			int val;

			Node(int val) {
				this.val = val;
				left = right = null;
			}
		}

		Node root;

		boolean contains(int val) {

			Node curr = root;

			while (curr != null) {

				if (val < curr.val)
					curr = curr.left;

				else if (val > curr.val)
					curr = curr.right;

				else
					return true;
			}
			return false;
		}

		void delete(int val) {

			Node curr = root, parent = null;
			int c = 0;

			while (curr != null) {

				if (val < curr.val) {
					parent = curr;
					curr = curr.left;
				}

				else if (val > curr.val) {
					parent = curr;
					curr = curr.right;
				}

				else {
					++c;
					if (curr.right == null || curr.left == null) {

						Node tempCurr;

						if (curr.left == null)
							tempCurr = curr.right;
						else
							tempCurr = curr.left;

						if (parent == null)
							this.root = tempCurr;

						else if (curr == parent.left)
							parent.left = tempCurr;

						else
							parent.right = tempCurr;
					}

					else if (curr.left != null && curr.right != null) {

						Node tempParent = null, tempCurr = curr.right;

						while (tempCurr.left != null) {
							tempParent = tempCurr;
							tempCurr = tempCurr.left;
						}

						if (tempParent != null)
							tempParent.left = tempCurr.right;

						else
							tempCurr.right = tempParent.right;

						curr.val = tempCurr.val;
					}
					return;
				}
			}
			if (c == 0)
				System.out.println(val + " not found");
		}

		void insert(int val) {

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

		void inOrder() {
			getInOrder(root);
		}

		void getInOrder(Node node) {
			if (node == null)
				return;
			getInOrder(node.left);
			System.out.print(node.val + " ");
			getInOrder(node.right);
		}

	}

	public static void main(String[] args) {
		BST bst = new BST();
		bst.insert(1);
		bst.insert(2);
		bst.insert(5);
		bst.insert(4);
		bst.delete(1);
		bst.inOrder();
	}
}