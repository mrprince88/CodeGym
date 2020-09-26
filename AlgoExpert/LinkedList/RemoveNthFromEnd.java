class RemoveNthFromEnd {

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

		void removeNthNodeFromEnd(int index) {
			Node first = head, second = head;
			int c = 0;
			while (c != index + 1) {
				second = second.next;
				c++;
			}
			while (second != null) {
				first = first.next;
				second = second.next;
			}
			Node temp = first.next;
			temp = temp.next;
			first.next = temp;

		}
	}

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(0); list.add(1); list.add(2); list.add(3);
		list.add(4); list.add(5); list.add(6);
		list.add(7); list.add(8); list.add(9);
		int index = 4;
		list.display();
		list.removeNthNodeFromEnd(7);
		list.display();

	}
}
