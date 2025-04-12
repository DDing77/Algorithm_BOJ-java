import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private int W;
    private int H;
    private char[][] board;
    private int[][][] distances;

    private int startX;
    private int startY;
    private int endX;
    private int endY;

    private void dijkstra() {
        distances = new int[H][W][4];
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                Arrays.fill(distances[i][j], 10_000);
            }
        }

        distances[startX][startY][0] = 0;
        distances[startX][startY][1] = 0;
        distances[startX][startY][2] = 0;
        distances[startX][startY][3] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{startX, startY, 0, 0});
        pq.add(new int[]{startX, startY, 0, 1});
        pq.add(new int[]{startX, startY, 0, 2});
        pq.add(new int[]{startX, startY, 0, 3});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();

            if (cur[0] == endX && cur[1] == endY) {
                continue;
            }

            for (int i = 0; i < dirs.length; i++) {
                if ((i + 2) % 4 == cur[3]) {
                    continue;
                }
                int newX = cur[0] + dirs[i][0];
                int newY = cur[1] + dirs[i][1];

                if (newX < 0 || newX >= H || newY < 0 || newY >= W) {
                    continue;
                }

                if (board[newX][newY] == '*') {
                    continue;
                }

                int nextCnt = (cur[3] != i ? cur[2] + 1 : cur[2]);

                if (distances[newX][newY][i] > nextCnt) {
                    distances[newX][newY][i] = nextCnt;
                    pq.add(new int[]{newX, newY, nextCnt, i});
                }
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        board = new char[H][W];
        boolean isFindStart = false;
        for (int i = 0; i < H; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                board[i][j] = input[j];
                if (board[i][j] == 'C') {
                    if (!isFindStart) {
                        startX = i;
                        startY = j;
                        isFindStart = true;
                    } else {
                        endX = i;
                        endY = j;
                    }
                }
            }
        }

        dijkstra();

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            res = Math.min(res, distances[endX][endY][i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Info {
        int to;
        int dist;
    }
}
