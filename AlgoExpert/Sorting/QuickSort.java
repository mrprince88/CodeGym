class QuickSort {

	static void quickSort(int []a, int l, int r) {
		if (l >= r)
			return;

		swap(a, l, (l + r) / 2);
		int pivot = l;
		int leftIndex = l + 1;
		int rightIndex = r;

		while (rightIndex >= leftIndex) {
			if (a[rightIndex] < a[pivot] && a[leftIndex] > a[rightIndex])
				swap(a, leftIndex, rightIndex);
			if (a[leftIndex] <= a[pivot])
				leftIndex++;
			if (a[rightIndex] >= a[pivot])
				rightIndex--;
		}

		swap(a, pivot, rightIndex);
		quickSort(a, l, rightIndex - 1);
		quickSort(a, rightIndex + 1, r);
	}

	static void swap(int []a, int l, int r) {
		int t = a[l];
		a[l] = a[r];
		a[r] = t;
	}

	public static void main(String[] args)  {
		int []a = {5, 3, 1, 4, 2};
		quickSort(a, 0, 4);
		for (int i = 0; i < 5; i++)
			System.out.println(a[i]);
	}
}

