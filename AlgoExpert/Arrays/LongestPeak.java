class LongestPeak {

	static int solve(int []a, int n) {
		int longestPeakLength = 0, i = 1;
		while (i < n - 1) {
			if (!(a[i - 1] < a[i] && a[i] > a[i + 1])) { //not a peak
				i++;
				continue;
			}
			int leftIndex = i - 2;
			while (leftIndex >= 0 && a[leftIndex] < a[leftIndex + 1])
				leftIndex--;
			int rightIndex = i + 2;
			while (rightIndex < n && a[rightIndex] < a[rightIndex - 1])
				rightIndex++;
			int currentPeakLength = rightIndex - leftIndex - 1;
			longestPeakLength = Math.max(longestPeakLength, currentPeakLength);
			i = rightIndex;

		}
		return longestPeakLength;
	}

	public static void main(String[] args) {
		int n = 11;
		int []a = {1, 4, 3, 3, 1, 10, 9, 8, 7, 11, 12};
		System.out.println(solve(a, n));
	}
}