import java.io.*;
import java.util.*;
 
class DiceCombinations {
 
	static int solver(int n) {
		int []dp=new int[n+1];
		dp[0]=1;
 
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=6;j++) {
				if(i-j>=0) {
					dp[i]=(dp[i]+dp[i-j])%(int)(1e9+7);
				}
			}
		}
 
		return dp[n]; 
	}
 
	public static void main(String[] args) {
 
		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int n=in.nextInt();
		System.out.println(solver(n));
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
