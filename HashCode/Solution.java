import java.io.*;
import java.util.*;

class Solution {

    static private final String[] INPUT = { "input_data/a_an_example.in.txt", "input_data/b_better_start_small.in.txt",
            "input_data/c_collaboration.in.txt", "input_data/d_dense_schedule.in.txt",
            "input_data/e_exceptional_skills.in.txt", "input_data/f_find_great_mentors.in.txt" };
    static private final String[] OUTPUT = { "output/a_an_example.out.txt", "output/b_better_start_small.out.txt",
            "output/c_collaboration.out.txt", "output/d_dense_schedule.out.txt", "output/e_exceptional_skills.out.txt",
            "output/f_find_great_mentors.out.txt" };

    public static void main(String[] args) {

        long startTime = System.nanoTime() / 1000000000;
        FileInputStream instream = null;
        PrintStream outstream = null;

        try {
            for (int i = 0; i < INPUT.length; i++) {
                instream = new FileInputStream(INPUT[i]);
                outstream = new PrintStream(new FileOutputStream(OUTPUT[i]));
                System.setIn(instream);
                System.setOut(outstream);
                solve();
            }
        } catch (Exception e) {
            System.err.println("Error");
        }

        double endTime = System.nanoTime() / 1000000000;
        double totalTime = endTime - startTime;
        System.err.format("%.8f\n", totalTime);
        return;
    }

    public static void solve() {
        InputReader in = new InputReader();

        int C = in.nextInt(), P = in.nextInt();

        List<Contributor> contributors = new ArrayList<>();

        for (int i = 0; i < C; i++) {
            String[] input = in.nextLine().split(" ");
            List<Skill> tmp = new ArrayList<>();

            for (int j = 0; j < Integer.parseInt(input[1]); j++) {
                String[] input2 = in.nextLine().split(" ");
                Skill newSkill = new Skill(input2[0], Integer.parseInt(input2[1]));
                tmp.add(newSkill);
            }
            contributors.add(new Contributor(input[0], tmp));
        }

        List<Project> projects = new ArrayList<>();

        for (int i = 0; i < P; i++) {
            String[] input = in.nextLine().split(" ");
            List<Skill> tmp = new ArrayList<>();

            for (int j = 0; j < Integer.parseInt(input[4]); j++) {
                String[] input2 = in.nextLine().split(" ");
                Skill newSkill = new Skill(input2[0], Integer.parseInt(input2[1]));
                tmp.add(newSkill);
            }
            projects.add(new Project(input[0], Integer.parseInt(input[1]), Integer.parseInt(input[2]),
                    Integer.parseInt(input[3]), Integer.parseInt(input[4]), tmp));
        }

    }

    static class Contributor {
        String name;
        List<Skill> skills;

        Contributor(String name, List<Skill> skills) {
            this.name = name;
            this.skills = skills;
        }

        void print() {
            System.out.println(name);
            for (int i = 0; i < skills.size(); i++)
                System.out.println(skills.get(i).name + " " + skills.get(i).level);
        }
    }

    static class Project {
        String name;
        int days, score, bestBefore, roles;
        List<Skill> skills;

        Project(String name, int d, int s, int bb, int r, List<Skill> skList) {
            this.name = name;
            days = d;
            score = s;
            bestBefore = bb;
            roles = r;
            skills = skList;
        }

        void print() {
            System.out.println(name + " " + days + " " + score + " " + bestBefore + " " + roles);
            for (int i = 0; i < skills.size(); i++)
                System.out.println(skills.get(i).name + " " + skills.get(i).level);
        }
    }

    static class Skill {
        String name;
        int level;

        Skill(String name, int level) {
            this.name = name;
            this.level = level;
        }
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
