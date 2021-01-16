import java.io.*;
import java.util.*;

public class D {

    public static void main(String[] args) throws IOException {

        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        int[][] dp = new int[10001][10001];

        for (int i = 0; i < 10001; i++)
            for (int j = 0; j < 10001; j++)
                dp[i][j] = -1;

        dp[0][0] = 0;

        int total_sum = 0;

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            b[i] = in.nextInt();
            total_sum += b[i];
            for (int taken = i; taken >= 0; taken--) {
                for (int sum = 0; sum <= taken * 100; sum++) {
                    int m = dp[taken][sum];
                    if (m < 0)
                        continue;
                    dp[taken + 1][sum + a[i]] = Math.max(dp[taken + 1][sum + a[i]], m + b[i]);
                }
            }
        }

        double[] ans = new double[n + 1];

        for (int taken = 1; taken <= n; taken++) {
            for (int sum = 0; sum <= taken * 100; sum++) {
                int sum_b = dp[taken][sum];
                if (sum_b < 0)
                    continue;
                ans[taken] = Math.max(ans[taken], Math.min((double) sum, (total_sum + sum_b) / 2.0));
            }
        }

        for (int i = 1; i <= n; i++)
            pw.print(String.format("%.10f", ans[i]) + " ");
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