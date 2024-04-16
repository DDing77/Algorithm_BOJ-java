import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final StringBuilder sb = new StringBuilder();
    private static StringTokenizer st;

    int N;
    int M;
    int[][] prefixSum;
    int res;

    private int getArea(int x, int y, int height, int width) {
        return prefixSum[x][y] - prefixSum[x][y - width] - prefixSum[x - height][y] + prefixSum[x - height][y - width];
    }

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prefixSum = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= M; j++) {
                prefixSum[i][j] = Integer.parseInt(st.nextToken()) + prefixSum[i][j - 1] + prefixSum[i - 1][j] - prefixSum[i - 1][j - 1];
            }
        }

        res = 0;
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i * j > 10) {
                    break;
                }
                for (int k = i; k <= N; k++) {
                    for (int l = j; l <= M; l++) {
                        if (getArea(k, l, i, j) == 10) {
                            res++;
                        }
                    }
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
