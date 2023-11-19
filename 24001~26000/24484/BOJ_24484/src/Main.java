import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {

    int N;
    int M;
    int R;
    ArrayList<Integer>[] edges;
    int[] order;
    int[] depth;
    int cnt;
    long res;

    public void execDFS(int here, int dep) {
        depth[here] = dep;
        order[here] = cnt++;

        for (int next : edges[here]) {
            if (depth[next] != -1) {
                continue;
            }
            execDFS(next, dep + 1);
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = readInt();
        M = readInt();
        R = readInt();

        order = new int[N + 1];
        depth = new int[N + 1];
        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = readInt();
            int to = readInt();

            edges[from].add(to);
            edges[to].add(from);
        }

        for (int i = 1; i <= N; i++) {
            depth[i] = -1;
            edges[i].sort(Collections.reverseOrder());
        }

        cnt = 1;
        execDFS(R, 0);

        res = 0;
        for (int i = 1; i <= N; i++) {
            res += (long) order[i] * depth[i];
        }
        System.out.println(res);
    }

    public static int readInt() throws IOException {
        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
