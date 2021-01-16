import java.io.*;
import java.util.*;

class D {

    static boolean check(int []arr,int k,int sum,int n) {

        if(sum%k!=0)
          return false;

        int p=sum/k,curr=0;
        
        for(int i=0;i<n;i++) {
            curr+=arr[i];
            if(curr==p)
              curr=0;
            else if(curr>p)
              return false;
        }
        return true;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t=in.nextInt();

        while(t--> 0) {
            int n=in.nextInt();
            int []arr=in.readArray(n);
            int sum=0;
            for(int i=0;i<n;i++)
              sum+=arr[i];
            
            for(int i=0;i<n;i++) {
                if(check(arr,n-i,sum,n)) {
                    System.out.println(i);
                    break;
                }
            }
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