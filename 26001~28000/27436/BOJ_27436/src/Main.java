import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    long N;
    long res;

    private boolean check(long mid) {
        long temp = 1 + 3 * mid * (mid - 1);

        if (temp >= N) {
            return true;
        } else {
            return false;
        }
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Long.parseLong(br.readLine());

        long left = 1L;
        long right = 2_222_222_222L;

        res = 0;
        while (left <= right) {
            long mid = (left + right) >> 1;
            if (check(mid)) {
                res = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
