import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private int r;
    private int c;
    private int[][] map;
    private boolean[][] isVisited;
    private int res;

    public void execDFS(int x, int y, int appleCnt, int depth) {
        if (appleCnt >= 2 || depth == 3) {
            res = Math.max(res, appleCnt);
            return;
        }

        for (int k = 0; k < 4; k++) {
            int nX = x + dir[k][0];
            int nY = y + dir[k][1];

            if (nX < 0 || nX >= 5 || nY < 0 || nY >= 5) {
                continue;
            }

            if (isVisited[nX][nY]) {
                continue;
            }

            if (map[nX][nY] == -1) {
                continue;
            }

            isVisited[nX][nY] = true;
            if (map[nX][nY] == 1) {
                execDFS(nX, nY, appleCnt + 1, depth + 1);
            } else {
                execDFS(nX, nY, appleCnt, depth + 1);
            }
            isVisited[nX][nY] = false;
        }

    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];

        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        res = 0;
        isVisited = new boolean[5][5];
        isVisited[r][c] = true;
        execDFS(r, c, 0, 0);

        if (res < 2) {
            System.out.println("0");
        } else {
            System.out.println("1");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
