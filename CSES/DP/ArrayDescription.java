import java.io.*;
import java.util.*;

class ArrayDescription {

	public static void main(String[] args) {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int n=in.nextInt();
		int m=in.nextInt();
		int []arr=in.readArray(n);
		int [][]dp=new int[n+2][m+2];
		int mod=(int)(1e9+7);

		for(int i=1;i<=n;i++) {
			for(int j=1;j<=m;j++) {
				if(i==1) {
					if(arr[i-1]==0 || arr[i-1]==j)
						dp[i][j]=1;
				}

				else {
					if(arr[i-1]==0 || arr[i-1]==j)
						dp[i][j]=(dp[i-1][j-1]+(dp[i-1][j]+dp[i-1][j+1])%mod)%mod;
				}
			}
		}

		int res=0;

		for(int i=1;i<=m;i++)
			res=(res+dp[n][i])%mod;

		System.out.println(res);

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