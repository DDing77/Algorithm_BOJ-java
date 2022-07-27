import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;
    static long[][] dp;
    static long res;

    static int moveLeft(int idx) {
        return (idx + N - 1) % N;
    }

    static int moveRight(int idx) {
        return (idx + 1) % N;
    }

    static long ioi(int left, int right) {
        if (moveRight(right) == left) {
            return 0;
        }

        if (arr[moveLeft(left)] > arr[moveRight(right)]) {
            return joi(moveLeft(left), right);
        }

        return joi(left, moveRight(right));
    }

    static long joi(int left, int right) {
        if (moveRight(right) == left) {
            return dp[left][right] = 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        long l = arr[moveLeft(left)] + ioi(moveLeft(left), right);
        long r = arr[moveRight(right)] + ioi(left, moveRight(right));

        return dp[left][right] = Math.max(l, r);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        dp = new long[N + 1][N + 1];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(br.readLine());
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= N; j++) dp[i][j] = -1;
        }

        res = 0;
        for (int i = 0; i < N; i++) res = Math.max(res, arr[i] + ioi(i, i));

        System.out.println(res);
    }
}