class BubbleSort {

	static void bubbleSort(int []a, int n) {
		boolean isSorted = false;
		int counter = 0;
		while (!isSorted) {
			isSorted = true;
			for (int i = 0; i < n - 1 - counter; i++) {
				if (a[i] > a[i + 1]) {
					swap(a, i, i + 1);
					isSorted = false;
				}
			}
			counter++;
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
		bubbleSort(a, n);
		for (int i : a)
			System.out.print(i + " ");

	}
}