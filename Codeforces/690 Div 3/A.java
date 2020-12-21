import java.io.*;
import java.util.*;

class A {

    public static void main(String[] args) {

        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);

        int t=in.nextInt();

        while(t-->0) {

            int n=in.nextInt();
            int []a=in.readArray(n);
            
            int i=0,j=a.length-1;
            int []ans=new int[n];
            int x=0;

            while(i<j) {
                ans[x++]=a[i++];
                ans[x++]=a[j--];
            }

            ans[x++]=a[i++];
            
            for(int k=0;k<n;k++)
            pw.print(ans[k]+" ");
            pw.println();
        }
     pw.close();
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
                } catch (final IOException e) {
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
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
        int[][] read2DArray(int n, int m) {
            final int [][]arr = new int[n][m];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < m; j++)
                    arr[i][j] = nextInt();
            return arr;
        }
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (final IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}