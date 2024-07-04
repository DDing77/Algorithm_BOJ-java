import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private boolean[] primes;

    private void findPrime() {

        primes = new boolean[10_000_000];
        for (int i = 2; i <= Math.sqrt(primes.length); i++) {
            if (!primes[i]) {
                for (int j = i + i; j < primes.length; j += i) {
                    primes[j] = true;
                }
            }
        }

        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                count++;
            }
            if (count == N) {
                System.out.println(i);
                return;
            }
        }
    }

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        findPrime();
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
