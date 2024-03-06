import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final StringBuilder sb = new StringBuilder();

    long K;
    long[] pow;

    private void makePowTable() {

        pow = new long[65];
        pow[0] = 1;

        for (int i = 1; i < pow.length; i++) {
            pow[i] = pow[i - 1] * 2;
        }
    }

    private int recur(long K) {
        if (K == 1) {
            return 0;
        }

        for (int i = 0; i < pow.length; i++) {
            if (pow[i] >= K) {
                return 1 - recur(K - pow[i - 1]);
            }
        }

        return 0;
    }

    private void solution() throws IOException {

        K = Long.parseLong(br.readLine());

        makePowTable();

        System.out.println(recur(K));
    }

    public static void main(String[] args) throws IOException {

        Main main = new Main();
        main.solution();
    }
}