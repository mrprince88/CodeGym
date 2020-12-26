import java.io.*;
import java.util.*;

class Problem5 {

    public static void main(String[] args) throws IOException {

        InputReader in = new InputReader();
        PrintWriter pw = new PrintWriter(System.out);
        int t = in.nextInt();
        while (t-- > 0) {

            String s = in.nextLine();

            int[] maskS = new int[27];

            for (int i = 0; i < s.length(); i++)
                if (s.charAt(i) != '?')
                    maskS[s.charAt(i) - 97] ^= 1;

            List<int[]> allGood = new ArrayList<>();

            allGood.add(maskS);

            for (int i = 0; i < 26; i++) {
                int[] temp = new int[27];
                for (int j = 0; j < 26; j++)
                    temp[j] = maskS[j];
                temp[i] ^= 1;
                temp[26] = 1;
                allGood.add(temp);
            }

            int[] maskPrefix = new int[27];
            Map<String, Integer> map = new HashMap<>();
            map.put("000000000000000000000000000", 1);

            long ans = 0;

            for (int i = 0; i < s.length(); i++) {

                if (s.charAt(i) != '?')
                    maskPrefix[s.charAt(i) - 97] ^= 1;
                else
                    maskPrefix[26] ^= 1;

                for (int[] j : allGood) {

                    String xor = "";

                    for (int k = 0; k <= 26; k++)
                        xor += (maskPrefix[k] ^ j[k]);

                    ans += map.getOrDefault(xor, 0);
                }

                StringBuffer sb = new StringBuffer();
                for (int k = 0; k <= 26; k++)
                    sb.append(maskPrefix[k]);
                String temp = sb.toString();

                int cnt = map.getOrDefault(temp, 0);
                cnt++;
                map.put(temp, cnt);
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