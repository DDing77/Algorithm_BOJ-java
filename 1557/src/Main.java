import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int k;
    static int MAX = 42000;
    static long[] arr;

    static long SFI(long k) {
        long cnt = 0;
        for (int i = 1; i * i <= k; i++) {
            cnt += arr[i] * k / (i * i);
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        arr = new long[MAX + 1];
        arr[1] = 1;
        for (int i = 1; i <= MAX; i++) {
            for (int j = 2 * i; j <= MAX; j += i) arr[j] -= arr[i];
        }

        long first = 0;
        long last = k * 2;
        while (first < last - 1) {
            long mid = (first + last) / 2;
            if (SFI(mid) < k) first = mid;
            else last = mid;
        }
        System.out.println(last);
    }
}
