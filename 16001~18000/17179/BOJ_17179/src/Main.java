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
    private int L;
    private int Q;
    private int[] S;
    private int resMin;

    private boolean check(int mid) {
        int min = L;
        int cnt = 0;
        int sum = S[0];

        if (sum >= mid) {
            cnt++;
            min = Math.min(min, sum);
            sum = 0;
        }

        for (int i = 1; i < M; i++) {
            sum += (S[i] - S[i - 1]);
            if (sum >= mid) {
                cnt++;
                min = Math.min(min, sum);
                sum = 0;
            }
        }

        sum += L - S[M - 1];
        if (sum >= mid) {
            cnt++;
            min = Math.min(min, sum);
        }
        if (cnt > Q) {
            resMin = min;
            return true;
        }
        return false;
    }

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        S = new int[M];
        for (int i = 0; i < M; i++) {
            S[i] = Integer.parseInt(br.readLine());
        }

        while (N-- > 0) {
            Q = Integer.parseInt(br.readLine());

            int left = 1;
            int right = L + 1;

            while (left + 1 < right) {
                int mid = (left + right) >> 1;
                if (check(mid)) {
                    left = mid;
                } else {
                    right = mid;
                }
            }
            sb.append(left).append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
