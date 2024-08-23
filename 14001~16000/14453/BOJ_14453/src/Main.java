import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int[][] preSum;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        preSum = new int[N + 1][3];

        for (int i = 1; i <= N; i++) {
            char ch = br.readLine().charAt(0);

            preSum[i][0] = preSum[i - 1][0];
            preSum[i][1] = preSum[i - 1][1];
            preSum[i][2] = preSum[i - 1][2];

            if (ch == 'H') {
                preSum[i][2] = preSum[i - 1][2] + 1;
            } else if (ch == 'S') {
                preSum[i][0] = preSum[i - 1][0] + 1;
            } else if (ch == 'P') {
                preSum[i][1] = preSum[i - 1][1] + 1;
            }
        }

        res = Math.max(preSum[N][0], Math.max(preSum[N][1], preSum[N][2]));
        for (int i = 1; i < N; i++) {
            res = Math.max(res, preSum[i][0] + preSum[N][1] - preSum[i][1]);
            res = Math.max(res, preSum[i][0] + preSum[N][2] - preSum[i][2]);
            res = Math.max(res, preSum[i][1] + preSum[N][0] - preSum[i][0]);
            res = Math.max(res, preSum[i][1] + preSum[N][2] - preSum[i][2]);
            res = Math.max(res, preSum[i][2] + preSum[N][0] - preSum[i][0]);
            res = Math.max(res, preSum[i][2] + preSum[N][1] - preSum[i][1]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}

