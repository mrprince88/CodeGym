import java.util.Comparator;

class ContinuousMedian {

	static class Heap {

		int []heap;
		int len;
		Comparator<Integer> c;

		Heap(int n, Comparator<Integer> compare) {
			heap = new int[n];
			len = 0;
			this.c = compare;
		}

		void siftDown(int idx, int endIdx) {

			int temp = idx;
			int l = 2 * idx + 1;
			int r = 2 * idx + 2;

			if (l < endIdx && c.compare(heap[l], heap[temp]) == heap[l])
				temp = l;

			if (r < endIdx && c.compare(heap[r], heap[temp]) == heap[r])
				temp = r;

			if (temp != idx) {
				swap(idx, temp);
				siftDown(endIdx, temp);
			}

		}

		void siftUp(int idx) {

			int parentIdx = (idx - 1) / 2;

			if (idx > 0 && c.compare(heap[idx], heap[parentIdx]) == heap[idx]) {
				swap(idx, parentIdx);
				siftUp(parentIdx);
			}
		}

		int peek() {
			return heap[0];
		}

		int getLen() {
			return len;
		}

		void swap(int i, int j) {
			int t = heap[i];
			heap[i] = heap[j];
			heap[j] = t;
		}

		void insert(int val) {

			if (len == heap.length) {
				System.out.println("Overflow");
				return;
			}

			heap[len] = val;
			siftUp(len++);
		}

		int remove() {
			int toRemove = heap[0];
			len--;
			swap(0, len);
			siftDown(0, len);
			return toRemove;
		}

	}

	static void insert(int num, Heap lowers, Heap greaters) {

		if (lowers.getLen() == 0 || num < lowers.peek())
			lowers.insert(num);

		else
			greaters.insert(num);
	}

	static void rebalanceHeaps(Heap lowers, Heap greaters) {

		if (lowers.getLen() - greaters.getLen() == 2) {
			int num = lowers.remove();
			greaters.insert(num);
		}

		else if (greaters.getLen() - lowers.getLen() == 2) {
			int num = greaters.remove();
			lowers.insert(num);
		}

	}

	static double median(Heap lowers, Heap greaters) {

		if (greaters.getLen() == lowers.getLen())
			return (lowers.peek() + greaters.peek()) / 2.0;

		return (lowers.getLen() > greaters.getLen()) ? lowers.peek() : greaters.peek();
	}

	// Time: O(NlogN) | O(N) space

	static void getMedians(int []array) {

		Comparator<Integer> max = (i, j)->Math.max(i, j);
		Comparator<Integer> min = (i, j)->Math.min(i, j);
		Heap lowers = new Heap(array.length / 2 + 1, max);
		Heap greaters = new Heap(array.length / 2 + 1, min);

		for (int i : array) {

			insert(i, lowers, greaters);
			rebalanceHeaps(lowers, greaters);

			System.out.print(median(lowers, greaters) + " \t");
		}

		System.out.println();
	}

	public static void main(String[] args) {
		int []array = {5, 10, 100, 200, 6, 13, 14};
		getMedians(array);
	}
}

// Output:  5.0 	7.5 	10.0 	55.0 	10.0 	11.5 	13.0