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

    private int N;
    private Queue<Integer> batterQue = new ArrayDeque<>();
    private int[][] board;
    private boolean[] isVisited;
    private int[] order;
    private int res;

    private int getScore() {
        int score = 0;
        int playerIndex = 0;

        for (int inning = 0; inning < N; inning++) {
            int outCount = 0;
            boolean[] base = new boolean[4]; // 1루, 2루, 3루

            while (outCount < 3) {
                int player = order[playerIndex];
                int result = board[inning][player];

                switch (result) {
                    case 0: // 아웃
                        outCount++;
                        break;
                    case 1: // 안타
                        if (base[3]) score++;
                        base[3] = base[2];
                        base[2] = base[1];
                        base[1] = true;
                        break;
                    case 2: // 2루타
                        if (base[3]) score++;
                        if (base[2]) score++;
                        base[3] = base[1];
                        base[2] = true;
                        base[1] = false;
                        break;
                    case 3: // 3루타
                        for (int i = 1; i <= 3; i++) {
                            if (base[i]) {
                                score++;
                                base[i] = false;
                            }
                        }
                        base[3] = true;
                        break;
                    case 4: // 홈런
                        for (int i = 1; i <= 3; i++) {
                            if (base[i]) {
                                score++;
                                base[i] = false;
                            }
                        }
                        score++;
                        break;
                }
                playerIndex = (playerIndex + 1) % 9;
            }
        }
        return score;
    }

    private void backTracking(int depth) {
        if (depth == 9) {
            res = Math.max(res, getScore());
            return;
        }

        if (depth == 3) {
            backTracking(depth + 1);
            return;
        }

        for (int i = 1; i < 9; i++) {
            if (!isVisited[i]) {
                isVisited[i] = true;
                order[depth] = i;
                backTracking(depth + 1);
                isVisited[i] = false;
            }
        }
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isVisited = new boolean[9];
        isVisited[0] = true;
        order = new int[9];
        order[0] = 3;
        backTracking(0);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
