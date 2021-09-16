import java.io.*;
import java.util.*;

class CountingTowers {

	public static void main(String[] args) {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);

		int t=in.nextInt();

		long [][]dp=new long[(int)1e6][2];
		long mod=(int)(1e9+7);

		dp[0][0]=1; dp[0][1]=1;

		//0 -> tiles of width 1
		//1-> width 2

		// op1=do not extend any tiles
		// op2=extend tiles which were not extended
		//op3=extend one the tiles
		//op4=extend tiles which are already extended

		for(int i=1;i<1e6;i++) {
			long op1=dp[i-1][0]+dp[i-1][1];
			long op2=dp[i-1][0];
			long op3=2*dp[i-1][0];
			long op4=dp[i-1][1];

			dp[i][0]=(op1+op2+op3)%mod;
			dp[i][1]=(op1+op4)%mod;
		}

		while(t-->0) {
			int n=in.nextInt();
			long res=(dp[n-1][0]+dp[n-1][1])%mod;
			System.out.println(res);
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