import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int dp[][];
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dp = new int[14 * 14][1 << M];
        for (int i = 0; i < 14 * 14; i++) Arrays.fill(dp[i], -1);
        System.out.println(proc(0, 0));
    }

    public static int proc(int index, int state) {
        if (index == N * M && state == 0) {
            return 1;
        }
        if (index >= N * M) {
            return 0;
        }
        if (dp[index][state] >= 0) return dp[index][state];
        dp[index][state] = 0;
        if ((state & 1) == 0) {
            dp[index][state] = proc(index + 1, (state >> 1) | (1 << (M - 1)));
            if (index % M != M - 1 && (state & 2) == 0)
                dp[index][state] += proc(index + 2, state >> 2);
        } else
            dp[index][state] = proc(index + 1, state >> 1);
        dp[index][state] %= 9901;

        return dp[index][state];

    }
}