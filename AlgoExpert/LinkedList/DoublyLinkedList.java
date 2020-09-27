class DoublyLinkedList {

	static class Node<T> {
		T data;
		Node<T> next, prev;

		Node(T data) {
			this.data = data;
			next = null;
			prev = null;
		}
	}

	static class LinkedList<T> {


		Node<T> head;

		void add(T data) {
			Node<T> n = new Node<>(data);
			if (head == null) {
				head = n;
			} else {
				Node<T> index = head;
				while (index.next != null)
					index = index.next;
				n.prev = index;
				index.next = n;
			}
		}

		int size() {
			int len = 0;
			Node<T> index = head;
			while (index != null) {
				len++;
				index = index.next;
			}
			return len;
		}

		void insert(int pos, T data) {
			Node<T> n = new Node<>(data);
			if (pos == 0) {
				n.next = head;
				head = n;
			} else {
				Node<T> index = head;
				while (index.next != null && --pos >= 0) {
					index = index.next;
				}

				if (pos == 0) {
					index.prev.next = n;
					n.prev = index.prev;
					n.next = index;
					index.prev = n;
					index = n;
				}

				else
					System.out.println("Not Possible");
			}
		}

		void display() {
			Node<T> index = head;
			while (index != null) {
				System.out.print(index.data + " ");
				index = index.next;
			}
			System.out.println();
		}

		void search(int data) {
			Node<T> index = head;
			int c = 0;
			while (index != null) {
				if (index.data.equals(data))
					System.out.println("Found at " + c);
				index = index.next;
				++c;
			}
		}

		void remove(T data) {
			Node<T> index = head;
			while (index != null && !index.data.equals(data)) {
				index = index.next;
			}
			if (index.data.equals(data)) {
				if (index.prev != null) {
					Node<T> temp = index.prev;
					while (index != null) {
						temp.next = index.next;
						temp = temp.next;
						index = index.next;
					}
				} else
					head = head.next;
			}
		}

		boolean contains(int data) {
			Node<T> index = head;
			while (index != null) {
				if (index.data.equals(data))
					return false;
			}
			return false;
		}

	}

	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.insert(3, "5");
		list.remove("1");
		list.display();
		System.out.println(list.size());

	}
}