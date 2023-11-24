import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    int N;
    int K;
    int[] dp;
    int[] numbers;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        K = Integer.parseInt(br.readLine());
        dp = new int[K * numbers[N - 1] + 2];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < N; j++) {
                if (numbers[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - numbers[j]] + 1);
                }
            }

            if (dp[i] > K) {
                if (i % 2 == 0) {
                    System.out.println("holsoon win at " + i);
                } else {
                    System.out.println("jjaksoon win at " + i);
                }
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
