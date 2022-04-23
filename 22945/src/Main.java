import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static int[] arr;
    static int res;

    public static int solve() {
        int L = 0;
        int R = arr.length - 1;
        res = Integer.MIN_VALUE;
        while (L < R) {
            if (arr[L] < arr[R]) {
                res = Math.max(res, arr[L] * (R - L - 1));
                L++;
            } else {
                res = Math.max(res, arr[R] * (R - L - 1));
                R--;
            }
        }
        return res;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        solve();

        System.out.println(res);
    }
}
