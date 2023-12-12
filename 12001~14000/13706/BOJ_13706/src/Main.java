import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    BigInteger N;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = new BigInteger(br.readLine());
        BigInteger left = BigInteger.ONE;
        BigInteger right = N;
        BigInteger mid;

        while (true) {
            mid = left.add(right).divide(new BigInteger("2"));

            int compareValue = mid.multiply(mid).compareTo(N);
            if (compareValue < 0) {
                left = mid.add(BigInteger.ONE);
            } else if (compareValue == 0) {
                break;
            } else {
                right = mid.subtract(BigInteger.ONE);
            }
        }

        System.out.println(mid);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
