import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        if (N % 2 == 0) {
            System.out.println(N / 2);
            return;
        }

        for (int i = 3; i <= Math.sqrt(N); i++) {
            if (N % i == 0) {
                System.out.println(N - N / i);
                return;
            }
        }

        System.out.println(N - 1);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
