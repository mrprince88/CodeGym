class MinMaxStackConstruction {

	static class Stack {

		static class Node {

			int val, min, max;
			Node next;

			Node(int val) {
				this.val = val;
				min = 0;
				max = 0;
				next = null;
			}
		}

		static Node top;

		static void push(int val) {
			Node n = new Node(val);
			if (top == null) {
				top = n;
				top.max = n.val;
				top.min = n.val;
			} else {
				n.min = Math.min(top.min, n.val);
				n.max = Math.max(top.max, n.val);
				n.next = top;
				top = n;
			}
		}

		static int pop() {
			if (top == null)
				return Integer.MIN_VALUE;
			else {
				int temp = top.val;
				top = top.next;
				return temp;
			}
		}

		static int peek() {
			if (top == null)
				return Integer.MIN_VALUE;
			return top.val;
		}

		static int min() {
			if (top == null)
				return Integer.MIN_VALUE;
			return top.min;
		}

		static int max() {
			if (top == null)
				return Integer.MIN_VALUE;
			return top.max;
		}

	}

	public static void main(String[] args) {
		Stack s = new Stack();
		s.push(5);
		s.push(4);
		s.push(3);
		System.out.println(s.min());
		s.pop();
		System.out.println(s.peek());
	}
}