import java.util.Arrays;
public class NumberOfWaysToMakeChange {

	static int solve(int []coins, int sum) {
		int []dp = new int[sum + 1];
		int n = coins.length;
		dp[0] = 1;
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j <= sum; j++) {
				if (coins[i] <= j)
					dp[j] += dp[j - coins[i]];
			}
		}
		return dp[sum];
	}


	// recursive
	static int solve2(int []coins, int idx, int sum, int [][]dp) {
		if (sum == 0)
			return 1;
		if (sum < 0)
			return 0;
		if (idx == coins.length)
			return 0;
		if (dp[sum][idx] > -1)
			return dp[sum][idx];

		int first = solve2(coins, idx, sum - coins[idx], dp);
		int second = solve2(coins, idx + 1, sum, dp);
		dp[sum][idx] = first + second;
		return dp[sum][idx];
	}


	public static void main(String[] args) {
		int sum = 10;
		int []coins = {1, 5, 10, 25};
		System.out.println(solve(coins, sum));
		int [][]dp = new int[sum + 1][coins.length + 1];

		for (int[]i : dp)
			Arrays.fill(i, -1);

		System.out.println(solve2(coins, 0, sum, dp));
	}
}