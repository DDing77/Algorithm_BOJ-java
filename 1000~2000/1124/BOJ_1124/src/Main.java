import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int A;
    private int B;
    private boolean[] primes;
    private int[] count;
    private int res;

    private void solution() throws IOException {

        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        count = new int[B + 1];
        primes = new boolean[B + 1];
        primes[0] = true;
        primes[1] = true;
        for (int i = 2; i <= B; i++) {
            if (!primes[i]) {
                for (int j = i + i; j <= B; j += i) {
                    primes[j] = true;
                    int cur = j;
                    while (cur % i == 0) {
                        count[j]++;
                        cur /= i;
                    }
                }
            }
        }

        for (int i = A; i <= B; i++) {
            if (!primes[count[i]]) {
                res++;
            }
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
