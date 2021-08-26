import java.io.*;
import java.util.*;

class nQueens {

    static boolean isPossible(int [][]a, int row, int col, int n) {
        for (int i = row - 1; i >= 1; i--) {
            if (a[i][col] == 1)
                return false;
        }

        for (int i = row - 1, j = col - 1; i >= 1 && j >= 1; i--, j--) {
            if (a[i][j] == 1)
                return false;
        }

        for (int i = row - 1, j = col + 1; i >= 1 && j <= n; i--, j++) {
            if (a[i][j] == 1)
                return false;
        }

        return true;
    }

    static void nQueen(int [][]a, int n, int row) {
        if (n + 1 == row) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++)
                    System.out.print(a[i][j] + " ");
                System.out.println();
            }
            System.out.println("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (isPossible(a, row, i, n)) {
                a[row][i] = 1;
                nQueen(a, n, row + 1);
                a[row][i] = 0;
            }
        }

        return;
    }


    public static void main(String[] args)throws IOException {

        InputReader in = new InputReader();
        int n = in.nextInt();
        int [][]a = new int[n + 1][n + 1];
        nQueen(a, n, 0);
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