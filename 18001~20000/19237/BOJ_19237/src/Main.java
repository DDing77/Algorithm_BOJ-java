import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private int N;
    private int M;
    private int K;
    private int[][][] board;
    private List<Shark> sharks = new ArrayList<Shark>();
    private boolean[][] isVisited;
    private int resCnt = 1;

    private void printBoard() {
        System.out.println("상어 번호");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j][0] + " ");
            }
            System.out.println();
        }
        System.out.println("==========================");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j][1] + " ");
            }
            System.out.println();
        }
    }

    private void moveSharks() {
        isVisited = new boolean[N][N];
        Queue<Shark> moveListShark = new ArrayDeque<>();
        for (Shark shark : sharks) {
            if (!shark.alive) {
                continue;
            }

            int curDirIdx = shark.curDirIdx;
            isVisited[shark.x][shark.y] = true;
            board[shark.x][shark.y][1]--;
            int nX = -1;
            int nY = -1;

            // 아무 냄새없는 곳 먼저 찾기
            boolean isFindNoneSmell = false;
            for (int nextDirIdx : shark.dirPriority[curDirIdx]) {
                nX = shark.x + dirs[nextDirIdx][0];
                nY = shark.y + dirs[nextDirIdx][1];
//                System.out.println("nextDirIdx = " + nextDirIdx + " sharkX = " + shark.x + " sharkY = " + shark.y + " , nX = " + nX + ", nY = " + nY);

                if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                    continue;
                }

                if (board[nX][nY][0] == 0 && board[nX][nY][1] == 0) {
                    isFindNoneSmell = true;
                    shark.curDirIdx = nextDirIdx; // 상어가 다음에 바라보는 방향을 미리 바꿔줌
//                    System.out.println("curDirIdx = " + curDirIdx + " nextDirIdx = " + nextDirIdx);
                    break;
                }
            }


            // 냄새가 없는 곳을 찾았다면 그곳으로 이동
            if (isFindNoneSmell) {
                shark.x = nX;
                shark.y = nY;
                moveListShark.add(shark);
            } else { // 모든 곳에 냄새가 있다면 본인 냄새가 나는 곳으로 이동(이전에 왔던 곳으로 이동)
                for (int nextDirIdx : shark.dirPriority[curDirIdx]) {
                    nX = shark.x + dirs[nextDirIdx][0];
                    nY = shark.y + dirs[nextDirIdx][1];

                    if (nX < 0 || nX >= N || nY < 0 || nY >= N) {
                        continue;
                    }
                    if (board[nX][nY][0] == shark.id) {
                        board[nX][nY][1] = K;
                        shark.x = nX;
                        shark.y = nY;
                        shark.curDirIdx = nextDirIdx;
                        break;
                    }
                }
            }
        }
        for (Shark moveToEmptyPosShark : moveListShark) {
            int x = moveToEmptyPosShark.x;
            int y = moveToEmptyPosShark.y;
            int id = moveToEmptyPosShark.id;
            if (board[x][y][0] != 0) {
                moveToEmptyPosShark.death();
                M--;
            } else {
                board[x][y][0] = id;
                board[x][y][1] = K;
                isVisited[x][y] = true;
            }
        }
    }

    private void reduceSmell() {
        for (Shark shark : sharks) {
            if (!shark.alive) {
                continue;
            }
            int x = shark.x;
            int y = shark.y;
            isVisited[x][y] = true;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!isVisited[i][j] && board[i][j][0] != 0 && board[i][j][1] > 0) {
                    board[i][j][1]--;
                    if (board[i][j][1] == 0) {
                        board[i][j][0] = 0;
                    }
                }
            }
        }
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            sharks.add(new Shark());
        }

        board = new int[N][N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j][0] = Integer.parseInt(st.nextToken());
                if (board[i][j][0] != 0) {
                    board[i][j][1] = K;
                    Shark shark = sharks.get(board[i][j][0] - 1);
                    shark.id = board[i][j][0];
                    shark.x = i;
                    shark.y = j;
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (Shark shark : sharks) {
            shark.curDirIdx = Integer.parseInt(st.nextToken()) - 1;
        }

        for (Shark shark : sharks) {
            for (int i = 0; i < dirs.length; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < shark.dirPriority[i].length; j++) {
                    shark.dirPriority[i][j] = Integer.parseInt(st.nextToken()) - 1;
                }
            }
        }

        while (resCnt <= 1000) {
            // 모든 상어 이동
            moveSharks();
            // 상어 개수가 1개면 종료
            if (M == 1) {
                break;
            }

            // 이전 칸 냄새 감소
            reduceSmell();

//            printBoard();
            // 다음 턴 진행
            resCnt++;
        }

        if (resCnt <= 1000 && M == 1) {
            System.out.println(resCnt);
        } else {
            System.out.println(-1);
        }
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }

    static class Shark {

        int id;
        int x;
        int y;
        int curDirIdx;
        int[][] dirPriority = new int[4][4];
        boolean alive = true;

        public Shark() {
        }

        public Shark(int id, int x, int y) {
            this.id = id;
            this.x = x;
            this.y = y;
        }

        public void death() {
            this.alive = false;
        }
    }
}
