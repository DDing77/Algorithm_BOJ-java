import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int recurSum;
    int dpSum;
    int[][] matrix;

    private int recur(int i, int j) {

        if (i == 0 || j == 0) {
            recurSum++;
            return 0;
        }

        return (matrix[i][j] + Math.max(recur(i - 1, j), recur(i, j - 1)));
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        matrix = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recurSum = 0;
        recur(N, N);

        dpSum = N * N;

        sb.append(recurSum).append(" ").append(dpSum);
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
