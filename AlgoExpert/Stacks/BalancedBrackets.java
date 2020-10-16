class BalancedBrackets {

	static class Stack {

		static class Node {
			char val;
			Node next;
			Node(char val) {
				this.val = val;
				next = null;
			}
		}

		static Node top;

		static void push(char val) {
			Node n = new Node(val);
			if (top == null) {
				top = n;
			} else {
				n.next = top;
				top = n;
			}
		}

		static char pop() {
			if (top == null)
				return '\0';
			else {
				char temp = top.val;
				top = top.next;
				return temp;
			}
		}

		static char peek() {
			if (top == null)
				return '\0';
			return top.val;
		}

	}

	static boolean checkBalancedBrackets(String str) {

		Stack s = new Stack();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '}' || str.charAt(i) == ')' || str.charAt(i) == ']') {
				if (s.peek() == '\0')
					return false;
				else {
					if (s.peek() == '{' && str.charAt(i) == '}')
						s.pop();
					else if (s.peek() == '(' && str.charAt(i) == ')')
						s.pop();
					else if (s.peek() == '[' && str.charAt(i) == ']')
						s.pop();
					else
						return false;
				}
			} else
				s.push(str.charAt(i));
		}
		if (s.peek() == '\0')
			return true;
		return true;
	}

	public static void main(String[] args) {
		String str = "[{(())}]";
		System.out.println(checkBalancedBrackets(str));
	}

}