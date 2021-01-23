import java.io.*;
import java.util.*;

public class C {

	static int [][]ans;
	static boolean []visited;

	static int findIdx(int []arr, int n, int val) {
		int min = 0, max = 2 * n - 1;
		while (min <= max) {
			int mid = (max + min) / 2;
			if (val == arr[mid]) {
				if (visited[mid])
					min = mid + 1;
				else if (mid >= 1 && val == arr[mid - 1] && !visited[mid - 1])
					max = mid - 1;
				else
					return mid;
			} else if (val > arr[mid])
				min = mid + 1;
			else
				max = mid - 1;
		}
		return -1;
	}

	static boolean solve(int []arr, int n, int idx) {
		visited = new boolean[2 * n];
		ans = new int[n][2];
		ans[0][0] = arr[2 * n - 1];
		ans[0][1] = arr[idx];
		visited[2 * n - 1] = visited[idx] = true;

		for (int i = 2 * n - 1, j = 1; i >= 0; i--) {
			if (visited[i])
				continue;
			int nextIdx = findIdx(arr, n, ans[j - 1][0] - arr[i]);
			if (nextIdx == -1 || nextIdx == i) {
				return false;
			}
			ans[j][0] = arr[i];
			ans[j][1] = arr[nextIdx];
			visited[i] = visited[nextIdx] = true;
			j++;
		}
		return true;
	}

	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int t = in.nextInt();
		outer: while (t-- > 0) {
			int n = in.nextInt();
			int []arr = in.readArray(2 * n);
			ruffleSort(arr);

			for (int i = 0; i < 2 * n; i++) {
				if (solve(arr, n, i)) {
					pw.println("YES");
					pw.println(ans[0][0] + ans[0][1]);
					for (int j = 0; j < n; j++)
						pw.println(ans[j][0] + " " + ans[j][1]);
					continue outer;
				}
			}

			pw.println("NO");
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