import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Problem implements Comparable<Problem> {
        int time;
        int cnt;

        public Problem(int time, int cnt) {
            this.time = time;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Problem o) {
            return this.time - o.time;
        }
    }

    private int D, V;
    private int res;
    private Problem[] problems;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        problems = new Problem[11];

        res = 0;
        for (int i = 0; i < 11; i++) {
            st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());
            problems[i] = new Problem(T, V);
        }

        Arrays.sort(problems);

        int pre = 0;
        for (int i = 0; i < 11; i++) {
            res += pre + problems[i].time;
            pre += problems[i].time;
        }

        for (int i = 0; i < 11; i++) {
            res += 20 * problems[i].cnt;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
