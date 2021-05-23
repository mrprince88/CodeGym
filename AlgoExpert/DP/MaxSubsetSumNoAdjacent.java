public class MaxSubsetSumNoAdjacent {

	static int solve(int []a) {
		int n = a.length;
		if (n == 1)
			return a[0];

		int first = a[0], second = Math.max(a[0], a[1]);

		for (int i = 2; i < n; i++) {
			int currMax = Math.max(second, first + a[i]);
			first = second; second = currMax;
		}
		return second;
	}
	public static void main(String[] args) {
		int []a = {7, 10, 12, 7, 9, 14};
		System.out.println(solve(a));
	}
}