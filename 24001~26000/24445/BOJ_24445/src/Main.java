import java.io.IOException;
import java.util.*;

public class Main {

    int N;
    int M;
    int R;
    int[] order;
    boolean[] isVisited;
    ArrayList<Integer>[] adj;

    public void execBFS() {
        isVisited = new boolean[N + 1];
        order = new int[N + 1];

        Queue<Integer> que = new ArrayDeque<>();
        que.add(R);

        isVisited[R] = true;
        int cnt = 1;

        while (!que.isEmpty()) {
            int cur = que.poll();
            order[cur] = cnt++;

            for (int next : adj[cur]) {
                if (!isVisited[next]) {
                    isVisited[next] = true;
                    que.add(next);
                }
            }
        }
    }

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();
        N = readInt();
        M = readInt();
        R = readInt();


        adj = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = readInt();
            int end = readInt();
            adj[start].add(end);
            adj[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i], Collections.reverseOrder());
        }

        execBFS();

        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }

        System.out.print(sb);


    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public static int readInt() throws IOException {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }
}
