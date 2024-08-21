import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static final StringBuilder sb = new StringBuilder();

    private static final int LENGTH = 100_001;
    private static final int MOD = 1_000_000_009;

    private int[] oddDp;
    private int[] evenDp;

    private int T;
    private int N;

    private void initDp() {

        oddDp = new int[LENGTH];
        evenDp = new int[LENGTH];

        oddDp[1] = 1;
        oddDp[2] = 1;
        oddDp[3] = 2;

        evenDp[2] = 1;
        evenDp[3] = 2;

        for (int i = 4; i < LENGTH; i++) {
            evenDp[i] = ((oddDp[i - 1] + oddDp[i - 2]) % MOD + oddDp[i - 3]) % MOD;
            oddDp[i] = ((evenDp[i - 1] + evenDp[i - 2]) % MOD + evenDp[i - 3]) % MOD;
        }
    }

    private void solution() throws IOException {

        initDp();

        T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            sb.append(oddDp[N]).append(" ").append(evenDp[N]).append('\n');
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}
