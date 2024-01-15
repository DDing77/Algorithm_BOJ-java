import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    int N;

    private BigInteger factorial(int left, int right) {
        BigInteger res = new BigInteger(String.valueOf(left));

        if (left < right) {
            int mid = (left + right) >> 1;
            res = factorial(left, mid).multiply(factorial(mid + 1, right));
        }
        return res;
    }

    private void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        BigInteger res = factorial(1, N);

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
