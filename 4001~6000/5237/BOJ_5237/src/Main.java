import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    final String[] message = {"Connected.", "Not connected."};
    int T;
    int N;
    int K;
    ArrayList<Integer>[] edges;
    boolean[] isVisited;

    public void execBFS() {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(0);

        isVisited = new boolean[N];
        isVisited[0] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : edges[cur]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.add(next);
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            edges = new ArrayList[N];
            for (int i = 0; i < N; i++) {
                edges[i] = new ArrayList<>();
            }

            for (int i = 0; i < K; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                edges[from].add(to);
                edges[to].add(from);
            }

            execBFS();

            boolean flag = true;
            for (int i = 0; i < N; i++) {
                if (!isVisited[i]) {
                    flag = false;
                    break;
                }
            }

            if (!flag) {
                sb.append(message[1]);
            } else {
                sb.append(message[0]);
            }
            sb.append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
