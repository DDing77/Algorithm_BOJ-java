import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    int T;
    int n;
    int k;
    int t;
    int m;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Team[] teams = new Team[n];
            for (int i = 0; i < n; i++) {
                teams[i] = new Team(i + 1, k);
            }

            for (int i = 1; i <= m; i++) {
                st = new StringTokenizer(br.readLine());
                int id = Integer.parseInt(st.nextToken());
                int j = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                teams[id - 1].solveProblem(j, s, i);
            }

            Arrays.sort(teams);
            for (int i = 0; i < teams.length; i++) {
                if (teams[i].id == t) {
                    sb.append(i + 1).append('\n');
                }
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    static class Team implements Comparable<Team> {
        int id;
        int scoreTotal;

        int cnt;
        int last;
        int[] problems;

        public Team(int id, int problemSize) {
            this.id = id;
            this.problems = new int[problemSize + 1];
        }

        public void solveProblem(int problemNumber, int score, int logIdx) {
            if (problems[problemNumber] < score) {
                this.scoreTotal -= problems[problemNumber];
                problems[problemNumber] = score;
                this.scoreTotal += problems[problemNumber];
            }
            this.cnt++;
            this.last = logIdx;
        }

        @Override
        public int compareTo(Team o) {
            if (this.scoreTotal == o.scoreTotal) {
                if (this.cnt == o.cnt) {
                    return Integer.compare(this.last, o.last);
                }
                return Integer.compare(this.cnt, o.cnt);
            }
            return Integer.compare(o.scoreTotal, this.scoreTotal);
        }

        @Override
        public String toString() {
            return "Team{" +
                    "id=" + id +
                    ", score=" + scoreTotal +
                    ", cnt=" + cnt +
                    ", last=" + last +
                    '}';
        }
    }
}
