import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static BigInteger A;
    static BigInteger B;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = new BigInteger(st.nextToken());
        B = new BigInteger(st.nextToken());

        if (A.compareTo(B) > 0) {
            BigInteger temp = A;
            A = B;
            B = temp;
        }

        if (A.equals(B)) {
            sb.append(0).append('\n');
        } else {
            sb.append(B.longValue() - A.longValue() - 1).append('\n');
        }

        for (long i = A.longValue() + 1L; i < B.longValue(); i++) {
            sb.append(i + " ");
        }

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        solution();
    }
}
