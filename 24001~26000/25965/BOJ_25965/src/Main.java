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
    private int[][] values;
    private int K;
    private int D;
    private int A;
    private long res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            values = new int[M][3];
            for (int j = 0; j < M; j++) {
                st = new StringTokenizer(br.readLine());
                values[j][0] = Integer.parseInt(st.nextToken());
                values[j][1] = Integer.parseInt(st.nextToken());
                values[j][2] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());

            res = 0L;
            for (int j = 0; j < M; j++) {
                long sum = (long) values[j][0] * K - (long) values[j][1] * D + (long) values[j][2] * A;
                res += Math.max(0, sum);
            }

            sb.append(res).append("\n");
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
