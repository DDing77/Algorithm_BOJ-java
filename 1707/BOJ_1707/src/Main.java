import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private int K, V, E;
    private ArrayList<Integer>[] adj;
    private int[] sets;
    private StringBuilder sb;

    public void bfs() {
        Queue<Integer> que = new LinkedList<>();
        sets = new int[V + 1];

        for (int i = 1; i <= V; i++) {
            if (sets[i] == 0) {
                que.add(i);
                sets[i] = 1;
            }

            while (!que.isEmpty()) {
                int cur = que.poll();

                for (int next : adj[cur]) {
                    if (sets[next] == 0) {
                        if (sets[cur] == 1) {
                            sets[next] = 2;
                        } else {
                            sets[next] = 1;
                        }
                        que.add(next);
                    } else {
                        if (sets[next] == sets[cur]) {
                            sb.append("NO").append('\n');
                            return;
                        }
                    }
                }
            }
        }
        sb.append("YES").append('\n');
        return;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        while (K-- > 0) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            adj = new ArrayList[V + 1];
            for (int i = 0; i <= V; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());

                adj[from].add(to);
                adj[to].add(from);
            }

            bfs();
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
