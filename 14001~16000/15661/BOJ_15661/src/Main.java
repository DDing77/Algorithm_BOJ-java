import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int[][] board;
    private boolean[] isSelected;
    private int minRes;

    private void execDFS(int depth) {

        if (depth == N) {
            int startTeamSum = 0;
            int linkTeamSum = 0;
            for (int i = 0; i < N - 1; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (i == j) {
                        continue;
                    }

                    if (isSelected[i] == isSelected[j]) {
                        if (isSelected[i]) {
                            startTeamSum += board[i][j] + board[j][i];
                        } else {
                            linkTeamSum += board[i][j] + board[j][i];
                        }
                    }
                }
            }

            minRes = Math.min(minRes, Math.abs(startTeamSum - linkTeamSum));
            return;
        }

        isSelected[depth] = true;
        execDFS(depth + 1);

        isSelected[depth] = false;
        execDFS(depth + 1);
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        isSelected = new boolean[N];
        minRes = Integer.MAX_VALUE;
        execDFS(0);

        System.out.println(minRes);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
