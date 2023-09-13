import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    int start;
    int end;
    int N;
    int M;
    ArrayList<Integer>[] adj;
    boolean[] nodes;
    int res;

    public void execBFS() throws IOException {
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{start, 0});
        nodes[start] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == end) {
                res = cur[1];
                return;
            }

            for (int next : adj[cur[0]]) {
                if (!nodes[next]) {
                    nodes[next] = true;
                    que.add(new int[]{next, cur[1] + 1});
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adj[from].add(to);
            adj[to].add(from);
        }

        nodes = new boolean[N + 1];
        res = -1;
        execBFS();

        System.out.println(res);

    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}

