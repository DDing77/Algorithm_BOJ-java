import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    final int SIZE = 1_000_000;
    int T;
    int N;
    boolean[] primes;
    int res;

    public void makePrimeTable() {
        primes = new boolean[SIZE];
        primes[0] = true;
        primes[1] = true;

        for (int i = 2; i < Math.sqrt(SIZE); i++) {
            if (!primes[i]) {
                for (int j = i * 2; j < SIZE; j += i) {
                    primes[j] = true;
                }
            }
        }
    }

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        makePrimeTable();
        T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            N = Integer.parseInt(br.readLine());
            res = 0;

            for (int i = 2; i <= N / 2; i++) {
                if (!primes[i] && !primes[N - i]) {
                    res++;
                }
            }

            sb.append(res).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
