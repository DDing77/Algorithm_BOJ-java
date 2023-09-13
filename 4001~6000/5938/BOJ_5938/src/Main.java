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
    ArrayList<Integer>[] adj;
    boolean[] nodes;

    public void execBFS() {
        Queue<Integer> que = new ArrayDeque<>();
        que.add(1);
        nodes[1] = true;

        while (!que.isEmpty()) {
            int cur = que.poll();

            for (int next : adj[cur]) {
                if (!nodes[next]) {
                    que.add(next);
                    nodes[next] = true;
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        adj = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            adj[start].add(end);
            adj[end].add(start);
        }

        nodes = new boolean[N + 1];
        execBFS();

        boolean isAll = true;
        for (int i = 2; i <= N; i++) {
            if (!nodes[i]) {
                isAll = false;
                sb.append(i).append('\n');
            }
        }


        if (isAll) {
            System.out.println(0);
        } else {
            System.out.print(sb);
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
