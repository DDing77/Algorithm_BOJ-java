import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static final int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int M;
    static int[][] board;
    static boolean[][] isInfected;
    static ArrayList<Virus> virusList;
    static Virus[] selectedVirus;
    static int originVirusCnt;
    static int res;

    public static void execBFS() {
        Queue<Virus> que = new ArrayDeque<>();
        isInfected = new boolean[N][N];

        for (int i = 0; i < M; i++) {
            que.add(selectedVirus[i]);
            isInfected[selectedVirus[i].x][selectedVirus[i].y] = true;
        }

        int emptyCnt = originVirusCnt;
        while (!que.isEmpty()) {
            Virus cur = que.poll();

            for (int k = 0; k < 4; k++) {
                int nX = cur.x + dir[k][0];
                int nY = cur.y + dir[k][1];

                if (nX < 0 || nX >= N || nY < 0 | nY >= N) {
                    continue;
                }

                if (isInfected[nX][nY]) {
                    continue;
                }

                if (board[nX][nY] == 1) {
                    continue;
                }

                if (board[nX][nY] == 0) {
                    emptyCnt--;
                }

                if (emptyCnt == 0) {
                    res = Math.min(res, cur.time + 1);
                    return;
                }

                isInfected[nX][nY] = true;
                que.add(new Virus(nX, nY, cur.time + 1));
            }
        }
    }

    public static void select(int idx, int depth) {
        if (depth == M) {
            execBFS();
            return;
        }

        for (int i = idx; i < virusList.size(); i++) {
            selectedVirus[depth] = virusList.get(i);
            select(i + 1, depth + 1);
        }
    }

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        res = Integer.MAX_VALUE;

        virusList = new ArrayList<>();
        originVirusCnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 2) {
                    virusList.add(new Virus(i, j, 0));
                } else if (board[i][j] == 0) {
                    originVirusCnt++;
                }
            }
        }

        if (originVirusCnt == 0) {
            System.out.println(0);
            return;
        }

        selectedVirus = new Virus[M];
        select(0, 0);

        if (res == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(res);
        }
    }

    public static void main(String[] args) throws IOException {
        solution();
    }

    static class Virus {
        int x;
        int y;
        int time;

        public Virus(int x, int y, int time) {
            this.x = x;
            this.y = y;
            this.time = time;
        }
    }
}
