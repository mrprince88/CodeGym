class YoungestCommonAncestor {

	static class Node {
		Node parent;
		char val;
		Node(char val, Node prev) {
			parent = prev;
			this.val = val;
		}
	}

	static char getYoungestCommonAncestor(Node topManager, Node manager1, Node manager2) {

		int depth1 = getDepth(topManager, manager1);
		int depth2 = getDepth(topManager, manager2);

		if (depth1 > depth2)
			return backTraverse(manager1, manager2, depth1 - depth2).val;

		else
			return backTraverse(manager2, manager1, depth2 - depth1).val;
	}

	static int getDepth(Node topManager, Node manager) {
		int depth = 0;

		while (manager != topManager) {
			depth++;
			manager = manager.parent;
		}

		return depth;
	}

	static Node backTraverse(Node lower, Node higher, int diff) {
		while (diff-- > 0)
			lower = lower.parent;

		while (lower != higher) {
			lower = lower.parent;
			higher = higher.parent;
		}

		return lower;
	}

	public static void main(String[] args) {
		Node A = new Node('A', null);
		Node B = new Node('B', A); Node C = new Node('C', A); Node D = new Node('D', A); Node E = new Node('E', A); Node F = new Node('F', A);
		Node G = new Node('G', B); Node H = new Node('H', B); Node I = new Node('I', B);
		Node J = new Node('J', C);
		Node K = new Node('K', D); Node L = new Node('L', D);
		Node M = new Node('M', F); Node N = new Node('N', F);
		Node O = new Node('O', H); Node P = new Node('P', H);
		System.out.println(getYoungestCommonAncestor(A, I, P));
	}
}