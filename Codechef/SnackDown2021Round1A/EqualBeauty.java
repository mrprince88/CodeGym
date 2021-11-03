import java.io.*;
import java.util.*;

class EqualBeauty {

	public static void main(String[] args) {

		InputReader in = new InputReader();
		PrintWriter pw = new PrintWriter(System.out);
		int t=in.nextInt();

		while(t-->0) {
			int n=in.nextInt();
			int []arr=in.readArray(n);
			if(n<=2) {
			    pw.println(0);
			    continue;
			}
		    ruffleSort(arr);
		    
		    if(n==3) {
		        pw.println(Math.min(arr[1]-arr[0],arr[2]-arr[1]));
		        continue;
		    }
		    
		    long ans1=0,ans2=0;
		    for(int i=0;i<n-1;i++)
		        ans1+=Math.abs(arr[i]-arr[(n-1)/2]);
		        
		    for(int i=1;i<n;i++)
		        ans2+=Math.abs(arr[i]-arr[1+(n-1)/2]);
		      
		    long res=Math.min(ans1,ans2);
		    int l=1,r=n-2;
		    
		    while(l<r) {
		        int diff1=arr[n-1]-arr[l],diff2=arr[r]-arr[0];
		        
		        res=Math.min(res,Math.abs(diff1-diff2));
		        
		        if(diff1<diff2) {
		            l++;
		        }
		        else {
		            r--;
		        }
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