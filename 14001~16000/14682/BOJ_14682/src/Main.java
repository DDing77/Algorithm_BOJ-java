import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private long N;
    private int K;
    private long res;

    private void solution() throws IOException {

        N = Long.parseLong(br.readLine());
        K = Integer.parseInt(br.readLine());

        res = N;
        while (K-- > 0) {
            N *= 10;
            res += N;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
