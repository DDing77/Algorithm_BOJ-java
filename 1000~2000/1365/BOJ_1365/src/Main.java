import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    int N;
    int[] lines;
    int[] dp;

    private int loweBound(int length, int value) {

        int left = 1;
        int right = length;
        int mid;

        while (left < right) {
            mid = (left + right) >> 1;
            if (dp[mid] < value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return right;
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        lines = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            lines[i] = Integer.parseInt(st.nextToken());
        }

        dp = new int[N + 1];
        int length = 0;
        for (int i = 1; i <= N; i++) {
            if (dp[length] < lines[i]) {
                dp[++length] = lines[i];
            } else {
                int lowerIdx = loweBound(length, lines[i]);
                dp[lowerIdx] = lines[i];
            }
        }

        System.out.println(N - length);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
