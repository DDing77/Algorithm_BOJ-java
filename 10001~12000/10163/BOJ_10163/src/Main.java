import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    final int MAX_LENGTH = 1002;
    int N;
    int[][] board;
    int[] cnt;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        board = new int[MAX_LENGTH][MAX_LENGTH];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            int width = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());

            for (int j = startX; j < startX + width; j++) {
                for (int k = startY; k < startY + height; k++) {
                    board[j][k] = i;
                }
            }
        }

        cnt = new int[N + 1];
        for (int i = 0; i < MAX_LENGTH; i++) {
            for (int j = 0; j < MAX_LENGTH; j++) {
                cnt[board[i][j]]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            sb.append(cnt[i]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
