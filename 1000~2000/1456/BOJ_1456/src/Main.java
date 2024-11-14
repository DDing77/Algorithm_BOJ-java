import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private long A;
    private long B;
    private boolean[] primes;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        primes = new boolean[(int)Math.sqrt(B) + 1];
        int length = primes.length;
        for (int i = 2; i <= Math.sqrt(length); i++) {
            if (!primes[i]) {
                for (int j = i + i; j < length; j += i) {
                    primes[j] = true;
                }
            }
        }

        for (int i = 2; i < length; i++) {
            if (!primes[i]) {
                long cur = i;
                while (cur <= (double) B / i) {
                    if ((double) A / i <= cur) {
                        res++;
                    }
                    cur *= i;
                }
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
