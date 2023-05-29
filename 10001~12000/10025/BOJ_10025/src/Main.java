import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private final int MAX_LENGTH = 1_000_000;
    private int N;
    private int K;
    private int g;
    private int x;
    private int[] buckets;
    private int max;

    public void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = read();
        K = read();

        buckets = new int[MAX_LENGTH + 1];

        int end = -1;
        int tempSum = 0;
        while (N-- > 0) {
            g = read();
            x = read();

            buckets[x] = g;
            tempSum += g;
            end = Math.max(end, x);
        }

        if (K >= 500_000) {
            System.out.println(tempSum);
            return;
        }

        int sum = 0;
        for (int i = 0; i <= K * 2; i++) {
            sum += buckets[i];
        }

        max = sum;
        int windowSize = K * 2 + 1;
        int right = K * 2;
        while (right < end) {
            right++;
            sum += buckets[right];
            sum -= buckets[right - windowSize];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }

    public static void main(String[] args) throws Exception {
        new Main().solution();
    }

    public int read() throws Exception {
        int c;
        int n = System.in.read() & 15;
        while ((c = System.in.read()) > 32) {
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }
}
