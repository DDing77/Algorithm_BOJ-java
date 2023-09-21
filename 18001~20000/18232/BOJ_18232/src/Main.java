import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;

public class Main {

    final int[] dir = {1, -1, 1};
    int N;
    int M;
    int S;
    int E;
    boolean[] isVisited;
    ArrayList<Integer>[] edges;
    int res;

    public boolean access(int node) {
        if (node < 1 || node > N) {
            return false;
        }
        if (isVisited[node]) {
            return false;
        }
        return true;
    }

    public void execBFS() {
        isVisited = new boolean[N + 1];
        isVisited[S] = true;
        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{S, 0});

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == E) {
                res = cur[1];
                break;
            }

            for (int k = 0; k < dir.length; k++) {
                if (k == dir.length - 1) {
                    for (int next : edges[cur[0]]) {
                        if (access(next)) {
                            que.add(new int[]{next, cur[1] + 1});
                            isVisited[next] = true;
                        }
                    }
                } else {
                    int next = cur[0] + dir[k];
                    if (access(next)) {
                        que.add(new int[]{next, cur[1] + 1});
                        isVisited[next] = true;
                    }
                }
            }
        }
    }

    public void solution() throws IOException {
        N = readInt();
        M = readInt();

        S = readInt();
        E = readInt();

        edges = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = readInt();
            int end = readInt();

            edges[start].add(end);
            edges[end].add(start);
        }

        res = 0;
        execBFS();

        System.out.println(res);
    }

    public int readInt() throws IOException {
        int n = System.in.read() & 15;
        int c;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
