import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();
    static StringTokenizer st;

    BigInteger K;
    int L;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        K = new BigInteger(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        for (int i = 2; i < L; i++) {
            if (K.mod(BigInteger.valueOf(i)).equals(BigInteger.ZERO)) {
                sb.append("BAD ").append(i);
                System.out.println(sb);
                return;
            }
        }

        System.out.println("GOOD");
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
