import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int N;
    int M;
    int K;
    ArrayList<Integer>[] edges;
    boolean[] isVisited;
    Queue<Integer> que;
    int res;

    public void execBFS() {
        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : edges[cur]) {
                if (isVisited[next]) {
                    continue;
                }

                que.add(next);
                res++;
                isVisited[next] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        que = new ArrayDeque<>();
        isVisited = new boolean[N + 1];
        res = 0;
        for (int i = 0; i < M; i++) {
            int node = Integer.parseInt(br.readLine());
            que.add(node);
            isVisited[node] = true;
            res++;
        }

        edges = new ArrayList[N + 1];
        for (int i = 1; i < N + 1; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            edges[from].add(to);
            edges[to].add(from);
        }

        execBFS();

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
