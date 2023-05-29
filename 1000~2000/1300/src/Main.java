import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, K;
    static long L, R;
    static long cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        L = 1;
        R = K;

        while (L < R) {
            long mid = (L + R) >> 1;
            cnt = 0;
            for (int i = 1; i <= N; i++) cnt += Math.min(mid / i, N);

            if (K <= cnt) R = mid;
            else L = mid + 1;
        }

        System.out.println(L);
    }
}
