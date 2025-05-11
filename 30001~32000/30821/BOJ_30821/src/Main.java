import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private int N;
    private long res;

    private void solution() throws IOException {
        N = Integer.parseInt(br.readLine());

        res = 1L;
        for (int i = 0; i < 5; i++) {
            res *= (N - i);
        }

        System.out.println(res / 120);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
