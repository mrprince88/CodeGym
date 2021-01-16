import java.io.*;
import java.util.*;

public class C {

    static long gcd(long a, long b) {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    static long findgcd(long[] a) {
        long res = 0;
        for (int i = 2; i < a.length; i++) {
            res = gcd(res, Math.abs(a[i] - a[i - 1]));
            if (res == 1)
                return 1;
        }
        return res;
    }

    public static void main(String[] args) throws IOException {

        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt(), m = in.nextInt();
        long[] a = in.readLongArray(n);
        long[] b = in.readLongArray(m);
        long temp = findgcd(a);
        for (int i = 0; i < m; i++) {
            pw.print(gcd(b[i] + a[0], temp) + " ");
        }
        pw.println();
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

        int[][] read2dArray(int n, int m) {
            int[][] a = new int[n][m];
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