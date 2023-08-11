import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    int N;
    int M;
    int R;
    List<Integer>[] edges;
    boolean[] isVisited;
    int[] order;
    int cnt;

    public void dfs(int node) {
        isVisited[node] = true;
        order[node] = cnt++;

        for (int next : edges[node]) {
            if (!isVisited[next]) {
                dfs(next);
            }
        }
    }

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        N = readInt();
        M = readInt();
        R = readInt();

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        while (M-- > 0) {
            int start = readInt();
            int end = readInt();
            edges[start].add(end);
            edges[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i], Collections.reverseOrder());
        }

        isVisited = new boolean[N + 1];
        order = new int[N + 1];
        cnt = 1;
        dfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(order[i]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }

    public static int readInt() throws IOException {
        int c;
        int n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }
}
