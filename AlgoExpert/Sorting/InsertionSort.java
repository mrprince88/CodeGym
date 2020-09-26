class InsertionSort {

	static void insertionSort(int []a, int n) {
		for (int i = 1; i < n; i++) {
			int j = i;
			while (j > 0 && a[j] < a[j - 1]) {
				swap(a, j, j - 1);
				j--;
			}
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
		insertionSort(a, n);
		for (int i : a)
			System.out.print(i + " ");

	}
}