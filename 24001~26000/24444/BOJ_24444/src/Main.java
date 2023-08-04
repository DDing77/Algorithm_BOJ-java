import java.io.IOException;
import java.util.*;

public class Main {

    int N;
    int M;
    int R;
    ArrayList<Integer>[] edges;
    int[] isVisited;

    public void execBFS() {
        int order = 1;
        Queue<Integer> que = new ArrayDeque<>();
        que.add(R);
        isVisited[R] = order++;

        while (!que.isEmpty()) {
            int cur = que.poll();
            for (int next : edges[cur]) {
                if (isVisited[next] != 0) {
                    continue;
                }

                isVisited[next] = order++;
                que.add(next);
            }
        }
    }

    public void solution() throws IOException {
        StringBuilder sb = new StringBuilder();

        N = readInt();
        M = readInt();
        R = readInt();

        edges = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int start = readInt();
            int end = readInt();

            edges[start].add(end);
            edges[end].add(start);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(edges[i]);
        }

        isVisited = new int[N + 1];
        execBFS();

        for (int i = 1; i <= N; i++) {
            sb.append(isVisited[i]).append('\n');
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
