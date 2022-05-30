import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    static String N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N = br.readLine();

        BigInteger big = new BigInteger("0");
        for (int i = 0; i < N.length(); i++) {
            if (N.charAt(i) == '1') big = big.add(new BigInteger("2").pow(N.length() - (i + 1)));
            else if (N.charAt(i) == '0') big = big.add(new BigInteger("0"));
            else if (N == "0") sb.append("0");
        }

        BigInteger res = big.multiply(new BigInteger("17"));
        String last = "";
        while (res != BigInteger.valueOf(0)) {
            last += res.mod(BigInteger.valueOf(2));
            res = res.divide(BigInteger.valueOf(2));
        }

        for (int i = last.length() - 1; i >= 0; i--) sb.append(String.valueOf(last.charAt(i)));
        System.out.println(sb);
    }
}
