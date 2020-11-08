import java.util.*;

class MinHeapConstruction {

	// O(log n) time | O(1) space
	static void siftDown(int []heap, int idx, int endIdx) {

		int smallest = idx;
		int l = 2 * idx + 1;
		int r = 2 * idx + 2;

		if (l < endIdx && heap[l] < heap[smallest])
			smallest = l;

		if (r < endIdx && heap[r] < heap[smallest])
			smallest = r;

		if (smallest != idx) {
			swap(heap, idx, smallest);
			siftDown(heap, endIdx, smallest);
		}

	}

	// O(n) time | O(1) space
	static int[] buildHeap(int []heap, int len) {

		int firstParentIdx = len - 2 / 2;

		for (int i = firstParentIdx - 1; i >= 0; i--)
			siftDown(heap, i, len);

		return heap;
	}

	// O(log n) time | O(1) space
	static void siftUp(int []heap, int idx) {

		int parentIdx = (idx - 1) / 2;

		if (idx > 0 && heap[idx] < heap[parentIdx]) {
			swap(heap, idx, parentIdx);
			siftUp(heap, parentIdx);
		}

	}

	static void display(int []heap, int len) {
		for (int i = 0; i < len; i++)
			System.out.print(heap[i] + " ");
		System.out.println();
	}

	static int remove(int []heap, int len) {

		int toRemove = heap[0];
		len--;
		swap(heap, 0, len);
		siftDown(heap, 0, len);
		return toRemove;

	}

	static void insert(int []heap, int val, int len) {

		if (len == heap.length) {
			System.out.println("Overflow");
			return;
		}

		heap[len] = val;
		siftUp(heap, len++);
	}

	static void swap(int []heap, int i, int j) {
		int t = heap[i];
		heap[i] = heap[j];
		heap[j] = t;
	}

	public static void main(String[] args) {
		int []heap = new int[5];
		insert(heap, 5, 0);
		insert(heap, 3, 1);
		insert(heap, 7, 2);
		insert(heap, 8, 3);
		insert(heap, 1, 4);
		remove(heap, 4);
		display(heap, 4);
	}
}
