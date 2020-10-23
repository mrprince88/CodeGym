//find kth smallest number in array

class QuickSelect {

	static void QuickSelect(int []array, int k) {

		int min = 0, max = array.length - 1, c = 0;

		while (min <= max) {

			int pivot = min;
			int leftIndex = min + 1;
			int rightIndex = max;

			while (rightIndex >= leftIndex) {
				if (array[rightIndex] < array[pivot] && array[leftIndex] > array[rightIndex])
					swap(array, leftIndex, rightIndex);
				if (array[leftIndex] <= array[pivot])
					leftIndex++;
				if (array[rightIndex] >= array[pivot])
					rightIndex--;
			}
			swap(array, pivot, rightIndex);

			if (rightIndex == k) {
				++c;
				System.out.println(array[pivot]);
				break;
			}

			else if (rightIndex < k)
				min = rightIndex + 1;

			else if (rightIndex > k)
				max = rightIndex - 1;
		}

		if (c == 0)
			System.out.println("Out Of Bounds");

	}

	static void swap(int []array, int l, int r) {
		int t = array[l];
		array[l] = array[r];
		array[r] = t;
	}

	public static void main(String[] args) {
		int []array = {3, 4, 1, 2, 5};
		int k = 5;
		QuickSelect(array, k - 1);
	}
}

