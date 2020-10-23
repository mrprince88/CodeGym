class BinarySearch {

	static int BinarySearch(int[] array, int val) {
		int min = 0, max = array.length - 1;
		while (min <= max) {
			int mid = min + (max - min) / 2;
			if (array[mid] == val)
				return mid;
			if (array[mid] < val)
				min = mid + 1;
			if (array[mid] > val)
				max = mid - 1;
		}
		return -1;
	}

	public static void main(String[] args) {
		int []array = {1, 2, 3, 5, 7};
		System.out.println(BinarySearch(array, 5));
	}
}