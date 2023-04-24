import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private int N;
    private int[][] map;
    private boolean[][] isVisited;

    public boolean execBFS() {
        isVisited = new boolean[N][N];
        Queue<Integer> que = new LinkedList<>();
        que.add(0);
        que.add(0);
        isVisited[0][0] = true;

        while (!que.isEmpty()) {
            int curX = que.poll();
            int curY = que.poll();

            for (int k = 0; k < 2; k++) {
                int nX = curX;
                int nY = curY;

                if (k == 0) {
                    nY += map[curX][curY];
                }

                if (k == 1) {
                    nX += map[curX][curY];
                }

                if (nX == N - 1 && nY == N - 1) {
                    return true;
                }

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }

                if (isVisited[nX][nY]) {
                    continue;
                }

                que.add(nX);
                que.add(nY);
                isVisited[nX][nY] = true;
            }
        }
        return false;
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        if (!execBFS()) {
            System.out.println("Hing");
        } else {
            System.out.println("HaruHaru");
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
