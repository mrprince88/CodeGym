import java.io.*;
import java.util.*;

public class DigitQueries {

	static long func(long x, long size) {
		long count = 0;
		for (long i = 1; i < size; i++) {
			long num = (9 * (long)Math.pow(10, i - 1));
			count += (num * i);
		}
		long mi = (long)Math.pow(10, size - 1);
		count += ((x - mi) * size) + 1;
		return count;
	}

	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int q = in.nextInt();
		while (q-- > 0) {
			long k = in.nextLong();
			long sum = 0, size = 0;

			for (int i = 1; i <= 18; i++) {
				long num = 9 * (long)Math.pow(10, i - 1);
				sum += (num * i);
				if (k <= sum) {
					size = i;
					break;
				}
			}

			long low = (long)Math.pow(10, size - 1);
			long high = (long)Math.pow(10, size) - 1;

			long mid, ans = 0, index = 0;

			while (low <= high) {
				mid = (low + high) / 2;
				long value = func(mid, size);
				if (value <= k) {
					index = Math.max(index, value);
					ans = Math.max(ans, mid);
					low = mid + 1;
				} else
					high = mid - 1;
			}
			String str = String.valueOf(ans);

			for (char i : str.toCharArray()) {
				if (k == index)
					pw.println(i);
				index++;
			}
		}

		pw.close();
	}

	static final Random random = new Random();

	static void ruffleSort(int[] a) {
		int n = a.length;
		for (int i = 0; i < n; i++) {
			int oi = random.nextInt(n), temp = a[oi];
			a[oi] = a[i];
			a[i] = temp;
		}
		ArrayList<Integer> lst = new ArrayList<>();
		for (int i : a)
			lst.add(i);
		Collections.sort(lst);
		for (int i = 0; i < n; i++)
			a[i] = lst.get(i);
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
		long[] readLongArray(int n) {
			long []a = new long[n];
			for (int i = 0; i < n; i++)
				a[i] = nextLong();
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