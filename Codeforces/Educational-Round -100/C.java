import java.io.*;
import java.util.*;

public class C {

    public static void main(String[] args) throws IOException {

        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();

            long[][] cmd = new long[n + 1][2];

            cmd[n][0] = Long.MAX_VALUE;
            cmd[n][1] = -1;

            for (int i = 0; i < n; i++) {
                cmd[i][0] = in.nextLong();
                cmd[i][1] = in.nextLong();
            }

            long start = 0, end = 0, ans = 0, pos = 0;

            for (int i = 0; i < n; ++i) {

                if (cmd[i][0] >= end) {
                    end = cmd[i][0] + Math.abs(pos - cmd[i][1]);
                    start = pos;
                    pos = cmd[i][1];
                }

                long time = end, p = pos;

                if (start <= cmd[i][1] && cmd[i][1] <= pos) {
                    time = end - (pos - cmd[i][1]);
                    p = cmd[i][1];
                }

                if (pos <= cmd[i][1] && cmd[i][1] <= start) {
                    time = end + (pos - cmd[i][1]);
                    p = cmd[i][1];
                }

                if (cmd[i][0] <= time && time <= cmd[i + 1][0] && p == cmd[i][1])
                    ++ans;
            }

            pw.println(ans);
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