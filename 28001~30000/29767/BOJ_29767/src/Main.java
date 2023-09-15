import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    PriorityQueue<Long> pq;
    long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        pq = new PriorityQueue<>((o1, o2) -> {
            if(o1 <= o2) {
                return 1;
            } else {
                return -1;
            }
        });

        long pre = 0L;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pre += Integer.parseInt(st.nextToken());
            pq.add(pre);
        }

        res = 0L;
        for (int i = 0; i < K; i++) {
            res += pq.poll();
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
