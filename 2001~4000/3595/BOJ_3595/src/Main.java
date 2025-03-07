import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int a;
    private int b;
    private int c;
    private int resMin;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        resMin = Integer.MAX_VALUE;

        for (int i = 1; i * i * i <= N; i++) {
            if (N % i != 0) {
                continue;
            }
            for (int j = i; j * i <= N; j++) {
                if (N / i % j != 0) {
                    continue;
                }
                int temp = N / i;
                temp /= j;
                int res = i * j + (i + j) * temp;
                if (resMin > res) {
                    resMin = res;
                    a = i;
                    b = j;
                    c = temp;
                }
            }
        }

        System.out.println(a + " " + b + " " + c);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
