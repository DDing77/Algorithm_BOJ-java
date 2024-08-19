import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int MOD = 16_769_023;

    private int N;
    private int res;

    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        int pre = 1;
        res = 1;
        for (int i = 1; i <= N; i++) {
            res = pre;

            if ((i & 1) == 1) {
                res *= 2;
                res %= MOD;
            }

            pre = res;
        }

        System.out.println(res);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}