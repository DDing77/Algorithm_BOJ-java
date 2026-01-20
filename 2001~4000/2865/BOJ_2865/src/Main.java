import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;
    private PriorityQueue<Info> pq = new PriorityQueue<>();
    private boolean[] selected;
    private double res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        selected = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int id = Integer.parseInt(st.nextToken());
                double score = Double.parseDouble(st.nextToken());

                pq.add(new Info(id, score));
            }
        }

        int cnt = 0;
        while (!pq.isEmpty() && cnt < K) {
            Info cur = pq.poll();
            if (!selected[cur.id]) {
                selected[cur.id] = true;
                res += cur.score;
                cnt++;
            }
        }

        System.out.printf("%.1f%n", res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Info implements Comparable<Info> {
        int id;
        double score;

        public Info(int id, double score) {
            this.id = id;
            this.score = score;
        }

        @Override
        public int compareTo(Info o) {
            return Double.compare(o.score, this.score);
        }
    }
}
