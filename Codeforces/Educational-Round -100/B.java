import java.io.*;
import java.util.*;

public class B {

    public static void main(String[] args) throws IOException {

        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] arr = new int[n];
            long oddSum = 0L, evenSum = 0L;

            for (int i = 0; i < n; i++) {
                arr[i] = in.nextInt();
                if ((i & 1) == 0)
                    evenSum += arr[i];
                else
                    oddSum += arr[i];
            }

            if (evenSum >= oddSum) {
                for (int i = 0; i < n; i++) {
                    if ((i & 1) == 0)
                        pw.print(arr[i] + " ");
                    else
                        pw.print(1 + " ");
                }
            }

            else {
                for (int i = 0; i < n; i++) {
                    if ((i & 1) == 1)
                        pw.print(arr[i] + " ");
                    else
                        pw.print(1 + " ");
                }
            }
            pw.println();
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