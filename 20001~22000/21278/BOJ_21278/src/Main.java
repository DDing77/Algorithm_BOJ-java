import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int[][] distances;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distances = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i == j) {
                    distances[i][j] = 0;
                } else {
                    distances[i][j] = 101;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            distances[A][B] = 1;
            distances[B][A] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    distances[i][j] = Math.min(distances[i][j], distances[i][k] + distances[k][j]);
                }
            }
        }

        int minRes = Integer.MAX_VALUE;
        int minA = 1;
        int minB = 2;
        for (int i = 1; i < N; i++) {
            for (int j = i + 1; j <= N; j++) {
                int sum = 0;
                for (int k = 1; k <= N; k++) {
                    sum += Math.min(distances[k][i], distances[k][j]);
                }
                if (minRes > sum * 2) {
                    minRes = sum * 2;
                    minA = i;
                    minB = j;
                }
            }
        }

        sb.append(minA).append(" ").append(minB).append(" ").append(minRes);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
