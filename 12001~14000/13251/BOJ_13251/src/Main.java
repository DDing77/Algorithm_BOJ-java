import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int M;
    private int[] stones;
    private int K;
    private int total;
    private double res;

    private void solution() throws IOException {

        M = Integer.parseInt(br.readLine());
        stones = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            stones[i] = Integer.parseInt(st.nextToken());
            total += stones[i];
        }

        K = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            if (stones[i] < K) {
                continue;
            }

            double temp = 1.0;
            for (int j = 0; j < K; j++) {
                temp *= (double) (stones[i] - j) / (total - j);
            }
            res += temp;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
