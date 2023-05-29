import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int M, N;
    static boolean[] isPrime;

    static void getPrime() {
        isPrime[0] = true;
        isPrime[1] = true;

        for (int i = 2; i <= Math.sqrt(isPrime.length); i++) {
            if (isPrime[i]) continue;
            for (int j = i * i; j < isPrime.length; j += i) isPrime[j] = true;
        }
    }

    static void solution() {
        StringBuilder sb = new StringBuilder();
        int sum = 0;
        int min = 0;
        boolean first = false;

        for (int i = M; i <= N; i++) {
            if (!isPrime[i]) {
                sum += i;
                if (!first) {
                    min = i;
                    first = true;
                }

            }
        }
        sb.append(sum).append('\n').append(min);
        if(sum == 0) System.out.println(-1);
        else System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        M = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());

        isPrime = new boolean[N + 1];
        getPrime();
        solution();

    }
}
