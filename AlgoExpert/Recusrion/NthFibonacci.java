class NthFibonacci {

	//Time 0(2^n) | Space O(n)
	static int fib(int num) {
		if (num == 1)
			return 0;
		if (num == 2)
			return 1;
		return fib(num - 1) + fib(num - 2);
	}

	// O(n) Time | O(n) Space
	static int fibMemo(int num, int []dp) {

		if (num == 1)
			return 0;

		if (num == 2)
			return 1;

		if (dp[num] > 0)
			return dp[num];

		dp[num] = fibMemo(num - 1, dp) + fibMemo(num - 2, dp);
		return dp[num];
	}

	// O(n) Time | O(1) Space
	static int fibBest(int num) {

		int []lastTwo = {0, 1};
		int i = 2;

		while (++i <= num) {
			int nextFib = lastTwo[0] + lastTwo[1];
			lastTwo[0] = lastTwo[1];
			lastTwo[1] = nextFib;
		}

		return (num > 1) ? lastTwo[1] : lastTwo[0];
	}

	public static void main(String[] args) {
		int num = 5;
		System.out.println(fibBest(num));
	}
}