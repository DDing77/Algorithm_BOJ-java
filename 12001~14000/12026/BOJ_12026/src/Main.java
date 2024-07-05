import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private char[] blocks;
    private int[] dp;

    private void search(int curIdx, char next) {

        for (int i = curIdx + 1; i < blocks.length; i++) {
            if (next == blocks[i]) {
                dp[i] = Math.min(dp[i], dp[curIdx] + (i - curIdx) * (i - curIdx));
            }
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        blocks = br.readLine().toCharArray();

        dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 0; i < blocks.length; i++) {
            if (dp[i] == Integer.MAX_VALUE) {
                continue;
            }
            char cur = blocks[i];
            if (cur == 'B') {
                search(i, 'O');
            } else if (cur == 'O') {
                search(i, 'J');
            } else if (cur == 'J') {
                search(i, 'B');
            }
        }

        if (dp[N - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
