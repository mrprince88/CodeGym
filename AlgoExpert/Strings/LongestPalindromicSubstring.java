class LongestPalindromicSubstring {

	static String getLongestPalindromicSubstring(String str) {
		int []current = {0, 1};
		Comparator int[] compare = Comparator.comparing(e->e[1] - e[0]);
		for (i = 1; i < n; i++) {
			int[] odd = solve(str, i - 1, i + 1);
			int[] even = solve(str, i - 1, i);


		}
	}

	public static void main(String[] args) {


	}
}