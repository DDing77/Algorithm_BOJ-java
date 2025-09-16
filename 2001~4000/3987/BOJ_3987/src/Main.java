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

    private static final String[] dirsStr = {"U", "R", "D", "L"};
    private static final int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int INF = Integer.MAX_VALUE;

    private int N;
    private int M;
    private char[][] board;
    private boolean[][][] isVisited;
    private int startX;
    private int startY;
    private int resCnt;
    private String resStr;

    private int rotate(int dirIdx, char mirrorType) {
        if (mirrorType == '\\') {
            if (dirIdx == 0) {
                return 3;
            }
            if (dirIdx == 1) {
                return 2;
            }
            if (dirIdx == 2) {
                return 1;
            }
            if (dirIdx == 3) {
                return 0;
            }
        } else if (mirrorType == '/') {
            if (dirIdx == 0) {
                return 1;
            }
            if (dirIdx == 1) {
                return 0;
            }
            if (dirIdx == 2) {
                return 3;
            }
            if (dirIdx == 3) {
                return 2;
            }
        }
        return dirIdx;
    }

    private int search(int dirIdx) {
        isVisited = new boolean[N][M][4];
        isVisited[startX][startY][dirIdx] = true;

        Queue<Node> que = new ArrayDeque<>();
        que.add(new Node(startX, startY, dirIdx, 0));

        while (true) {
            Node cur = que.poll();
            int nX = cur.x + dirs[cur.dirIdx][0];
            int nY = cur.y + dirs[cur.dirIdx][1];
            // 범위 밖
            if (0 > nX || nX >= N || 0 > nY || nY >= M) {
                return cur.cnt + 1;
            }
            // 재방문
            if (isVisited[nX][nY][cur.dirIdx]) {
                return INF;
            }
            // 블랙홀
            if (board[nX][nY] == 'C') {
                return cur.cnt + 1;
            }
            // 비어있는곳
            if (board[nX][nY] == '.') {
                isVisited[nX][nY][cur.dirIdx] = true;
                que.add(new Node(nX, nY, cur.dirIdx, cur.cnt + 1));
            } else {
                // 회전
                int nextDirIDx = rotate(cur.dirIdx, board[nX][nY]);
                isVisited[nX][nY][cur.dirIdx] = true;
                que.add(new Node(nX, nY, nextDirIDx, cur.cnt + 1));
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        st = new StringTokenizer(br.readLine());
        startX = Integer.parseInt(st.nextToken()) - 1;
        startY = Integer.parseInt(st.nextToken()) - 1;

        resCnt = 0;
        resStr = "";
        for (int i = 0; i < dirs.length; i++) {
            int cnt = search(i);
            if (cnt > resCnt) {
                resCnt = cnt;
                resStr = dirsStr[i];
            }

            if (resCnt == INF) {
                System.out.println(dirsStr[i]);
                System.out.println("Voyager");
                return;
            }
        }

        System.out.println(resStr);
        System.out.println(resCnt);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Node {
        int x;
        int y;
        int dirIdx;
        int cnt;

        public Node(int x, int y, int dirIdx, int cnt) {
            this.x = x;
            this.y = y;
            this.dirIdx = dirIdx;
            this.cnt = cnt;
        }
    }
}
