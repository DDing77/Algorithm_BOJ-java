import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int M;
    static PriorityQueue<Long> pq;
    static long res;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        res = 0L;
        pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long cur = Long.parseLong(st.nextToken());
            res += cur;
            pq.add(cur);
        }

        long pre;
        for (int i = 0; i < M; i++) {
            pre = pq.poll() + pq.poll();
            res += pre;
            pq.add(pre);
            pq.add(pre);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
