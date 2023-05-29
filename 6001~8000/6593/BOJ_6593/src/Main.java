import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private final int[][] dir = {{0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}, {0, 0, -1}, {0, 0, 1}};
    private int L, R, C;
    private char[][][] building;
    private boolean[][][] isVisited;
    private int res;

    public void bfs(int startL, int startR, int startC, int cnt) {
        Queue<Integer> que = new LinkedList<>();
        que.add(startL);
        que.add(startR);
        que.add(startC);
        que.add(cnt);
        isVisited = new boolean[L][R][C];
        isVisited[startL][startR][startC] = true;

        while (!que.isEmpty()) {
            int curZ = que.poll();
            int curX = que.poll();
            int curY = que.poll();
            int curCnt = que.poll();

            if (building[curZ][curX][curY] == 'E') {
                res = curCnt;
                break;
            }

            for (int k = 0; k < 6; k++) {
                int nX = curX + dir[k][0];
                int nY = curY + dir[k][1];
                int nZ = curZ + dir[k][2];

                if (nX < 0 || nX >= R || nY < 0 || nY >= C || nZ < 0 || nZ >= L) {
                    continue;
                }
                if (isVisited[nZ][nX][nY]) {
                    continue;
                }
                if (building[nZ][nX][nY] == '#') {
                    continue;
                }

                que.add(nZ);
                que.add(nX);
                que.add(nY);
                que.add(curCnt + 1);
                isVisited[nZ][nX][nY] = true;
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            int startL = 0;
            int startR = 0;
            int startC = 0;
            building = new char[L][R][C];
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String input = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = input.charAt(k);
                        if (building[i][j][k] == 'S') {
                            startL = i;
                            startR = j;
                            startC = k;
                        }
                    }
                }
                br.readLine();
            }

            res = -1;
            bfs(startL, startR, startC, 0);

            if (res == -1) {
                sb.append("Trapped!");
            } else {
                sb.append("Escaped in ").append(res).append(" minute(s).");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
