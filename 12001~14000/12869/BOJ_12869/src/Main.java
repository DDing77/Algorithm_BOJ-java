import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dir = {{-9, -3, -1}, {-9, -1, -3}, {-3, -9, -1}, {-3, -1, -9}, {-1, -9, -3}, {-1, -3, -9}};

    private int N;
    private int[] SCV;
    private int[][][] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        SCV = new int[3];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SCV[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[SCV[0] + 1][SCV[1] + 1][SCV[2] + 1];

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{SCV[0], SCV[1], SCV[2], 0});
        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];
                int nZ = cur[2] + dir[i][2];
                nX = Math.max(0, nX);
                nY = Math.max(0, nY);
                nZ = Math.max(0, nZ);

                if (nX == 0 && nY == 0 && nZ == 0) {
                    System.out.println(cur[3] + 1);
                    return;
                }

                if (dp[nX][nY][nZ] == 0) {
                    dp[nX][nY][nZ] = cur[3] + 1;
                    que.add(new int[]{nX, nY, nZ, cur[3] + 1});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
