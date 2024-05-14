import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int L;
    private int K;
    private int res;
    private List<Problem> problemList;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        problemList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            problemList.add(new Problem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        Collections.sort(problemList);

        for (Problem problem : problemList) {
            if (K == 0) {
                break;
            }
            if (problem.hard <= L) {
                res += 140;
                K--;
            } else if (problem.easy <= L) {
                res += 100;
                K--;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Problem implements Comparable<Problem> {

        int easy;
        int hard;

        public Problem(int easy, int hard) {
            this.easy = easy;
            this.hard = hard;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.hard == o.hard) {
                return Integer.compare(this.easy, o.easy);
            }
            return Integer.compare(this.hard, o.hard);
        }
    }
}
