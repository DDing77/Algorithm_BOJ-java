import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    final int SIZE = 100_000;
    final int[] dir = {-1, 1, 2};
    int N;
    int K;
    int[] time;
    int[] parent;
    Stack<Integer> route;

    public void execBFS() {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(N);
        time[N] = 1;

        while (!que.isEmpty()) {
            int cur = que.poll();

            if(cur == K) {
                break;
            }

            for (int i = 0; i < dir.length; i++) {
                int next = cur + dir[i];

                if (i == dir.length - 1) {
                    next = cur * dir[i];
                }

                if (next < 0 || next > SIZE) {
                    continue;
                }
                if (time[next] != 0) {
                    continue;
                }

                que.add(next);
                parent[next] = cur;
                time[next] = time[cur] + 1;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        time = new int[SIZE + 1];
        parent = new int[SIZE + 1];

        execBFS();

        route = new Stack<>();
        int node = K;
        route.add(node);
        while (node != N) {
            route.add(parent[node]);
            node = parent[node];
        }

        sb.append(time[K] - 1).append('\n');
        while (!route.isEmpty()) {
            sb.append(route.pop()).append(" ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
