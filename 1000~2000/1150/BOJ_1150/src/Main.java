import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static class Info {
        int dist;
        int idx;

        public Info(int dist, int idx) {
            this.dist = dist;
            this.idx = idx;
        }
    }

    static int N, K;
    static int[] dist;
    static int[] left, right;
    static boolean[] isVisited;
    static int res;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[N + 2];
        right = new int[N + 2];
        left = new int[N + 2];
        isVisited = new boolean[N + 2];

        dist[1] = 1_000_000_000;
        dist[N + 1] = 1_000_000_000;

        left[N + 1] = N;
        right[1] = 2;

        PriorityQueue<Info> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.dist));
        pq.add(new Info(1_000_000_000, 1));
        pq.add(new Info(1_000_000_000, N + 1));

        int s1 = Integer.parseInt(br.readLine());
        for (int i = 2; i <= N; i++) {
            int s2 = Integer.parseInt(br.readLine());
            dist[i] = s2 - s1;
            pq.add(new Info(dist[i], i));
            left[i] = i - 1;
            right[i] = i + 1;
            s1 = s2;
        }

        res = 0;
        while (K-- > 0) {
            while (isVisited[pq.peek().idx]) {
                System.out.println("test, dist : " + pq.peek().dist + " , idx : " + pq.peek().idx);
                pq.poll();
            }
            Info cur = pq.poll();
            int d = cur.dist;
            int idx = cur.idx;
            System.out.println("Info, dist : " + d + " , idx : " + idx);
            res += d;
            dist[idx] = dist[left[idx]] + dist[right[idx]] - dist[idx];
            pq.add(new Info(dist[idx], idx));
            isVisited[left[idx]] = true;
            isVisited[right[idx]] = true;
            left[idx] = left[left[idx]];
            right[idx] = right[right[idx]];
            right[left[idx]] = idx;
            left[right[idx]] = idx;
        }

        System.out.println(res);
    }
}
