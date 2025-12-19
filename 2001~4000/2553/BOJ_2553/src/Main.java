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

        long cur = 1L;

        for (int i = 1; i <= N; i++) {
            cur *= i;

            cur %= 10000000;
            while (cur % 10 == 0) {
               cur /= 10;
            }
        }

        System.out.println(cur % 10);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
