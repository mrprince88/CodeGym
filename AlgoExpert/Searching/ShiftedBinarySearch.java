class ShiftedBinarySearch {

	static void ShiftedBinarySearch(int []array, int num) {

		int min = 0, max = array.length - 1, c = 0;

		while (min <= max) {

			int mid = min + (max - min) / 2;

			int l = array[min], r = array[max];

			if (array[mid] == num) {
				++c;
				System.out.println(mid);
				break;
			}

			if (l <= array[mid]) {
				if (num < array[mid] && num >= l)
					max = mid - 1;
				else
					min = mid + 1;
			} else {
				if (num > array[mid] && num <= r)
					min = mid + 1;
				else
					max = mid - 1;
			}
		}

		if (c == 0)
			System.out.println(-1);
	}

	public static void main(String[] args) {
		int []array = {45, 61, 71, 72, 73, 0, 1, 21, 33, 45};
		int num = 33;
		ShiftedBinarySearch(array, num);
	}
}