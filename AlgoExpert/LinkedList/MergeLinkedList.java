class MergeLinkedList {


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

		void display() {
			Node<T> index = head;
			while (index != null) {
				System.out.print(index.data + " ");
				index = index.next;
			}
			System.out.println();
		}
	}

	static LinkedList<Integer> mergedLinkedList(LinkedList<Integer> list1,
	        LinkedList<Integer> list2) {
		Node<Integer> i = list1.getHead(), j = list2.getHead(), prev = null;
		while (i != null && j != null) {
			if (i.data < j.data) {
				prev = i;
				i = i.next;
			} else {
				if (prev != null) {
					prev.next = j;
				}
				prev = j;
				j = j.next;
				prev.next = i;
			}
		}
		if (i == null)
			prev.next = j;
		if (list1.getHead().data < list2.getHead().data)
			return list1;
		else
			return list2;
	}

	public static void main(String[] args) {
		LinkedList<Integer> list1 = new LinkedList<>();
		LinkedList<Integer> list2 = new LinkedList<>();
		list1.add(0); list1.add(4); list1.add(5);
		list2.add(0); list2.add(2); list2.add(8);
		LinkedList<Integer> mergedList = mergedLinkedList(list1, list2);
		mergedList.display();
	}
}