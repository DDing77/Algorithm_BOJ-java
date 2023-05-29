import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int n;
    private long[] sums;
    private long res;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        sums = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                sums[i] = Integer.parseInt(st.nextToken());
                continue;
            }
            sums[i] = sums[i - 1] + Integer.parseInt(st.nextToken());
        }

        res = 0;
        for (int i = 0; i < n - 1; i++) {
            if (i == 0) {
                res = sums[i] * (sums[n - 1] - sums[i]);
                continue;
            }
            res += (sums[i] - sums[i - 1]) * (sums[n - 1] - sums[i]);
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
