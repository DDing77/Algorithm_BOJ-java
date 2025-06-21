import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private long N;
    private int res;

    private void solution() throws IOException {
        N = Long.parseLong(br.readLine());

        long M = 1;
        res = 1;

        if (N == 0) {
            res = 0;
        }

        while (M < N) {
            res++;
            M *= 2;
        }
        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        main.solution();
    }
}
