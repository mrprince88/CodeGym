import java.io.*;
import java.util.*;

public class Three {


	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int t = in.nextInt();
		while (t-- > 0) {
			int n = in.nextInt();
			int []a = in.readArray(n);
			int []b = new int[n];
			System.arraycopy(a, 0, b, 0, n);
			Arrays.sort(b, (c, d)->d - c);
			// HashMap<Integer, Integer> map = new HashMap<>();
			// int []freq = new int[1001];
			// for (int i = 0; i < n; i++) {
			// 	freq[b[i]]++;
			// 	map.put(b[i], n - i);
			// }
			// for (int i = 0; i < n; i++) {
			// 	if (freq[a[i]] > 1) {
			// 		pw.print(map.get(a[i]) + " ");
			// 		map.put(a[i], map.get(a[i]) + 1);
			// 		freq[a[i]]--;
			// 	} else
			// 		pw.print(map.get(a[i]) + " ");
			// }
			pw.println(b);
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