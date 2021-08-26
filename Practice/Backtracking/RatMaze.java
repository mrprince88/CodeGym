import java.io.*;
import java.util.*;

class RatMaze {

    static void MazeSolve(int [][]a, int [][]path, int x, int y, int n) {


        if (x == n - 1 && y == n - 1) {
            path[x][y] = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++)
                    System.out.print(path[i][j] + " ");
                System.out.println();
            }
            System.out.println();
            path[x][y] = 0;
            return;
        }


        if (x < 0 || y < 0 || x >= n || y >= n) {
            return;
        }

        if (a[x][y] == 0 || path[x][y] == 1) {
            return;
        }

        path[x][y] = 1;
        MazeSolve(a, path, x + 1, y, n);
        MazeSolve(a, path, x - 1, y, n);
        MazeSolve(a, path, x, y + 1, n);
        MazeSolve(a, path, x, y - 1, n);
        path[x][y] = 0;
    }

    public static void main(String[] args)throws IOException {

        InputReader in = new InputReader();
        int n = in.nextInt();
        int [][]a = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = in.nextInt();
        int [][]path = new int[n][n];
        MazeSolve(a, path, 0, 0, n);
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