import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int K;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int i = 0; i < N; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }

        int cnt = 0;
        while (!pq.isEmpty()) {
            cnt++;
            int cur = pq.poll();
            res = res / 2 + cur;
            sb.append(res).append("\n");

            int next = cur - M;
            if (next > K) {
                pq.add(next);
            }
        }
        System.out.println(cnt);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
