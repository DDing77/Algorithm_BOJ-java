import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    BigInteger A;
    BigInteger B;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());


        BigInteger q = A.divide(B);
        BigInteger r = A.remainder(B);

        if (A.compareTo(BigInteger.ZERO) == -1) {
            if (B.compareTo(BigInteger.ZERO) > 0) {
                q = q.subtract(BigInteger.ONE);
                r = r.add(B);
            } else if (B.compareTo(BigInteger.ZERO) == -1) {
                q = q.add(BigInteger.ONE);
                r = A.subtract(B.multiply(q));
            }
        }
        System.out.println(q + "\n" + r);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
