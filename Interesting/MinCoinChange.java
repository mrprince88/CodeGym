import java.io.*;
import java.util.*;

class MinCoinChange {

	public static void main(String[] args)throws IOException {

		System.setIn(new FileInputStream("./input.txt"));
		System.setOut(new PrintStream(new FileOutputStream("./output.txt")));

		InputReader in = new InputReader();
		int sum = in.nextInt();
		int n = in.nextInt();
		int []den = in.readArray(n);
		int []dp = new int[sum + 1];
		dp[0] = 0;
		for (int i = 1; i <= sum; i++) {
			dp[i] = Integer.MAX_VALUE;
			for (int j = 0; j < n; j++) {
				if (den[j] <= i && dp[i - den[j]] != Integer.MAX_VALUE)
					dp[i] = Math.min(dp[i - den[j]] + 1, dp[i]);
			}
		}
		System.out.println(dp[sum]);
	}

	static class InputReader {
		BufferedReader br;
		StringTokenizer st;

		public InputReader() {
			br = new BufferedReader(new InputStreamReader(System.in));
		}
		String next() {
			while (st == null || !st.hasMoreElements()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt() {
			return Integer.parseInt(next());
		}
		long nextLong() {
			return Long.parseLong(next());
		}
		double nextDouble() {
			return Double.parseDouble(next());
		}
		int[] readArray(int n) {
			int []a = new int[n];
			for (int i = 0; i < n; i++)
				a[i] = nextInt();
			return a;
		}
		int [][] read2dArray(int n, int m) {
			int [][]a = new int[n][m];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < m; j++)
					a[i][j] = nextInt();
			return a;
		}
		String nextLine() {
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}
	}
}
