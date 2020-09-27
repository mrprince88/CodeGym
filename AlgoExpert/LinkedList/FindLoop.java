class FindLoop {

	static class Node<T> {
		T data;
		Node<T> next;

		Node(T data) {
			this.data = data;
			next = null;
		}
	}

	static class LinkedList<T> {

		Node<T> head;

		Node<T> getHead() {
			return head;
		}

		void add(T data) {
			Node<T> n = new Node<>(data);
			if (head == null) {
				head = n;
			} else {
				Node<T> index = head;
				while (index.next != null)
					index = index.next;
				index.next = n;
			}
		}

		void setNodeAtLast(int n) {
			Node<T> index = head, temp = null;
			int c = 0;
			while (index.next != null) {
				if (c == n)
					temp = index;
				index = index.next;
				++c;
			}
			index.next = temp;
		}
	}

	static void findLoopOrigin(LinkedList<Integer> list) {
		Node<Integer> first = list.getHead(), second = list.getHead();
		do {
			first = first.next;
			second = second.next.next;
		} while (!first.equals(second));

		first = list.getHead();

		while (!first.equals(second)) {
			first = first.next;
			second = second.next;
		}

		System.out.println(second.data);
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1); list.add(2); list.add(3);
		list.add(4); list.add(5); list.add(6);
		list.add(7); list.add(8); list.add(9);
		list.setNodeAtLast(3);
		findLoopOrigin(list);

	}
}