import java.io.*;
import java.util.*;

public class D {


	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			long m = in.nextLong();
			long []a = in.readLongArray(n);
			int []b = in.readArray(n);
			long sum = 0;
			for (long i : a)
				sum += i;

			if (sum < m) {
				pw.println("-1");
				continue;
			}

			sum = 0;
			ArrayList<Long> arr1 = new ArrayList<>();
			ArrayList<Long> arr2 = new ArrayList<>();

			for (int i = 0; i < n; i++) {
				if (b[i] == 1)
					arr1.add(a[i]);
				else
					arr2.add(a[i]);
			}

			Collections.sort(arr1, Collections.reverseOrder);
			Collections.sort(arr2, Collections.reverseOrder);

			for (long i : arr2)
				sum += i;

			int res = Integer.MAX_VALUE;

			int j = 0;

			for (int i = arr2.size(); i >= 0; i--) {
				while (j < arr1.size() && sum < m) {
					sum += arr1.get(j);
					j++;
				}
				if (sum >= m)
					res = Math.min(res, 2 * i + j);
				if (i > 0)
					sum -= arr2.get(i - 1);
			}
			pw.println(res);
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