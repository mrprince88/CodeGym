// Connected Horses - HackerEarth
import java.io.*;
import java.util.*;

public class ConnnectedHorses {

	static class Pair {
		int x, y;
		Pair(int x1, int y1) {
			x = x1; y = y1;
		}
	}

	static int [][]dirs = {{ -2, 1}, {2, -1}, { -1, -2}, { -1, 2}, {1, 2}, {1, -2}, { -2, -1}, {2, 1}};
	static int [][]graph;
	static int n, m;
	static int mod = (int)(1e9 + 7);
	static long []fact;

	static int solver() {
		boolean [][]visited = new boolean[n + 1][m + 1];
		long res = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (!visited[i][j] && graph[i][j] == 1) {
					int len = bfs(i, j, visited);
					res = (res % mod * fact[len] % mod) % mod;
				}
			}
		}

		return (int)res;
	}

	static int bfs(int x, int y, boolean [][]visited) {
		visited[x][y] = true;
		int len = 1;
		Queue<Pair> q = new LinkedList<>();
		q.add(new Pair(x, y));

		while (!q.isEmpty()) {
			Pair curr = q.poll();
			int i = curr.x, j = curr.y;
			for (int []dir : dirs) {
				int x1 = i + dir[0], y1 = j + dir[1];
				if (x1 >= 0 && x1 < n && y1 >= 0 && y1 < m && !visited[x1][y1] && graph[x1][y1] == 1) {
					visited[x1][y1] = true;
					len++;
					q.add(new Pair(x1, y1));
				}
			}
		}
		return len;
	}

	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);

		fact = new long[1000000 + 1];
		fact[0] = 1;

		for (int i = 1; i < 1000000; i++)
			fact[i] = (fact[i - 1] * i) % mod;

		int t = in.nextInt();
		while (t-- > 0) {
			n = in.nextInt(); m = in.nextInt();
			int q = in.nextInt();
			int [][]pos = in.read2dArray(q, 2);
			graph = new int[n][m];

			for (int []p : pos)
				graph[p[0] - 1][p[1] - 1] = 1;

			System.out.println(solver());
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