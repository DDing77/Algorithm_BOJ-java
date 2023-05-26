import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static int N;
    static BigInteger sum;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int tc = 1; tc <= 3; tc++) {
            N = Integer.parseInt(br.readLine());
            sum = new BigInteger("0");

            while (N-- > 0) {
                sum = sum.add(new BigInteger(br.readLine()));
            }

            if (sum.compareTo(BigInteger.ZERO) == 0) {
                sb.append("0");
            } else if (sum.compareTo(BigInteger.ZERO) == 1) {
                sb.append("+");
            } else if (sum.compareTo(BigInteger.ZERO) == -1) {
                sb.append("-");
            }

            sb.append('\n');
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
