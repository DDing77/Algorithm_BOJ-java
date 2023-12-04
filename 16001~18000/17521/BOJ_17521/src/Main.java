import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    long W;
    int[] prices;
    long coin;


    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        W = Long.parseLong(st.nextToken());

        prices = new int[N];
        for (int i = 0; i < N; i++) {
            prices[i] = Integer.parseInt(br.readLine());
        }

        coin = 0L;
        for (int i = 0; i < N - 1; i++) {
            if (coin == 0 && prices[i] < prices[i + 1]) {
                coin = W / prices[i];
                W -= coin * prices[i];
            }

            if (prices[i] > prices[i + 1]) {
                W += coin * prices[i];
                coin = 0;
            }
        }

        W += coin * prices[N - 1];

        System.out.println(W);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
