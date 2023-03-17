import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private int T, N, M, k, D;
    private long res;


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            D = Integer.parseInt(st.nextToken());

            res = 2 * D / ((k * N * M * (M - 1) + M * M * N * (N - 1)));
            if (res > 0) {
                sb.append(M * (M - 1) * N * k * res / 2 + M * M * N * (N - 1) * res / 2);
            } else {
                sb.append("-1");
            }
            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
