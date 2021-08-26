import java.io.*;
import java.util.*;

class SubArrayMaxSum {


	public static void main(String[] args)throws IOException {

		System.setIn(new FileInputStream("./input.txt"));
		System.setOut(new PrintStream(new FileOutputStream("./output.txt")));

		InputReader in = new InputReader();
		int n = in.nextInt();
		int []a = in.readArray(n);
		int maxSum = Integer.MIN_VALUE, currSum = 0;
		for (int i = 0; i < n; i++) {
			currSum += a[i];

			maxSum = Math.max(currSum, maxSum);

			if (currSum < 0) {
				currSum = 0;
			}

		}
		System.out.println(maxSum);
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