import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    int N;
    long[] fib;

    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        if (N <= 3) {
            System.out.println("1");
            return;
        }

        fib = new long[N + 1];

        fib[1] = 1L;
        fib[2] = 1L;
        fib[3] = 1L;

        for (int i = 4; i <= N; i++) {
            fib[i] = fib[i - 1] + fib[i - 3];
        }

        System.out.println(fib[N]);
    }

    public static void main(String[] args) throws IOException {
        new Main().solution();
    }
}
