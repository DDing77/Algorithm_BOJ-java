import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private int N;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        for (int i = 1; i <= Math.sqrt(N); i++) {
            if (i * i == N) {
                res += i;
            } else if (N % i == 0) {
                res += i + N / i;
            }
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
