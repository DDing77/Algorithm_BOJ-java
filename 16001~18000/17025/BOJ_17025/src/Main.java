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

    private static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private char[][] board;
    private boolean[][] isVisited;
    private int resBlob;
    private int resPerimeter;

    private void execBFS(int x, int y) {

        Queue<int[]> que = new ArrayDeque<>();
        que.add(new int[]{x, y});
        isVisited[x][y] = true;

        int blobSize = 1;
        int perimeterSize = 0;

        while (!que.isEmpty()) {
            int[] cur = que.poll();

            for (int[] nextDir : dir) {
                int newX = cur[0] + nextDir[0];
                int newY = cur[1] + nextDir[1];

                if (newX < 0 || newX >= N || newY < 0 || newY >= N) {
                    perimeterSize++;
                    continue;
                }
                if (board[newX][newY] == '.') {
                    perimeterSize++;
                    continue;
                }
                if (isVisited[newX][newY]) {
                    continue;
                }

                que.add(new int[]{newX, newY});
                blobSize++;
                isVisited[newX][newY] = true;
            }
        }

        if (resBlob < blobSize) {
            resBlob = blobSize;
            resPerimeter = perimeterSize;
        } else if (resBlob == blobSize) {
            resPerimeter = Math.min(resPerimeter, perimeterSize);
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        resBlob = 0;
        resPerimeter = Integer.MAX_VALUE;

        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == '#' && !isVisited[i][j]) {
                    execBFS(i, j);
                }
            }
        }

        sb.append(resBlob).append(" ").append(resPerimeter);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
