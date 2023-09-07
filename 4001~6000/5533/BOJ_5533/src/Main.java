import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final int ROUND = 3;
    int N;
    int[][] board;
    int[] score;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[N][ROUND];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < ROUND; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        score = new int[N];
        for (int i = 0; i < ROUND; i++) {
            for (int j = 0; j < N; j++) {
                boolean isSame = false;
                for (int k = 0; k < N; k++) {
                    if (j == k) {
                        continue;
                    }

                    if (board[j][i] == board[k][i]) {
                        isSame = true;
                        break;
                    }
                }

                if (!isSame) {
                    score[j] += board[j][i];
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(score[i]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
