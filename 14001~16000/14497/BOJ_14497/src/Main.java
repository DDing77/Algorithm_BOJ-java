import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static final int INF = 100000;

    private int N;
    private int M;
    private int[] startPos;
    private int[] endPos;
    private char[][] board;
    private int[][] distance;
    private int res;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        startPos = new int[2];
        endPos = new int[2];
        startPos[0] = Integer.parseInt(st.nextToken()) - 1;
        startPos[1] = Integer.parseInt(st.nextToken()) - 1;
        endPos[0] = Integer.parseInt(st.nextToken()) - 1;
        endPos[1] = Integer.parseInt(st.nextToken()) - 1;

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            Arrays.fill(distance[i], INF);
        }
        distance[startPos[0]][startPos[1]] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[2]));
        pq.add(new int[]{startPos[0], startPos[1], 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[2] > distance[cur[0]][cur[1]]) {
                continue;
            }

            for (int[] dir : dirs) {
                int nX = cur[0] + dir[0];
                int nY = cur[1] + dir[1];
                int nDistance = cur[2];

                if (nX < 0 || nX >= N || nY < 0 || nY >= M) {
                    continue;
                }

                if (board[nX][nY] == '1' || board[nX][nY] == '#') {
                    nDistance++;
                }

                if (nDistance < distance[nX][nY]) {
                    distance[nX][nY] = nDistance;
                    pq.add(new int[]{nX, nY, nDistance});
                }
            }
        }

        System.out.println(distance[endPos[0]][endPos[1]]);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
