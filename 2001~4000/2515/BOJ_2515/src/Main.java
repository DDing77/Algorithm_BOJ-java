import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int S;
    int[][] paintings;
    int[] dp;

    private int findIdx(int target) {
        target = Math.max(target - S, 0);

        int left = 0;
        int right = N;
        while (left + 1 < right) {
            int mid = (left + right) >> 1;
            if (paintings[mid][0] > target) {
                right = mid;
            } else {
                left = mid;
            }
        }

        return left;
    }

    private void solution() throws IOException {

        N = read();
        S = read();

        paintings = new int[N + 1][2];
        for (int i = 1; i <= N; i++) {
            paintings[i][0] = read();
            paintings[i][1] = read();
        }

        Arrays.sort(paintings, Comparator.comparingInt(o -> o[0]));

        dp = new int[N + 1];
        dp[1] = paintings[1][1];
        for (int i = 2; i <= N; i++) {
            int minIdx = findIdx(paintings[i][0]);
            dp[i] = Math.max(dp[minIdx] + paintings[i][1], dp[i - 1]);
        }
        System.out.println(dp[N]);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }

    public static int read() throws IOException {

        int c;
        int n = System.in.read() & 15;

        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }

        return n;
    }
}
