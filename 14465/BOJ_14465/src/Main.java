import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int N;
    private int K;
    private int B;
    private int[] light;
    private int res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        light = new int[N + 1];
        for (int i = 0; i < B; i++) {
            light[Integer.parseInt(br.readLine())]++;
        }

        res = K;
        int sum = 0;
        for (int i = 1; i <= K; i++) {
            sum += light[i];
        }

        for (int i = K + 1; i <= N; i++) {
            sum -= light[i - K];
            sum += light[i];

            res = Math.min(res, sum);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
