import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private int M;
    private int H;
    private ArrayList<Integer>[] blocks;
    private int[] dp;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        blocks = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            blocks[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens()) {
                blocks[i].add(Integer.parseInt(st.nextToken()));
            }
        }

        dp = new int[H + 1];
        dp[0] = 1;

        for (int i = 1; i <= N; i++) {
            int length = blocks[i].size();
            for (int j = H; j >= 1; j--) {
                for (int k = 0; k < length; k++) {
                    int block = blocks[i].get(k);
                    if (j - block >= 0) {
                        dp[j] += dp[j - block];
                    }
                }
                dp[j] %= 10_007;
            }
        }

        System.out.println(dp[H]);


    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
