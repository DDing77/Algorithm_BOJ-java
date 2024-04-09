import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    static final int[][] dir = {{-3, -2}, {-3, 2}, {3, -2}, {3, 2}, {-2, -3}, {2, -3}, {-2, 3}, {2, 3}};
    int R1;
    int C1;
    int R2;
    int C2;

    private boolean check(int R, int C, int nR, int nC) {

        if (nR < 0 || nR >= 10 || nC < 0 || nC >= 9) {
            return false;
        }

        int minR = Math.min(R, nR);
        int maxR = Math.max(R, nR);
        int minC = Math.min(C, nC);
        int maxC = Math.max(C, nC);

        if (minR < R2 && R2 < maxR && minC < C2 && C2 < maxC) {
            return false;
        }

        return true;
    }

    private int execBFS() {

        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[10][9];
        que.add(new int[]{R1, C1, 0});
        isVisited[R1][C1] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == R2 && cur[1] == C2) {
                return cur[2];
            }

            for (int i = 0; i < dir.length; i++) {
                int nR = cur[0] + dir[i][0];
                int nC = cur[1] + dir[i][1];

                if (!check(cur[0], cur[1], nR, nC)) {
                    continue;
                }
                if (isVisited[nR][nC]) {
                    continue;
                }

                que.add(new int[]{nR, nC, cur[2] + 1});
                isVisited[nR][nC] = true;
            }
        }

        return -1;
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R1 = Integer.parseInt(st.nextToken());
        C1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        R2 = Integer.parseInt(st.nextToken());
        C2 = Integer.parseInt(st.nextToken());


        System.out.println(execBFS());
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
