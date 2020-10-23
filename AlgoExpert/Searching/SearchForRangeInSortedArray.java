class SearchForRangeInSortedArray {

	static void SearchForRange(int []array, int num) {

		int min = 0, max = array.length - 1, mid = 0, l = -1, r = -1;

		while (min <= max) {

			mid = min + (max - min) / 2;

			if (array[mid] >= num) {
				max = mid - 1;
				if (array[mid] == num)
					l = mid;
			}

			else if (array[mid] < num)
				min = mid + 1;

		}

		min = l; max = array.length - 1;

		while (min <= max) {

			mid = min + (max - min) / 2;

			if (array[mid] <= num) {
				min = mid + 1;
				if (array[mid] == num)
					r = mid;
			}

			else if (array[mid] > num)
				max = mid - 1;

		}

		System.out.println(l + " " + r);
	}

	public static void main(String[] args) {
		int []array = {1, 2, 3, 4, 5, 5, 5, 5, 5, 7};
		int num = 4;
		SearchForRange(array, num);
	}
}