import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    static BigInteger num;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            num = new BigInteger(br.readLine());

            if (num.compareTo(BigInteger.ZERO) == 0) {
                break;
            }

            while (true) {
                BigInteger temp = new BigInteger("0");

                while (num.compareTo(BigInteger.ONE) >= 0) {
                    temp = temp.add(num.mod(BigInteger.TEN));
                    num = num.divide(BigInteger.TEN);
                }

                if (temp.compareTo(BigInteger.TEN) == -1) {
                    sb.append(temp).append('\n');
                    break;
                }
                num = new BigInteger(String.valueOf(temp));
            }
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}