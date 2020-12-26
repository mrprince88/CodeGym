import java.io.*;
import java.util.*;

class Problem4 {

    static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    static int maxfact(int g, int n) {
        int max_fact = 0;
        for (int i = 1; i <= g; i++) {
            if (g % i == 0) {
                if (i <= n)
                    max_fact = Math.max(max_fact, i);
                if (g / i <= n)
                    max_fact = Math.max(max_fact, g / i);
            }
        }
        return max_fact;
    }

    public static void main(String[] args) throws IOException {

        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int[] p = new int[m];
            int g = 0;
            for (int i = 0; i < m; i++) {
                p[i] = in.nextInt();
                g = gcd(g, p[i]);
            }
            if (g > n)
                g = maxfact(g, n);

            pw.println(n - g);

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
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
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