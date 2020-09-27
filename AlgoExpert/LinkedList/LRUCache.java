import java.util.HashMap;

class LRUCache {

	static class Cache {
		HashMap<Integer, Integer> cache;
		int maxSize, currentSize;
		LinkedList list;

		Cache(int maxSize) {
			this.maxSize = maxSize;
			currentSize = 0;
			list = new LinkedList();
			cache = new HashMap<>();
		}

		void insertKeyValue(int key, int value) {
			if (cache.containsKey(key))
				cache.put(key, value);
			else {
				if (currentSize == maxSize) {
					removeLeastRecent();
				} else
					currentSize++;
				cache.put(key, value);
			}
			updateMostRecent(key, value);
		}

		void removeLeastRecent() {
			cache.remove(list.tail.key);
			list.removeLast();
		}

		void updateMostRecent(int key, int value) {
			list.setHead(new Node(key, value));
		}

		int getValueFromKey(int key) {
			if (!cache.containsKey(key))
				return -1;
			updateMostRecent(key, cache.get(key));
			return cache.get(key);
		}

		int getMostRecent() {
			return list.head.key;
		}

		void show() {
			list.display();
		}
	}

	static class Node {
		int key, value;
		Node next, prev;

		Node(int key, int value) {
			this.key = key;
			this.value = value;
			next = null;
			prev = null;
		}
	}

	static class LinkedList {

		Node head = null, tail = null;

		void setHead(Node node) {

			if (head == null) {
				head = node;
				tail = node;
			}

			else if (head.key == tail.key) {
				tail.prev = node;
				head = node;
				head.next = tail.prev;
			}

			else {
				if (tail.key == node.key) {
					tail = tail.prev;
					tail.next = null;
				}
				removeBindings(node);
				head.prev = node;
				node.next = head;
				head = node;
			}
		}

		void removeBindings(Node node) {
			if (node.prev != null)
				node.prev.next = node.next;
			if (node.next != null)
				node.next.prev = node.prev;
			node.prev = null;
			node.next = null;
		}

		void removeLast() {
			if (tail == null)
				return;
			if (head == tail) {
				head = null; tail = null;
				return;
			}
			tail = tail.prev;
			tail.next = null;
		}

		void display() {
			Node index = head;
			while (index != null) {
				System.out.println(index.key + " " + index.value);
				index = index.next;
			}
			System.out.println();
		}
	}



	public static void main(String[] args) {
		Cache cache = new Cache(3);
		cache.insertKeyValue(1, 5);
		cache.insertKeyValue(2, 4);
		cache.insertKeyValue(3, 6);
		cache.insertKeyValue(1, 8);
		cache.insertKeyValue(5, 1);
		cache.insertKeyValue(4, 2);
		cache.show();
	}
}