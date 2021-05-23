import java.util.Arrays;
public class MinNumberOfCoinsForChange {
	static int solve(int sum, int[]coins) {

		int []dp = new int[sum + 1];
		int n = coins.length;
		Arrays.fill(dp, sum + 1);
		dp[0] = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= sum; j++)
				if (coins[i] <= j)
					dp[j] = Math.min(dp[j], 1 + dp[j - coins[i]]);
		}
		return dp[sum] > sum ? -1 : dp[sum];
	}
	public static void main(String[] args) {
		int sum = 6;
		int []coins = {1, 2, 4};
		System.out.println(solve(sum, coins));
	}
}