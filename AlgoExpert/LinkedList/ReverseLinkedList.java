class ReverseLinkedList {

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

		void display() {
			Node index = head;
			while (index != null) {
				System.out.print(index.data + " ");
				index = index.next;
			}
			System.out.println();
		}

		void reverseLinkedList() {
			Node p1 = null, p2 = head, p3;
			while (p2 != null) {
				p3 = p2.next;
				p2.next = p1;
				p1 = p2;
				p2 = p3;
			}
			head = p1;
		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1); list.add(2); list.add(3);
		list.display();
		list.reverseLinkedList();
		list.display();
	}
}
