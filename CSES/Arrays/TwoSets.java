import java.io.*;
import java.util.*;

public class TwoSets {


	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		long n = in.nextLong();
		long total = n * (n + 1) / 2L;
		if ((total & 1) == 1)
			pw.println("NO");
		else {
			pw.println("YES");
			total = total / 2;
			List<Long> list1 = new ArrayList<Long>();
			List<Long> list2 = new ArrayList<Long>();
			long i = n;
			while (i != 0) {
				if (total - i >= 0) {
					total -= i;
					list1.add(i);
				} else
					list2.add(i);
				i--;
			}
			pw.println(list1.size());
			for (long j : list1)
				pw.print(j + " ");
			pw.println();
			pw.println(list2.size());
			for (long j : list2)
				pw.print(j + " ");
			pw.println();
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