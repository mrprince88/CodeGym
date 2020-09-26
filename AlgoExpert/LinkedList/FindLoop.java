class FindLoop {

	static class LinkedList<T> {
		class Node {
			T data;
			Node next;

			Node(T data) {
				this.data = data;
				next = null;
			}
		}

		Node head;

		void add(T data) {
			Node n = new Node(data);
			if (head == null) {
				head = n;
			} else {
				Node index = head;
				while (index.next != null)
					index = index.next;
				index.next = n;
			}
		}

		void setNodeAtLast(int n) {
			Node index = head, temp = null;
			int c = 0;
			while (index.next != null) {
				if (c == n)
					temp = index;
				index = index.next;
				++c;
			}
			index.next = temp;
		}

		void findLoopOrigin() {
			Node first = head.next, second = head.next;
			second = second.next;
			while (!first.equals(second)) {
				first = first.next;
				second = second.next.next;
			}
			first = head;
			while (!first.equals(second)) {
				first = first.next;
				second = second.next;
			}

			System.out.println(second.data);
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1); list.add(2); list.add(3);
		list.add(4); list.add(5); list.add(6);
		list.add(7); list.add(8); list.add(9);
		list.setNodeAtLast(6);
		list.findLoopOrigin();

	}
}