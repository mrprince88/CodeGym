class SubarraySort {

	static void solve(int []a, int n) {
		int maxOutOfOrder = Integer.MIN_VALUE;
		int minOutOfOrder = Integer.MAX_VALUE;
		for (int i = 0; i < n; i++) {
			if (isOutOfOrder(a, i, n)) {
				minOutOfOrder = Math.min(minOutOfOrder, a[i]);
				maxOutOfOrder = Math.max(maxOutOfOrder, a[i]);
			}
		}
		if (minOutOfOrder == Integer.MAX_VALUE)
			System.out.println("-1 -1");
		else {
			int subarrayLeftIndex = 0;
			while (minOutOfOrder >= a[subarrayLeftIndex])
				subarrayLeftIndex++;
			int subarrayRightIndex = n - 1;
			while (maxOutOfOrder <= a[subarrayRightIndex])
				subarrayRightIndex++;
			System.out.println(subarrayLeftIndex + " " + subarrayRightIndex);
		}
	}

	static boolean isOutOfOrder(int []a, int i, int n) {
		if (i == 0)
			return a[i] > a[i + 1];
		if (i == n - 1)
			return a[i] < a[i - 1];
		else
			return a[i] > a[i + 1] || a[i] < a[i - 1];
	}

	public static void main(String[] args) {
		int n = 7;
		int []a = {1, 2, 3, 9, 8, 5, 6};
		solve(a, n);

	}
}