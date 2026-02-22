import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    private int N;
    private int M;

    private boolean[] small;
    private boolean[][] visited;

    private static final int MAX_JUMP = 150;

    private boolean isIn(int pos) {
        return 0 < pos && pos <= N;
    }

    private int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{1, 0, 0});  // pos, jump, count
        visited[1][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int pos = cur[0];
            int jump = cur[1];
            int count = cur[2];

            if (pos == N) {
                return count;
            }

            for (int d = -1; d <= 1; d++) {
                int nextJump = jump + d;

                if (nextJump <= 0) {
                    continue;
                }
                if (nextJump >= MAX_JUMP) {
                    continue;
                }

                int nextPos = pos + nextJump;

                if (!isIn(nextPos)) {
                    continue;
                }
                if (small[nextPos]) {
                    continue;
                }
                if (visited[nextPos][nextJump]) {
                    continue;
                }

                visited[nextPos][nextJump] = true;
                queue.add(new int[]{nextPos, nextJump, count + 1});
            }
        }

        return -1;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        small = new boolean[N + 1];
        visited = new boolean[N + 1][MAX_JUMP];

        for (int i = 0; i < M; i++) {
            int idx = Integer.parseInt(br.readLine());
            small[idx] = true;
        }

        System.out.println(bfs());
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}