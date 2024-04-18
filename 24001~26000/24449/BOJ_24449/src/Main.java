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

    public static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    int N;
    int M;
    char[][] board;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int answer = -1;
        Queue<int[]> que = new ArrayDeque<>();
        boolean[][] isVisited = new boolean[N][M];
        que.add(new int[]{0, 0, 0});
        isVisited[0][0] = true;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            if (cur[0] == N - 1 && cur[1] == M - 1) {
                answer = cur[2];
                break;
            }

            for (int i = 0; i < dir.length; i++) {
                int nX = cur[0] + dir[i][0];
                int nY = cur[1] + dir[i][1];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }
                if (isVisited[nX][nY]) {
                    continue;
                }
                if (board[cur[0]][cur[1]] == board[nX][nY]) {
                    continue;
                }

                que.add(new int[]{nX, nY, cur[2] + 1});
                isVisited[nX][nY] = true;
            }
        }

        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
