import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int WHITE = 0;
    private static final int RED = 1;
    private static final int BLUE = 2;
    private static final int[][] dirs = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    private int N;
    private int K;
    private int[][] board;
    private List<Chessmen>[][] lists;
    private List<Chessmen> chessmens;
    private int resCnt = 0;

    private boolean isValid(int x, int y) {
        return ((0 <= x && x < N && 0 <= y && y < N) && board[x][y] != BLUE);
    }

    private boolean is4EqMore(int x, int y) {
        return lists[x][y].size() >= 4;
    }

    private void move(int targetX, int targetY, Deque<Chessmen> deque, List<Chessmen> target) {
        // 이동하는 칸이 하얀색인 경우
        if (board[targetX][targetY] == WHITE) {
            while (!deque.isEmpty()) {
                Chessmen chessmen = deque.removeFirst();
                chessmen.x = targetX;
                chessmen.y = targetY;
                chessmen.height = target.size();
                target.add(chessmen);
            }
        } else if (board[targetX][targetY] == RED) { // 이동하는 칸이 빨간색인 경우
            while (!deque.isEmpty()) {
                Chessmen chessmen = deque.removeLast();
                chessmen.x = targetX;
                chessmen.y = targetY;
                chessmen.height = target.size();
                target.add(chessmen);
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        lists = new List[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                lists[i][j] = new ArrayList<>();
            }
        }

        chessmens = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int dirIdx = Integer.parseInt(st.nextToken()) - 1;
            Chessmen chessmen = new Chessmen(i, x, y, dirIdx, 0);
            chessmens.add(chessmen);
            lists[x][y].add(chessmen);
        }

        resCnt = 1;
        loop:
        while (resCnt <= 1000) {
            for (Chessmen chessmen : chessmens) {
                // 나포함해서 위에 있는 것을 임시로 빼놓기
                Deque<Chessmen> deque = new ArrayDeque<>();
                List<Chessmen> cur = lists[chessmen.x][chessmen.y];
                for (int i = cur.size() - 1; i >= chessmen.height; i--) {
                    Chessmen lastChessmen = cur.remove(cur.size() - 1);
                    deque.addFirst(lastChessmen);
                }

                // 다음에 갈 곳 색깔을 알아낸다.
                // 1. 범위 안이고 && 파란색이 아닌지?
                int nX = chessmen.x + dirs[chessmen.dirIdx][0];
                int nY = chessmen.y + dirs[chessmen.dirIdx][1];

                if (!isValid(nX, nY)) {
                    // 아니라면 먼저 방향 반대로 바꾼다
                    chessmen.reversDirIdx();
                    nX = chessmen.x + dirs[chessmen.dirIdx][0];
                    nY = chessmen.y + dirs[chessmen.dirIdx][1];
                    // 갈 수 있다면 간다.
                    if (isValid(nX, nY)) {
                        List<Chessmen> target = lists[nX][nY];
                        move(nX, nY, deque, target);
                        if (is4(nX, nY)) {
                            break loop;
                        }
                    }
                    // 바꾼후 이동하려는 칸도 못가면 그대로 둔다.
                    // 임시로 빼놓았던 것을 다시 넣어둔다.
                    while (!deque.isEmpty()) {
                        cur.add(deque.removeFirst());
                    }
                } else {
                    // 하얀색 or 빨간색
                    List<Chessmen> target = lists[nX][nY];
                    move(nX, nY, deque, target);
                    if (is4(nX, nY)) {
                        break loop;
                    }
                }
            }

            resCnt++;
        }

        if (resCnt > 1000) {
            System.out.println(-1);
        } else {
            System.out.println(resCnt);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Chessmen {

        int id;
        int x;
        int y;
        int dirIdx;
        int height;

        public Chessmen(int id, int x, int y, int dirIdx, int height) {
            this.id = id;
            this.x = x;
            this.y = y;
            this.dirIdx = dirIdx;
            this.height = height;
        }

        @Override
        public String toString() {
            return "Chessmen{" +
                    "id=" + id +
                    ", x=" + x +
                    ", y=" + y +
                    ", dirIdx=" + dirIdx +
                    ", height=" + height +
                    '}';
        }

        public void reversDirIdx() {
            if (dirIdx == 0) {
                dirIdx = 1;
            } else if (dirIdx == 1) {
                dirIdx = 0;
            } else if (dirIdx == 2) {
                dirIdx = 3;
            } else {
                dirIdx = 2;
            }
        }
    }
}
