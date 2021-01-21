import java.io.*;
import java.util.*;

public class ChessboardAndQueens {

	static boolean isPossible(int [][]board, int row, int col) {

		if (board[row][col] == -1)
			return false;

		for (int i = row - 1; i >= 0; i--)
			if (board[i][col] == 1)
				return false;

		for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
			if (board[i][j] == 1)
				return false;
		}

		for (int i = row - 1, j = col + 1; i >= 0 && j < 8; i--, j++) {
			if (board[i][j] == 1)
				return false;
		}
		return true;
	}

	static int ans = 0;

	static void solve(int [][]board, int row) {
		if (row == board.length) {
			ans++;
			return;
		}

		for (int i = 0; i < 8; i++) {
			if (isPossible(board, row, i)) {
				board[row][i] = 1;
				solve(board, row + 1);
				board[row][i] = 0;
			}
		}

	}
	public static void main(String[] args)throws IOException {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int [][]board = new int[8][8];

		for (int i = 0; i < 8; i++) {
			String str = in.nextLine();
			for (int j = 0; j < 8; j++) {
				if (str.charAt(j) == '.')
					board[i][j] = 0;
				else
					board[i][j] = -1;
			}
		}
		solve(board, 0);
		pw.println(ans);

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