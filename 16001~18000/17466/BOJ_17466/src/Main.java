import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    private void solution() throws IOException {
        st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long P = Long.parseLong(st.nextToken());

        if (N >= P) {
            System.out.println(0);
            return;
        }

        long product = 1;
        for (long i = N + 1; i < P; i++) {
            product = (product * i) % P;
        }

        long inverse = modPow(product, P - 2, P);
        long result = (P - inverse) % P;
        System.out.println(result);
    }

    private long modPow(long base, long exp, long mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
