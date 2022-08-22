import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());

        int diff = Integer.parseInt(String.valueOf(B.subtract(A)));
        for (int i = 0; i <= diff; i++) {
            BigInteger temp = A.add(BigInteger.valueOf(i));
            if (temp.isProbablePrime(10) || temp.equals(BigInteger.valueOf(9)))
                sb.append(String.valueOf(temp)).append(" ");
        }
        System.out.println(sb);
    }
}
