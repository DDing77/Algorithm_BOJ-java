import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private int D;
    private List<Rule> rules;

    private boolean check(int mid) {
        long cnt = 0L;
        for (Rule rule : rules) {
            cnt += rule.getCount(mid);
        }
        return cnt >= D;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;
        rules = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int interval = Integer.parseInt(st.nextToken());
            rules.add(new Rule(start, end, interval));

            left = Math.min(left, start);
            right = Math.max(right, end);
        }

        left -= 1;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Rule {

        int start;
        int end;
        int interval;

        public Rule(int start, int end, int interval) {
            this.start = start;
            this.end = end;
            this.interval = interval;
        }

        public int getCount(int target) {
            if (target < start) {
                return 0;
            }
            return ((Math.min(target, end) - start) / interval) + 1;
        }
    }
}
