import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();
    public static StringTokenizer st;

    private static final int MOD = 1_000_000_009;

    private int N;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
            return;
        }

        res = 2;
        for (int i = 2; i < N; i++) {
            res = ((res + res) % MOD + res) % MOD;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
