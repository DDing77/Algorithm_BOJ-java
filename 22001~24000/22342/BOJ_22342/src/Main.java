import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int M;
    private int N;
    private int[][] weights;
    private int[][] prints;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        weights = new int[M + 2][N + 2];
        for (int i = 1; i <= M; i++) {
            String input = br.readLine();
            for (int j = 1; j <= N; j++) {
                weights[i][j] = input.charAt(j - 1) - '0';
            }
        }

        prints = new int[M + 2][N + 2];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                int max = 0;
                for (int k = -1; k <= 1; k++) {
                    max = Math.max(max, prints[j + k][i - 1]);
                }
                prints[j][i] = max + weights[j][i];
                res = Math.max(res, max);
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
