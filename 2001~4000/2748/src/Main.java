import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] fib;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        fib = new long[N + 1];
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= N; ++i) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        System.out.println(fib[N]);
    }
}
// a 1 2 3  b 1 2 3
//   2 1 1    1 1 1

//   1        1 3  -> 2
//   1 2      2    -> 2
//   2        3     -> 1
//   3        2     -> 1
//   1 3      1      -> 2