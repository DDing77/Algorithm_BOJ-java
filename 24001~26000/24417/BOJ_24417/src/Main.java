import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int MOD = 1_000_000_007;

    private int N;


    private void solution() throws IOException {

        N = Integer.parseInt(br.readLine());

        int x = 1;
        int y = 1;
        int z = 0;
        for (int i = 3; i <= N; i++) {
            z = (x + y) % MOD;
            x = y;
            y = z;
        }

        sb.append(z).append(" ").append(N - 2);

        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
