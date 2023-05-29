import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static class Info {
        char type;
        int cnt;

        public Info(char type, int cnt) {
            this.type = type;
            this.cnt = cnt;
        }
    }


    private int N, M;
    private char[][] map;
    private boolean[][] isVisited;
    private int res;

    public void execBFS(char type, int x, int y) {
        isVisited[x][y] = true;

        if (type == '|') {
            int nX = x + 1;

            while (!(nX < 0 || nX >= N) && !isVisited[nX][y] && type == map[nX][y]) {
                isVisited[nX][y] = true;
                nX++;
            }

            return;
        } else {
            int nY = y + 1;

            while (!(nY < 0 || nY >= M) && !isVisited[x][nY] && type == map[x][nY]) {
                isVisited[x][nY] = true;
                nY++;
            }

            return;
        }

    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        isVisited = new boolean[N][M];
        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            map[i] = br.readLine().toCharArray();
        }

        res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (!isVisited[i][j]) {
                    res++;
                    execBFS(map[i][j], i, j);
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
