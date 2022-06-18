import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static long[] arr;
    static long k;

    static long f(long k) {
        long ans = 0;
        for (long i = 1L; i * i <= k; i++) ans += (arr[(int) i] * (k / (i * i)));
        return ans;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Long.parseLong(br.readLine());

        arr = new long[1010100];

        arr[1] = 1L;
        for (long i = 1; i <= 1000000; i++) {
            for (long j = 2 * i; j <= 1000000; j += i) arr[(int) j] -= arr[(int) i];
        }

        long l = 0;
        long r = (long) 1e12;

        while (l < r - 1) {
            long mid = (l + r) / 2;
            if (mid - f(mid) < k) l = mid;
            else r = mid;
        }

        System.out.println(r);


    }
}