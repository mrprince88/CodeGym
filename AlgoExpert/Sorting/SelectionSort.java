class SelectionSort {

	static void selectionSort(int []a, int n) {
		int smallestIndex = 0, currentIndex = 0;
		while (currentIndex <= n - 1) {
			smallestIndex = currentIndex;
			for (int j = currentIndex + 1; j < n; j++) {
				if (a[smallestIndex] > a[j])
					smallestIndex = j;
			}
			swap(a, smallestIndex, currentIndex);
			currentIndex++;
		}
	}

	static void swap(int []a, int i, int j) {
		int t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	public static void main(String[] args) {
		int []a = {6, 3, 2, 7, 1};
		int n = 5;
		selectionSort(a, n);
		for (int i : a)
			System.out.print(i + " ");

	}
}