import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int K;
    private PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o2.cnt - o1.cnt);
    private ArrayList<Integer> res = new ArrayList<>();

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            pq.add(new Node(i + 1, Integer.parseInt(st.nextToken())));
        }

        if (pq.peek().cnt > (N + 1) / 2) {
            System.out.println(-1);
            return;
        }

        Node first = pq.poll();
        res.add(first.number);
        first.cnt--;
        if (first.cnt > 0) pq.add(first);

        while (!pq.isEmpty()) {
            Node cur = pq.poll();

            if (res.get(res.size() - 1) == cur.number) {
                if (pq.isEmpty()) {
                    System.out.println(-1);
                    return;
                }

                Node next = pq.poll();
                res.add(next.number);
                next.cnt--;

                if (next.cnt > 0) pq.add(next);
                pq.add(cur);
            } else {
                res.add(cur.number);
                cur.cnt--;
                if (cur.cnt > 0) pq.add(cur);
            }
        }

        for (int number : res) {
            sb.append(number).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int number;
        int cnt;

        public Node(int number, int cnt) {
            this.number = number;
            this.cnt = cnt;
        }
    }
}
