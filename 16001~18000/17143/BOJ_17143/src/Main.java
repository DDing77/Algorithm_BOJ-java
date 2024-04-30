import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int R;
    private int C;
    private int M;

    private Shark[][][] board;
    private ArrayList<Shark> aliveShark;
    private int res;

    private void fishing(int col) {

        for (int i = 0; i < R; i++) {
            if (board[0][i][col] != null) {
                Shark shark = board[0][i][col];
                res += shark.size;
                board[0][i][col] = null;
                aliveShark.remove(shark);
                return;
            }
        }
    }

    private void move(Shark shark, ArrayList<Shark> nextAlive) {
        int curX = shark.x;
        int curY = shark.y;
        int dir = shark.dir;
        int remain = shark.speed;

        int nextX = curX;
        int nextY = curY;
        if (dir == 1 || dir == 2) {
            remain %= (R - 1) * 2;
        } else {
            remain %= (C - 1) * 2;
        }

        if (dir == 1 || dir == 2) {
            while (remain-- > 0) {
                if (nextX == 0 && dir == 1) {
                    dir = 2;
                } else if (nextX == R - 1 && dir == 2) {
                    dir = 1;
                }

                if (dir == 1) {
                    nextX--;
                } else {
                    nextX++;
                }
            }
        } else if (dir == 3 || dir == 4) {
            while (remain-- > 0) {
                if (nextY == 0 && dir == 4) {
                    dir = 3;
                } else if (nextY == C - 1 && dir == 3) {
                    dir = 4;
                }

                if (dir == 3) {
                    nextY++;
                } else {
                    nextY--;
                }
            }
        }

        shark.x = nextX;
        shark.y = nextY;
        shark.dir = dir;
        board[0][curX][curY] = null;

        if (board[1][nextX][nextY] != null) {
            if (board[1][nextX][nextY].size < shark.size) {
                Shark nextShark = board[1][nextX][nextY];
                nextAlive.remove(nextShark);
                board[1][nextX][nextY] = shark;
                nextAlive.add(shark);
            } else {
                nextAlive.remove(shark);
            }
        } else {
            board[1][nextX][nextY] = shark;
            nextAlive.add(shark);
        }
    }

    private void update() {

        for (Shark shark : aliveShark) {
            board[1][shark.x][shark.y] = null;
            board[0][shark.x][shark.y] = shark;
        }
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        aliveShark = new ArrayList<>();
        board = new Shark[2][R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            Shark shark = new Shark(x - 1, y - 1, Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            board[0][x - 1][y - 1] = shark;
            aliveShark.add(shark);
        }

        int anglerIdx = -1;
        while (++anglerIdx < C) {
            fishing(anglerIdx);

            ArrayList<Shark> nextAlive = new ArrayList<>();
            for (Shark shark : aliveShark) {
                move(shark, nextAlive);
            }
            aliveShark = nextAlive;

            update();
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    static class Shark {

        int x;
        int y;
        int speed;
        int dir;
        int size;

        public Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }
}
