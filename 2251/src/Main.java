import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] limit;
    static boolean[] possible = new boolean[201];
    static boolean[][][] visit = new boolean[201][201][201];
    static StringBuilder sb = new StringBuilder();

    static class State {
        int[] X;

        State(int[] _X) {
            this.X = new int[3];
            for (int i = 0; i < 3; i++) X[i] = _X[i];
        }

        State move(int from, int to, int[] limit) {
            int[] nX = new int[]{X[0], X[1], X[2]};
            if (X[from] + X[to] <= limit[to]) {
                nX[to] = nX[from] + nX[to];
                nX[from] = 0;
            } else {
                nX[from] -= limit[to] - nX[to];
                nX[to] = limit[to];
            }
            return new State(nX);
        }
    }

    static void bfs(int x1, int x2, int x3) {
        Queue<State> que = new LinkedList<>();
        visit[x1][x2][x3] = true;
        que.add(new State(new int[]{x1, x2, x3}));

        while (!que.isEmpty()) {
            State st = que.poll();
            if (st.X[0] == 0) possible[st.X[2]] = true;
            for (int from = 0; from < 3; from++) {
                for (int to = 0; to < 3; to++) {
                    if (from == to) continue;
                    State nxt = st.move(from, to, limit);
                    if (!visit[nxt.X[0]][nxt.X[1]][nxt.X[2]]) {
                        visit[nxt.X[0]][nxt.X[1]][nxt.X[2]] = true;
                        que.add(nxt);
                    }
                }
            }
        }
    }

    static void solution() {
        bfs(0, 0, limit[2]);
        for (int i = 0; i <= 200; i++) {
            if (possible[i]) sb.append(i).append(' ');
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        limit = new int[3];
        for (int i = 0; i < 3; i++) {
            limit[i] = Integer.parseInt(st.nextToken());
        }

        solution();
    }
}
