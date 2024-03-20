import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    int N;
    int[] sequence;
    int[] dp;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        if (N == 1) {
            System.out.println(Integer.parseInt(br.readLine()));
            return;
        }

        sequence = new int[N];
        for (int i = 0; i < N; i++) {
            sequence[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(sequence);

        dp = new int[N + 1];
        dp[1] = sequence[0];

        for (int i = 2; i <= N; i++) {
            dp[i] = Math.max(dp[i - 1] + sequence[i - 1], dp[i - 2] + sequence[i - 2] * sequence[i - 1]);
        }

        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
