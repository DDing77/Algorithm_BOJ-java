import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int T;
    private int N;
    private PriorityQueue<Long> pq = new PriorityQueue<>();

    private void solution() throws IOException {
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            pq.clear();
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                pq.add(Long.parseLong(st.nextToken()));
            }

            long res = 0L;
            while (pq.size() > 1) {
                long a = pq.poll();
                long b = pq.poll();
                res += a + b;
                pq.add(a + b);
            }
            sb.append(res).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
