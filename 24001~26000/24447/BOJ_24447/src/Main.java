import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    int N;
    int M;
    int R;
    int[] depth;
    int[] order;
    ArrayList<Integer>[] edges;
    long res;

    public void execBFS() {
        order = new int[N + 1];
        order[R] = 1;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(R);

        int rank = 2;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : edges[cur]) {
                if (depth[next] == -1) {
                    depth[next] = depth[cur] + 1;
                    order[next] = rank++;
                    que.add(next);
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        depth = new int[N + 1];
        Arrays.fill(depth, -1);
        depth[R] = 0;

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            edges[start].add(end);
            edges[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i]);
        }

        execBFS();

        res = 0L;
        for (int i = 1; i <= N; i++) {
            res += (long) order[i] * depth[i];
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
