import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int M;
    int[] prices;
    int resRevenue;
    int resPrice;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        prices = new int[M];
        for (int i = 0; i < M; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(prices);

        resRevenue = 0;
        for (int i = 0; i < M; i++) {
            int count = Math.min(M - i, N);
            if (resRevenue < count * prices[i]) {
                resPrice = prices[i];
                resRevenue = count * prices[i];
            }
        }

        sb.append(resPrice).append(" ").append(resRevenue);
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
