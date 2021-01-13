import java.io.*;
import java.util.*;

public class Problem2 {
    public static void main(String[] args) throws IOException {

        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt(), k = in.nextInt();
            int[] h = in.readArray(n);
            LinkedHashSet<Integer> set1 = new LinkedHashSet<>();
            ruffleSort(h);
            int sum = 0;

            set1.add(h[n - 1]);
            sum = h[n - 1];
            int c = -1;

            for (int i = n - 2; i >= 0; i--) {
                LinkedHashSet<Integer> set2 = new LinkedHashSet<>();
                sum += h[i];

                for (int j : set1) {
                    set2.add(j);
                    set2.add(h[i]);
                    set2.add(j + h[i]);
                    if ((j + h[i]) >= k && sum - j - h[i] >= k) {
                        c = n - i;
                        break;
                    }
                    if (h[i] >= k && sum - h[i] >= k) {
                        c = n - i;
                        break;
                    }
                }
                if (c != -1)
                    break;
                set1 = set2;
            }
            pw.println(c);
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