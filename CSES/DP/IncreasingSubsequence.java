import java.io.*;
import java.util.*;

class IncreasingSubsequence {

	public static void main(String[] args) {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int n=in.nextInt();
		int []arr=in.readArray(n);
		int []temp=new int[n];
		temp[0]=arr[0];
		int len=1;

		for(int i=1;i<n;i++) {
			if(arr[i]>temp[len-1])
				temp[len++]=arr[i];
			else {
				int j=upperBound(temp,0,len-1,arr[i]);
				temp[j]=arr[i];
			}
		}

		System.out.println(len);

		pw.close();
	}

	static int upperBound(int[]arr,int min,int max,int n) {
		int res=-1;
		while(min<=max) {
			int mid=min+(max-min)/2;
			if(arr[mid]>=n) {
				res=mid;
				max=mid-1;
			}
			else
				min=mid+1;
		}
		return res;
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