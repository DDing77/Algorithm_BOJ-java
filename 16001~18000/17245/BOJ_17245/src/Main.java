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
    private double total;

    private boolean check(int mid) {
        double sum = 0.;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sum += Math.min(board[i][j], mid);
            }
        }

        return sum >= total / 2;
    }

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        total = 0.;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                total += board[i][j];
            }
        }

        int left = -1;
        int right = 10_000_000;

        while (left + 1 < right) {
            int mid = (left + right) >> 1;

            if (check(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }

        System.out.println(right);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
