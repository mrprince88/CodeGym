import java.io.*;
import java.util.*;

class E1 {

    static int upperBound(int[] arr, int n) {

        int max = arr.length - 1, min = 0, res = -1;

        while (min <= max) {

            int mid = min + (max - min) / 2;

            if (arr[mid] <= n) {
                min = mid + 1;
                res = mid;
            }

            else
                max = mid - 1;
        }
        return res;
    }

    public static void main(String[] args) {
        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);

        int t = in.nextInt();
        while (t-- > 0) {

            int n = in.nextInt();
            int[] arr = in.readArray(n);
            int[] freq = new int[n + 1];

            for (int i : arr)
                freq[i]++;

            int x = 0;

            for (int i = 1; i < freq.length; i++) {
                while (freq[i]-- > 0) {
                    arr[x++] = i;
                }
            }

            long ans = 0;

            for (int i = 0; i < n; i++) {

                long p = upperBound(arr, arr[i] + 2);

                if (p - i >= 1) {
                    ans += (p - i - 1) * (p - i) / 2;
                }
            }
            pw.println(ans);
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
            int[] a = new int[n];
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
            final int[][] arr = new int[n][m];
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
